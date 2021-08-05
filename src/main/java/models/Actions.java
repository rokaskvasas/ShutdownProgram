package models;


import constants.Buttons;

import java.io.IOException;

public class Actions {


    public static void oneHour(){
        try{
        Runtime.getRuntime().exec("cmd.exe /C" + Buttons.cmd3600);

           }catch(IOException e) {
        e.printStackTrace();
        }
    }
    public static void twoHour(){
        try {
            Runtime.getRuntime().exec("cmd.exe /C" + Buttons.cmd7200);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void abort(){
        try {
            Runtime.getRuntime().exec("cmd.exe /C"+ Buttons.cmdAbort);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

