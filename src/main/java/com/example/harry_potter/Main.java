package com.example.harry_potter;


import com.example.harry_potter.classobject.Player;

import static com.example.harry_potter.Level.Level0.level0;
import static com.example.harry_potter.Level.Level1.level1;
import static com.example.harry_potter.Level.Level2.level2;
import static com.example.harry_potter.Level.Level3.level3;
import static com.example.harry_potter.Level.Level4.level4;
import static com.example.harry_potter.Level.Level5.level5;


public class Main {
    public static void main(String[] args) {
        level0();
    }
    public static void menu(Player player, int level){
        if (level == 1) {
            System.out.println("Début de la première année.");
            level1(player);
        }
        else if (level == 2) {
            System.out.println("Début de la seconde année.");
            level2(player);
        }
        else if (level == 3) {
            System.out.println("Début de la troisième année.");
            level3(player);
        }
        else if (level == 4) {
            System.out.println("Début de la quatrième année.");
            level4(player);
        }
        else if (level == 5) {
            System.out.println("Début de la cinquième année.");
            level5(player);
        }

    }
}