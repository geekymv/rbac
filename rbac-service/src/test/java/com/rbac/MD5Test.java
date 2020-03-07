package com.rbac;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MD5Test {

    @Test
    public void test() {
        String password = "123456";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encPass = passwordEncoder.encode(password);
        System.out.println("encPass = " + encPass);

        System.out.println(passwordEncoder.matches(password, encPass));
    }

}
