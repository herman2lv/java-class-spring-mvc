package com.hrm.springmvcdemo.service.impl;

import com.hrm.springmvcdemo.service.EncryptionService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class EncryptionServiceImpl implements EncryptionService {
    @Override
    public String digest(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(input.getBytes());
            byte[] bytes = messageDigest.digest();
            BigInteger number = new BigInteger(1, bytes);
            return number.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
