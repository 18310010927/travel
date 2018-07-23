package com.travelcc.travelcc;

import com.travelcc.utils.EncryptionUtils;

public class Test {
    public static void main(String [] args){
        String data="{ 'data':'1'}";
        try{
            String  a = EncryptionUtils.encryption(data);
            String b = EncryptionUtils.deciphering(a);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
