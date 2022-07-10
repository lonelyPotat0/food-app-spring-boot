package com.dom.food.user.services;

import com.dom.food.ultilities.BCryptPassword;
import com.dom.food.user.mapper.UserMapper;
import com.dom.food.user.models.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    BCryptPassword bcrypt = new BCryptPassword();

    public ResponseEntity<?> createUser(UserModel userModel) {
        System.out.println("////////" + userModel);
        if (this.isExistByPhoneNumber(userModel)) {
            return ResponseEntity.badRequest().body("phone number already taken");
        }
        if (this.existsByEmail(userModel.getEmail())) {
            return ResponseEntity.badRequest().body("email already taken");
        }

        userModel.setPassword(bcrypt.HashPassword(userModel.getPassword()));
        return this.userMapper.createUser(userModel) ? ResponseEntity.ok().body("created")
                : ResponseEntity.badRequest().body("failed");
    }

    public ResponseEntity<?> getUserInformation(Integer id) {
        return ResponseEntity.ok().body(this.userMapper.getUser(id));
    }

    public ResponseEntity<?> updateUser(UserModel userModel) {
        if (this.isExistByPhoneNumber(userModel)) {
            return ResponseEntity.badRequest().body("phone number already taken");
        }
        return this.userMapper.updateUser(userModel) ? ResponseEntity.ok().body("updated")
                : ResponseEntity.badRequest().body("failed");
    }

    public ResponseEntity<?> deleteUser(Integer id) {
        return this.userMapper.deleteUser(id) ? ResponseEntity.ok().body("deleted")
                : ResponseEntity.badRequest().body("failed");
    }

    private boolean isExistByPhoneNumber(UserModel userModel) {
        return this.userMapper.existsByPhone(userModel);
    }

    private boolean existsByEmail(String email) {
        return this.userMapper.existsByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println(" =================?" + email);

        UserModel user = userMapper.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found in the database");
        } else {
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), authorities);
    }
}
