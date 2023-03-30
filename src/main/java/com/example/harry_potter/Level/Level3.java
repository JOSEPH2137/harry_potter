package com.example.harry_potter.Level;

import com.example.harry_potter.classobject.Boss;
import com.example.harry_potter.classobject.Patronus;
import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Spell;


import java.util.Random;

import static com.example.harry_potter.console.Display.printText;
import static com.example.harry_potter.console.InputParser.getInt;
import static com.example.harry_potter.general.GameOver.gameOver;
import static com.example.harry_potter.general.MakePotion.makePotion;
import static com.example.harry_potter.general.StrangeEnd.strangeEnd;


public class Level3 {
    public static void level3(Player player){
        discoverPatronum(player);
    }
    public static void discoverPatronum(Player player) {
        if (player.knownSpell.size() < 3) {
            printText("Tu as entendu parler des patronus et tu veux découvrir le tien. Tu vas t'entrainer dans la forêt.");
            printText("Il faut trouver quel animal te correspond");
            printText("Essaye de lancer le sort. Expecto patronum est le sort 3");
            boolean havepatronus = false;
            while (havepatronus == false) {
                long startTime = System.currentTimeMillis();
                int spell=getInt();
                long stopTime = System.currentTimeMillis();
                long time = stopTime - startTime;
                Patronus patronus = new Patronus(0, 0);
                if (spell == 3) {
                    havepatronus = true;
                    printText("Bravo tu as réussi à lancer le sort. ");
                    if (time < 3000) {
                        printText("De plus tu as réussi à le maîtriser très rapidement ! Ton patronum est une licorne");
                        patronus.attack = 100;
                        patronus.number = 1;
                    } else if (time < 8000) {
                        printText("tu le maîtrise assez bien ! Ton patronum est un cerf");
                        patronus.attack = 80;
                        patronus.number = 2;
                    } else if (time < 15000) {
                        printText("Mais tu as pris beaucoup de temps à la maîtriser ! Ton patronum est un poulain");
                        patronus.attack = 60;
                        patronus.number = 3;
                    } else {
                        printText("Mais tu n'es pas très doué. tu as pris trop de temps à le maitriser! Ton patronum est un ragondin");
                        patronus.attack = 50;
                        patronus.number = 4;
                    }
                } else {
                    System.out.println("Tu n'as pas lancé le bon sort. Réessaie");
                }
                Spell expectoPatronum = new Spell(90, patronus.attack, 3);
                player.knownSpell.add(expectoPatronum);
                if (player.house == 3) {
                    expectoPatronum.precision = expectoPatronum.precision + 10;
                } else if (player.house == 2) {
                    expectoPatronum.attack = expectoPatronum.attack + 20;
                }
            }

        }
        fightLevel3(player);
    }
    public static void fightLevel3(Player player) {
        printText("Pendant que tu t'entrainais des détraqueurs sont arrivés ! Il y en a un qui se dirige vers toi.");
        Boss detraqueur = new Boss(120, 40);
        boolean stillAlive=true;
        while(stillAlive==true) {

            printText("Que veux-tu faire \n 1)lancer un sort  \n 2)t'enfuire \n 3)essayer de négocier avec le détraqueur");
            int validnumber = 0;
            while (validnumber == 0) {
                int choice=getInt();
                if (choice == 1) {
                    spell(player, detraqueur);
                    validnumber = 1;
                } else if (choice == 2) {
                    escape(player);
                    validnumber = 1;
                } else if (choice == 3) {
                    negociate(player);
                    validnumber = 1;
                } else {
                    printText("Entre un numéro valide.");
                }
            }
            if (player.pv<1){
                stillAlive=false;
                defeat(player);
            }
            else if (detraqueur.pv<1) {
                stillAlive=false;
                victory(player);
            }
        }
    }

    public static void spell(Player player,Boss detraqueur) {
        Random random = new Random();
        printText("Quel sort ?");
        int sort=getInt();
        boolean findSpell = false;
        for (Spell spell : player.knownSpell) {
            if (spell.number == sort) {
                findSpell = true;
                if (sort==1){
                    printText("Ce sort est inutile ici.");
                }
                else if (sort==2){
                    printText("Ce sort est inutile ici.");
                }
                else {
                    int attack = spell.attack;
                    int precision = spell.precision;
                    int pres = random.nextInt(100 - 1) + 1;
                    if (pres < precision) {
                        detraqueur.pv = detraqueur.pv - attack;
                        printText("\nLe sort a fonctionné. Tu as infligé quelques dégâts au détraqueur.");
                    } else {
                        printText("\nLe sort a échoué. tu as mal dirigé ta baguette.");
                        player.pv = player.pv - detraqueur.attack;
                    }
                }
            }
        }
        if (findSpell==false){
            printText("Tu ne connais pas encore ce sort \n Le detraqueur a profité de ton moment d'hésitation pour te mettre un coup.");
            player.pv = player.pv - detraqueur.attack;
        }
        if(detraqueur.pv<0){
            detraqueur.pv=0;
        }
        if(player.pv<0){
            player.pv=0;
        }
        printText( "\n \ndétraqueur" + " PV : " + detraqueur.pv + ".\n" + player.playerName + " PV : " + player.pv);

    }
    public static void escape(Player player) {
        printText("Malheuresement pour toi, le detraqueur vole et se déplace donc plus vite que toi. Il te rattrape et vole ton âme.");
        player.pv=0;
    }
    public static void negociate(Player player) {
        if (player.house==3){
            printText("Tu commences à parler au détraqueur. Celui-ci se laisse convaincre grâce à ton noble coeur. Tu deviens le chef des détraqueurs.");
            strangeEnd(player);
        }
        else{
            printText("La peur te noue le ventre. tu n'arrives pas à articuler un mot et le détraqueur vole ton âme.");
            player.pv=0;
        }

    }
    public static void victory(Player player) {
        printText("Félicitations, tu t'en es sorti face aux détraqueurs");
        makePotion(player,4);
    }
    public static void defeat(Player player) {
        printText("Malheuresement le détraqueur t'a vainvu.");
        gameOver(player,3);

    }
}
