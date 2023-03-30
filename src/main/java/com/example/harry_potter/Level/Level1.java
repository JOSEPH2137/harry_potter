package com.example.harry_potter.Level;

import com.example.harry_potter.classobject.Boss;
import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Potion;
import com.example.harry_potter.classobject.Spell;

import java.util.Random;


import static com.example.harry_potter.console.Display.printText;
import static com.example.harry_potter.console.InputParser.getInt;
import static com.example.harry_potter.general.GameOver.gameOver;
import static com.example.harry_potter.general.MakePotion.makePotion;


public class Level1 {
    public static void level1(Player player){
        Boss troll = new Boss( 100, 20);
        Spell wingardiumLeviosa = new Spell(75,40,1);
        Potion lifePotion= new Potion(1);
        if (player.knownSpell.size()<1) {
            printText("tu as appris le sort wingardium leviosa. C'est le sort numéro 1");
            player.knownSpell.add(wingardiumLeviosa);
        }
        if (player.knownPotion.size()<1) {
            printText("tu sais maintenant réalisé une potion de vie. C'est la potion numéro 1");
            player.knownPotion.add(lifePotion);
        }

        printText("un troll se balade dans les toilettes des filles. Tu décides d'aller le combattre.");
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

        boolean playlevel=true;
        while (playlevel == true) {
            printText("\nQue veux tu faire : \n 1)lancer un sort \n 2)fuir \n 3)combattre à main nue.");
            int validnumber=0;
            while(validnumber==0) {
                int choice=getInt();
                if (choice == 1) {
                    spell(player, troll);
                    validnumber=1;
                } else if (choice == 2) {
                    escape(player, troll);
                    validnumber=1;
                } else if (choice == 3) {
                    fight(player, troll);
                    validnumber=1;
                }
                else {
                    printText("entre un numéro valide");
                }
            }
            if (troll.pv < 1) {
                playlevel = false;
                victory(player);

            } else if (player.pv < 1) {
                defeat(player);
                playlevel = false;
            } else {
                printText("\n \nTroll" + " PV : " + troll.pv + ".\n" + player.playerName + " PV : " + player.pv);
            }
        }
    }
    public static void spell(Player player,Boss troll) {
        Random random = new Random();
        printText("Quel sort ?");
        int sort=getInt();
        boolean findSpell = false;
        for (Spell spell : player.knownSpell) {
            if (spell.number == sort) {
                findSpell = true;
                int attack = spell.attack;
                int precision = spell.precision;
                int pres = random.nextInt(100 - 1) + 1;
                if (pres < precision) {
                    troll.pv = troll.pv - attack;
                    printText("\nLe sort a fonctionné. tu as soulevé une caisse et elle s'est fracassé sur la tête du troll");
                } else {
                    printText("\nLe sort a échoué. tu as mal dirigé ta baguette.");
                    player.pv = player.pv - troll.attack;
                }
            }
        }
        if (findSpell == false) {
            printText("Tu ne connais pas encore ce sort \n Le troll a profité de ton moment d'hésitation pour te mettre un coup.");
            player.pv = player.pv - troll.attack;
        }
    }
    public static void escape(Player player,Boss troll) {
        printText("Tu trébuches en t'enfuyant. le troll te décapite.");
        player.pv = 0;
    }
    public static void fight(Player player,Boss troll) {
        player.pv = player.pv - 50;
        troll.pv = troll.pv + 1;
        printText("tu es trop téméraire, tu ne supporteras certainement pas un autre assault comme celui là ");
    }
    public static void victory(Player player) {
        printText("Bravo, le troll est mort");
        makePotion(player,2);

    }
    public static void defeat(Player player) {
        gameOver(player,1);
    }

}
