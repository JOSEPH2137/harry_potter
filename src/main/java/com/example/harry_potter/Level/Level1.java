package com.example.harry_potter.Level;

import com.example.harry_potter.classobject.Boss;
import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Potion;
import com.example.harry_potter.classobject.Spell;
import com.example.harry_potter.general.Color;

import java.util.Random;
import java.util.Scanner;

import static com.example.harry_potter.general.GameOver.gameOver;
import static com.example.harry_potter.Main.menu;


public class Level1 {
    public static void level1(Player player){
        Boss troll = new Boss( 100, 20);
        Spell wingardiumLeviosa = new Spell(75,40,1);
        Potion lifePotion= new Potion(10);
        player.knownSpell.add(wingardiumLeviosa);
        player.knownPotion.add(lifePotion);
        System.out.println("tu sais maintenant réalisé une potion de vie. le numéro qui lui est associé est le numéro 10");
        System.out.println("tu as appris le sort wingardium leviosa. Pour l'utiliser tape 1 dans la console");
        System.out.println("un troll se balade dans les toilettes des filles. Tu décides d'aller le combattre.");
        if (player.house==3){
            wingardiumLeviosa.precision=wingardiumLeviosa.precision+20;
        }
        else if (player.house==2){
            wingardiumLeviosa.attack=wingardiumLeviosa.attack+10;
        }
        else if (player.house==1){
            troll.attack=troll.attack-5;
        }
        fightlevel1(player,troll);

    }
    public static void fightlevel1(Player player,Boss troll) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String message = "";
        boolean playlevel=true;
        while (playlevel == true) {
            System.out.println("\nQue veux tu faire : \n 1)lancer un sort \n 2)fuir \n 3)combattre à main nue.");
            message = "";
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Quel sort ?");
                int sort = scanner.nextInt();
                boolean findSpell = false;
                for (Spell spell : player.knownSpell) {
                    if (spell.number == sort) {
                        findSpell = true;
                        int attack = spell.attack;
                        int precision = spell.precision ;
                        int pres = random.nextInt(100 - 1) + 1;
                        if (pres < precision ){
                            troll.pv = troll.pv - attack;
                            message = "\nLe sort a fonctionné. tu as soulevé une caisse et elle s'est fracassé sur la tête du troll;";
                        } else {
                            message = "\nLe sort a échoué. tu as mal dirigé ta baguette.";
                            player.pv = player.pv - troll.attack;
                        }
                    }
                }
                if (findSpell==false){
                    System.out.println("Tu ne connais pas encore ce sort \n Le troll a profité de ton moment d'hésitation pour te mettre un coup.");
                    player.pv = player.pv - troll.attack;
                }
            } else if (choice == 2) {
                System.out.println("Tu trébuches en t'enfuyant. le troll te décapite.");
                player.pv = player.pv - 10000;
            } else if (choice == 3) {
                player.pv = player.pv - 50;
                troll.pv = troll.pv + 1;
                message = "tu es trop téméraire, tu ne supporteras certainement pas un autre assault comme celui là ";
            }
            if (troll.pv < 1) {
                System.out.println("Bravo, le troll est mort");
                level1_5(player);
                playlevel = false;
            } else if (player.pv < 1) {
                gameOver();
                playlevel = false;
            } else {
                System.out.println(message + "\n \nTroll" + " PV : " + troll.pv + ".\n" + player.playerName + " PV : " + player.pv);
            }
        }
    }
    public static void level1_5(Player player){
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
                    if (potion.number==10){
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
        menu(player,2);
    }
}
