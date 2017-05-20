package com.tcs.iou.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by 26HW011447-PC on 5/19/2017.
 */
public class PasswordEncrypter {

    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        long time = System.currentTimeMillis();
        System.out.println(encoder.encode("password"));
        System.out.println((System.currentTimeMillis()-time));


    }

}
