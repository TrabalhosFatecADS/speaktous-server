package com.speakToUs.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GerarSenha {

    public static String senhaMD5(String senha){
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");

            m.update( senha.getBytes(), 0 , senha.length() );

            byte[] digest = m.digest();

            return new BigInteger(1,digest).toString(16);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
