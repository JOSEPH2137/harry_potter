package com.example.harry_potter.Level;

import com.example.harry_potter.classobject.Boss;
import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Spell;

import java.util.Random;
import java.util.Scanner;

import static com.example.harry_potter.general.GameOver.gameOver;
import static com.example.harry_potter.general.MakePotion.makePotion;
import static com.example.harry_potter.general.StrangeEnd.strangeEnd;

public class Level4 {
    public static void level4(Player player){
        System.out.println("Tu a été propulsé dans un cimetière. Voldemort et Pettigrow sont en face de toi.");
        boolean stillAlive=true;
        Boss voldemort= new Boss(400,50);
        while(stillAlive==true) {

            System.out.println("Que veux-tu faire \n 1)lancer un sort  \n 2)t'enfuire \n 3)essayer de négocier avec Voldemort.");
            int validnumber = 0;
            while (validnumber == 0) {
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                if (choice == 1) {
                    spellfail(player);
                    validnumber = 1;
                } else if (choice == 2) {
                    escape(player,voldemort);
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
            else if (voldemort.pv<1){
                stillAlive=false;
                victory(player);
            }

        }
    }
    public static void negociate(Player player) {
        if (player.house==2){
            System.out.println("Tu commences à parler à Voldemort. Celui-ci se laisse convaincre car tu es à Serpentard. Il t'enrôle dans ses troupes.");
            strangeEnd(player);
        }
        else{
            System.out.println("La peur te noue le ventre. tu n'arrives pas à articuler un mot et Voldemort lance un avada kedavra.");
            player.pv=0;
        }

    }
    public static void spellfail(Player player) {
        System.out.println("La peur te noue le ventre. tu n'arrives pas à articuler un mot et Voldemort lance un avada kedavra.");
        player.pv=0;
    }
    public static void escape(Player player, Boss voldemort) {
        System.out.println("Que veux-tu faire \n 1)t'enfuire à gauche  \n 2)t'enfuire à droite");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice==1){
            System.out.println("Voldemort te rattrape et lance un Avada kedavra.");
            player.pv=0;
        }
        else if (choice==2){
            System.out.println("tu aperçois le portauloin. Que faire : \n 1)lancer un sort  \n 2)Courir jusqu'au portauloin.");
            int action = scanner.nextInt();
            if (action==1){
                spell(player, voldemort);
            }
            else if (action==2){
                System.out.println("Tu cours à découvert. Voldemort lance un avada kedavra.");
                player.pv=0;

            }
            else{
                System.out.println("Tu n'as pas su décider quoi faire, Voldemort lance un avada kedavra.");
                player.pv=0;
            }

        }
        else{
            System.out.println("Tu n'as pas su te décider où aller, Voldemort lance un avada kedavra.");
            player.pv=0;
        }
    }
    public static void spell(Player player,Boss voldemort) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel sort ?");
        int sort = scanner.nextInt();
        boolean findSpell = false;
        for (Spell spell : player.knownSpell) {
            if (spell.number == sort) {
                findSpell = true;
                if (sort==1){
                    System.out.println("Tu as soulevé le portauloin, Mais Voldemort a le temps de lancer un avada kedavra.");
                    player.pv=0;
                }
                else if (sort==2){
                    System.out.println("tu as attrapé le portauloin");
                    voldemort.pv=0;
                }
                else {
                    System.out.println("Voldemort n'a pas peur de ton Patonum. Il lance un avada Kedavra.");
                    player.pv=0;
                }
            }
        }
        if (findSpell==false){
            System.out.println("Tu ne connais pas encore ce sort \n Voldemort a profité de ton moment d'hésitation pour lancer un Avada Kedavra.");
            player.pv = 0;
        }
    }
    public static void victory(Player player) {
        System.out.println("Félicitations, tu es revenu à Poudlard. tu as échappé à Voldemort");
        makePotion(player,5);
    }
    public static void defeat(Player player) {
        System.out.println("Malheuresement Voldemort t'a tué.");
        gameOver(player,4);

    }
}
