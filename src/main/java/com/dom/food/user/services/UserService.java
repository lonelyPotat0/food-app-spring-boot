package com.dom.food.user.services;

import com.dom.food.ultilities.BCryptPassword;
import com.dom.food.user.mapper.UserMapper;
import com.dom.food.user.models.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    BCryptPassword bcrypt = new BCryptPassword();

    public UserModel createUser(UserModel userModel) {
        userModel.setPassword(bcrypt.HashPassword(userModel.getPassword()));
        return this.userMapper.createUser(userModel) ? userModel : null;
    }

    public UserModel getUserInformation(Integer id) {
        return this.userMapper.getUser(id);
    }

    public UserModel updateUser(UserModel userModel) {
        return this.userMapper.updateUser(userModel) ? userModel : null;
    }

    public boolean deleteUser(Integer id) {
        return this.userMapper.deleteUser(id);
    }

    public boolean isExistByPhoneNumber(UserModel userModel) {
        return this.userMapper.existsByPhone(userModel);
    }

    public boolean existsByEmail(String email) {
        return this.userMapper.existsByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
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
