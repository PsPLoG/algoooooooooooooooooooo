package com.company.hash;
import java.util.*;

class Q42577 {
    public boolean checkString(String str1 , String str2){
        if(str1.length()>= str2.length()){
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }

        for(int i=0;i<str1.length();i++) {
            if(str1.charAt(i)!= str2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public boolean solution(String[] phone_book) {
        boolean answer = false;

        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book.length;j++){
                if( i!=j){
                    if(checkString(phone_book[i],phone_book[j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
