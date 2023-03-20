package com.example.harry_potter.general;

import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Potion;

import java.util.Scanner;

import static com.example.harry_potter.Main.menu;

public class MakePotion {

    public static void makePotion(Player player,int level){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tu as du temps libre. Veux-tu concocter une potion ?");
        System.out.println(" 1)oui \n 2)non");
        int choice = scanner.nextInt();
        if (choice==1) {
            System.out.println("Laquelle ?");
            choice = scanner.nextInt();
            boolean findPotion = false;
            for (Potion potion : player.knownPotion) {
                if (potion.number == choice) {
                    findPotion = true;
                    if (potion.number==1){
                        player.pv=player.pv +20;
                        if (player.house==4){
                            player.pv=player.pv+20;
                        }
                        System.out.println("tu as récupéré de la vie. Tu as maintenant : "+ Color.RED+" PV"+ player.pv+Color.RESET);
                    }
                }
            }
            if (findPotion==false){
                System.out.println("Tu ne maitrise pas encore cette Potion. Tu as raté ta préparation. ");
            }
        }
        menu(player,level);
    }
}
