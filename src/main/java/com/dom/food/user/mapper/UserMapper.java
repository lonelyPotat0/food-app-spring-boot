package com.dom.food.user.mapper;

import com.dom.food.user.models.ChangePasswordRequest;
import com.dom.food.user.models.UserModel;
import org.apache.ibatis.annotations.Mapper;
// import com.dom.food.user.models.IUserModel;

@Mapper
public interface UserMapper {

    boolean existsByPhone(UserModel user);

    boolean createUser(UserModel user);

    UserModel getUser(Integer id);

    boolean updateUser(UserModel user);

    boolean deleteUser(Integer id);

    boolean updateRole(UserModel user);

    UserModel findByEmail(String email);

    boolean existsByEmail(String email);

    boolean updatePassword(ChangePasswordRequest password);
}
