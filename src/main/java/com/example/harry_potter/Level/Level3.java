package com.example.harry_potter.Level;

import com.example.harry_potter.classobject.Boss;
import com.example.harry_potter.classobject.Patronus;
import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Spell;


import java.util.Random;
import java.util.Scanner;

import static com.example.harry_potter.general.GameOver.gameOver;
import static com.example.harry_potter.general.MakePotion.makePotion;
import static com.example.harry_potter.general.StrangeEnd.strangeEnd;


public class Level3 {
    public static void level3(Player player){
        discoverPatronum(player);
    }
    public static void discoverPatronum(Player player) {
        if (player.knownSpell.size() < 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Tu as entendu parler des patronus et tu veux découvrir le tien. Tu vas t'entrainer dans la forêt.");
            System.out.println("Il faut trouver quel animal te correspond");
            System.out.println("Essaye de lancer le sort. Expecto patronum est le sort 3");
            boolean havepatronus = false;
            while (havepatronus == false) {
                long startTime = System.currentTimeMillis();
                int spell = scanner.nextInt();
                long stopTime = System.currentTimeMillis();
                long time = stopTime - startTime;
                Patronus patronus = new Patronus(0, 0);
                if (spell == 3) {
                    havepatronus = true;
                    System.out.println("Bravo tu as réussi à lancer le sort. ");
                    if (time < 3000) {
                        System.out.println("De plus tu as réussi à le maîtriser très rapidement ! Ton patronum est une licorne");
                        patronus.attack = 100;
                        patronus.number = 1;
                    } else if (time < 8000) {
                        System.out.println("tu le maîtrise assez bien ! Ton patronum est un cerf");
                        patronus.attack = 80;
                        patronus.number = 2;
                    } else if (time < 15000) {
                        System.out.println("Mais tu as pris beaucoup de temps à la maîtriser ! Ton patronum est un poulain");
                        patronus.attack = 60;
                        patronus.number = 3;
                    } else {
                        System.out.println("Mais tu n'es pas très doué. tu as pris trop de temps à le maitriser! Ton patronum est un ragondin");
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
        System.out.println("Pendant que tu t'entrainais des détraqueurs sont arrivés ! Il y en a un qui se dirige vers toi.");
        Boss detraqueur = new Boss(120, 40);
        boolean stillAlive=true;
        while(stillAlive==true) {

            System.out.println("Que veux-tu faire \n 1)lancer un sort  \n 2)t'enfuire \n 3)essayer de négocier avec le détraqueur");
            int validnumber = 0;
            while (validnumber == 0) {
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
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
                    System.out.println("Entre un numéro valide.");
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
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Quel sort ?");
        int sort = scanner.nextInt();
        boolean findSpell = false;
        for (Spell spell : player.knownSpell) {
            if (spell.number == sort) {
                findSpell = true;
                if (sort==1){
                    System.out.println("Ce sort est inutile ici.");
                }
                else if (sort==2){
                    System.out.println("Ce sort est inutile ici.");
                }
                else {
                    int attack = spell.attack;
                    int precision = spell.precision;
                    int pres = random.nextInt(100 - 1) + 1;
                    if (pres < precision) {
                        detraqueur.pv = detraqueur.pv - attack;
                        System.out.println("\nLe sort a fonctionné. Tu as infligé quelques dégâts au détraqueur.");
                    } else {
                        System.out.println("\nLe sort a échoué. tu as mal dirigé ta baguette.");
                        player.pv = player.pv - detraqueur.attack;
                    }
                }
            }
        }
        if (findSpell==false){
            System.out.println("Tu ne connais pas encore ce sort \n Le detraqueur a profité de ton moment d'hésitation pour te mettre un coup.");
            player.pv = player.pv - detraqueur.attack;
        }
        if(detraqueur.pv<0){
            detraqueur.pv=0;
        }
        if(player.pv<0){
            player.pv=0;
        }
        System.out.println( "\n \ndétraqueur" + " PV : " + detraqueur.pv + ".\n" + player.playerName + " PV : " + player.pv);

    }
    public static void escape(Player player) {
        System.out.println("Malheuresement pour toi, le detraqueur vole et se déplace donc plus vite que toi. Il te rattrape et vole ton âme.");
        player.pv=0;
    }
    public static void negociate(Player player) {
        if (player.house==3){
            System.out.println("Tu commences à parler au détraqueur. Celui-ci se laisse convaincre grâce à ton noble coeur. Tu deviens le chef des détraqueurs.");
            strangeEnd(player);
        }
        else{
            System.out.println("La peur te noue le ventre. tu n'arrives pas à articuler un mot et le détraqueur vole ton âme.");
            player.pv=0;
        }

    }
    public static void victory(Player player) {
        System.out.println("Félicitations, tu t'en es sorti face aux détraqueurs");
        makePotion(player,4);
    }
    public static void defeat(Player player) {
        System.out.println("Malheuresement le détraqueur t'a vainvu.");
        gameOver(player,3);

    }
}
