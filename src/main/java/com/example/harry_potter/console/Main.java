package com.example.harry_potter.console;


import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.console.InputParser;

import static com.example.harry_potter.Level.Level0.level0;

import static com.example.harry_potter.Level.Level1.level1;
import static com.example.harry_potter.Level.Level2.level2;
import static com.example.harry_potter.Level.Level3.level3;
import static com.example.harry_potter.Level.Level4.level4;
import static com.example.harry_potter.Level.Level5.level5;
import static com.example.harry_potter.Level.Level6.level6;
import static com.example.harry_potter.Level.Level7.level7;


public class Main {

    public static InputParser inputParser = new InputParser();
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
        else if (level == 6) {
            System.out.println("Début de la sixième année.");
            level6(player);
        }
        else if (level == 7) {
            System.out.println("Début de la septième année.");
            level7(player);
        }
        else  {
            System.out.println("Bravo tu as gagné.");
            System.exit(0);
        }

    }
}