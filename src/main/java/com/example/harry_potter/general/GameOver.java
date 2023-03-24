package com.example.harry_potter.general;

import com.example.harry_potter.classobject.Player;

import java.util.Scanner;

import static com.example.harry_potter.Main.menu;

public class GameOver {
    public static void  gameOver(Player player, int level){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tu as perdu. espèce de naze");
        System.out.println("Veux tu reessayer le niveaux auquel tu as perdu ?");
        System.out.println(" 1)oui \n 2)non");
        int choice = scanner.nextInt();
        if (choice==1) {
            player.pv=100;
            menu(player,level);
        }
        else {
            System.exit(0);
        }
    }

}
