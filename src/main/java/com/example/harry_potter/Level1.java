package com.example.harry_potter;

import java.util.Scanner;

public class Level1 {
    public static void level1(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pour accéder au level 1, tape 1.");
        int  lvl= scanner.nextInt();
        if (lvl==1){
            playLevel1(player);
        }
        else {
            System.out.println("Fin de l'aventure. Tu n'as même pas réussi à appuyer sur 1.");
        }
    }
    public static void playLevel1(Player player) {
        System.out.println("un troll se balade dans le chateau. Comme tu es très courageux mais surtout inconcient, tu décides d'aller le vaincre.");
        System.out.println(player.pet);
    }

}
