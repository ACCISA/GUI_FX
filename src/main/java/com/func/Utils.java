package com.func;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String getTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static  void runScript(){
        try{
            //https://stackoverflow.com/questions/65348890/python-was-not-found-run-without-arguments-to-install-from-the-microsoft-store
            ProcessBuilder builder = new ProcessBuilder("python",System.getProperty("user.dir") + "\\src\\main\\java\\com\\fxproject\\test.py", "1", "4" );
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader readers = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String lines=null;
            while((lines=reader.readLine())!=null){
                System.out.println("lines y " + lines);
            }
            while((lines=readers.readLine())!=null){
                System.out.println("lines x " + lines);
            }
        } catch (Exception e) {
            System.out.println("this didnt work");
            e.printStackTrace();
        }
    }



}
