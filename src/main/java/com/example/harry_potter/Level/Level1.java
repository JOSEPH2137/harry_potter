package com.example.harry_potter.Level;

import com.example.harry_potter.classobject.Boss;
import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Potion;
import com.example.harry_potter.classobject.Spell;

import java.util.Random;
import java.util.Scanner;

import static com.example.harry_potter.general.GameOver.gameOver;
import static com.example.harry_potter.general.MakePotion.makePotion;


public class Level1 {
    public static void level1(Player player){
        Boss troll = new Boss( 100, 20);
        Spell wingardiumLeviosa = new Spell(75,40,1);
        Potion lifePotion= new Potion(1);
        if (player.knownSpell.size()<1) {
            player.knownSpell.add(wingardiumLeviosa);
        }
        if (player.knownPotion.size()<1) {
            player.knownPotion.add(lifePotion);
        }
        System.out.println("tu sais maintenant réalisé une potion de vie. C'est la potion numéro 1");
        System.out.println("tu as appris le sort wingardium leviosa. C'est le sort numéro 1");
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
        boolean playlevel=true;
        while (playlevel == true) {
            System.out.println("\nQue veux tu faire : \n 1)lancer un sort \n 2)fuir \n 3)combattre à main nue.");
            int choice = scanner.nextInt();
            if (choice == 1) {
                spell(player,troll);
            } else if (choice == 2) {
                escape(player,troll);
            } else if (choice == 3) {
                fight(player,troll);
            }
            if (troll.pv < 1) {
                playlevel = false;
                victory(player);

            } else if (player.pv < 1) {
                defeat(player);
                playlevel = false;
            } else {
                System.out.println("\n \nTroll" + " PV : " + troll.pv + ".\n" + player.playerName + " PV : " + player.pv);
            }
        }
    }
    public static void spell(Player player,Boss troll) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Quel sort ?");
        int sort = scanner.nextInt();
        boolean findSpell = false;
        for (Spell spell : player.knownSpell) {
            if (spell.number == sort) {
                findSpell = true;
                int attack = spell.attack;
                int precision = spell.precision;
                int pres = random.nextInt(100 - 1) + 1;
                if (pres < precision) {
                    troll.pv = troll.pv - attack;
                    System.out.println("\nLe sort a fonctionné. tu as soulevé une caisse et elle s'est fracassé sur la tête du troll");
                } else {
                    System.out.println("\nLe sort a échoué. tu as mal dirigé ta baguette.");
                    player.pv = player.pv - troll.attack;
                }
            }
        }
        if (findSpell == false) {
            System.out.println("Tu ne connais pas encore ce sort \n Le troll a profité de ton moment d'hésitation pour te mettre un coup.");
            player.pv = player.pv - troll.attack;
        }
    }
    public static void escape(Player player,Boss troll) {
        System.out.println("Tu trébuches en t'enfuyant. le troll te décapite.");
        player.pv = 0;
    }
    public static void fight(Player player,Boss troll) {
        player.pv = player.pv - 50;
        troll.pv = troll.pv + 1;
        System.out.println("tu es trop téméraire, tu ne supporteras certainement pas un autre assault comme celui là ");
    }
    public static void victory(Player player) {
        System.out.println("Bravo, le troll est mort");
        makePotion(player,2);

    }
    public static void defeat(Player player) {
        gameOver(player,1);
    }

}
