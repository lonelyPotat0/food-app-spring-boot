package com.dom.food.user.services;

import com.dom.food.ultilities.BCryptPassword;
import com.dom.food.user.mapper.UserMapper;
import com.dom.food.user.models.ChangePasswordRequest;
import com.dom.food.user.models.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpResponseException;
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

    public UserModel createUser(UserModel userModel) throws HttpResponseException {
        userModel.setPassword(bcrypt.HashPassword(userModel.getPassword()));
        if (this.existsByEmail(userModel.getEmail())) {
            throw new HttpResponseException(400, "Email already registered");
        }
        if (this.isExistByPhoneNumber(userModel)) {
            throw new HttpResponseException(400, "Phone Number already registered");
        }
        if (this.userMapper.createUser(userModel)) {
            return userModel.setPassword("");
        }
        throw new HttpResponseException(400, "fail");
    }    

    public UserModel getUserInformation(Integer id) {
        return this.userMapper.getUser(id).setPassword(null);
    } 

    public UserModel updateUser(UserModel userModel) throws HttpResponseException {
        if (this.isExistByPhoneNumber(userModel)) {
            throw new HttpResponseException(400, "Phone Number already registered");
        }
        if (this.userMapper.updateUser(userModel)) {
            return userModel;
        }
        throw new HttpResponseException(400, "fail");
    }

    public boolean updatePassword(ChangePasswordRequest password) throws HttpResponseException {
        UserModel user = this.userMapper.getUser(password.getUserId());
        System.out.println("=======1=======>" + user);

        if (bcrypt.mathcPassword(password.getOldPassword(), user.getPassword())) {
            password.setNewPassword(bcrypt.HashPassword(password.getNewPassword()));
            System.out.println("==============>" + password);
            if (this.userMapper.updatePassword(password)) {
                return true;
            }
        }
        throw new HttpResponseException(400, "invalid password or userId");
    }

    public boolean deleteUser(Integer id) throws HttpResponseException {
        if(this.userMapper.deleteUser(id)) {
            return true;
        } 
        throw new HttpResponseException(400, "fail");
    }

    private boolean isExistByPhoneNumber(UserModel userModel) {
        return userModel.getPhone() == null ? false : this.userMapper.existsByPhone(userModel);
    }

    private boolean existsByEmail(String email) {
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
