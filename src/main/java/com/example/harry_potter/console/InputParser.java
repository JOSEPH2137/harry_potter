package com.example.harry_potter.console;

import java.util.Scanner;

public class InputParser {




    public static int getInt(){
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNextInt()){
            sc.nextLine();  // flushes line
        }
        return sc.nextInt();
    }
    public String getName(){
        Scanner sc = new Scanner(System.in);
        String playerName = sc.next();
        return playerName;
    }

}
