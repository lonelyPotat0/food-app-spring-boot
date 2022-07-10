package com.dom.food.ultilities;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptPassword {

    public String HashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }

    public boolean mathcPassword(String rawPassword, String hashed) {
        return BCrypt.checkpw(rawPassword, hashed) ? true : false;
    }
}
