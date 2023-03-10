package com.example.harry_potter;

import java.util.Scanner;

import static com.example.harry_potter.Level1.level1;
import static com.example.harry_potter.Level2.level2;

public class Menu {
    public static void menu(Player player,int level) {
        if (level==1){
            level1(player);
        }
        if (level==2){
            level2(player);
        }

    }

    }
