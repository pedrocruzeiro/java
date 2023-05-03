package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String S = "aabab";
        String temp = "";

        if (S.contains("aaa")){
            System.out.println("-1");
        }

        int result = 0;

        String[] sArray = S.split("");

        for (int i = 0; i < sArray.length; i++){
            if (i == sArray.length -1){
                if (!sArray[i].equals("a")){
                    result+=2;
                }
            }
            else if (sArray[i].equals("a") && sArray[i+1].equals("a")){
                i++;
            }
            else if (sArray[i].equals("a") && !sArray[i+1].equals("a")){
                result+=1;
            }
            else if (!sArray[i].equals("a") && !sArray[i+1].equals("a")){
                if (i == 0 ){
                    result+=2;
                }
                result+=2;
                temp = temp + sArray[i] + "aa";
            }
        }

        System.out.println(result);
        System.out.println(temp);
    }
}