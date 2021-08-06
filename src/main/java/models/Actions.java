package models;


import constants.Text;

import java.io.IOException;

public class Actions {


    public static void oneHour(){
        try{
        Runtime.getRuntime().exec(Text.cmdopen + Text.cmd3600);

           }catch(IOException e) {
        e.printStackTrace();
        }
    }
    public static void twoHour(){
        try {
            Runtime.getRuntime().exec(Text.cmdopen + Text.cmd7200);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void abort(){
        try {
            Runtime.getRuntime().exec(Text.cmdopen+ Text.cmdAbort);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void execute(String number){
        try{
            Runtime.getRuntime().exec(Text.cmdopen +Text.cmdrandom +number);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

