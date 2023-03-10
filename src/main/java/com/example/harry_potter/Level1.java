package com.example.harry_potter;

import java.util.Random;
import java.util.Scanner;

import static com.example.harry_potter.GameOver.gameOver;
import static com.example.harry_potter.Menu.menu;

public class Level1 {
    public static void level1(Player player){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Boss troll = new Boss( 100, 10);
        Spell accio = new Spell(80,20,1);
        String message = "";
        boolean playlevel=true;
        System.out.println("tu as appris le sort accio. Pour l'utiliser tape 1 dans la console");
        if (player.house==3){
            accio.precision=accio.precision+20;
        }
        else if (player.house==2){
            accio.attack=accio.attack+20;
        }
        else if (player.house==1){
            troll.attack=5;
        }
        while (playlevel==true) {

            System.out.println("\nQue veux tu faire : \n 1)lancer un sort \n 2)fuir \n 3)combattre à main nue.");
            message="";
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Quel sort ?");
                int sort = scanner.nextInt();
                if (sort == 1) {
                    int pres = random.nextInt(100 - 0) + 1;
                    if (pres < accio.precision) {
                        troll.pv = troll.pv - accio.attack;
                        message="\nLe sort a fonctionné";
                    }
                    else{
                        message="\nLe sort a échoué";
                    }
                }
                else {
                    System.out.println("Tu ne connais pas encore ce sort \n Le troll a profité de ton moment d'hésitation pour te mettre un coup.");
                }
                player.pv=player.pv-troll.attack;
            }
            else if (choice == 2) {
                System.out.println("Tu trébuches en t'enfuyant. le troll te décapite.");
                player.pv=player.pv-100;
            }
            else if (choice == 3) {
                player.pv=player.pv-50;
                troll.pv = troll.pv-1;
                message = "tu es trop téméraire, tu ne supporteras certainement pas un autre assault comme celui là ";
            }
            if (troll.pv < 1) {
                System.out.println("Bravo, le troll est mort");
                menu(player,2);
                playlevel=false;
            }
            else if (player.pv<1){
                gameOver();
                playlevel=false;
            }
            else {
                System.out.println( message + "\n \nTroll" + " PV : " + troll.pv +".\n" + player.playerName + " PV : " + player.pv);
            }
        }

    }
}
