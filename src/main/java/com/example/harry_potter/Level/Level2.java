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

public class Level2 {
    public static void level2(Player player){
        player.house=1;
        Boss basilic = new Boss( 200, 25);
        Boss jedusorBook = new Boss (1,0);
        Spell accio = new Spell(60,1,2);
        player.knownSpell.add(accio);
        System.out.println("tu as appris le sort accio. Pour l'utiliser tape 2 dans la console");
        System.out.println("Tu as découvert la chambre des secrets. Tu fais maintenant face au basilic.");
        if (player.house==3){
            accio.precision=accio.precision+25;
        }
        fightlevel2(player,basilic,jedusorBook);

    }
    public static void fightlevel2(Player player,Boss basilic,Boss jedusorBook) {
        Scanner scanner = new Scanner(System.in);
        String message = "";
        boolean playlevel = true;
        while (playlevel == true) {

            System.out.println("\nQue veux tu faire : \n 1)lancer un sort  \n 2)combattre à main nue \n 3)attendre cacher derrière un pilier");
            message = "";
            int choice = scanner.nextInt();
            if (choice == 1) {
                message=activeSpell(player,basilic,jedusorBook);
            }
            else if (choice==2){
                System.out.println("Le Basilic t'a instantanément transformé en pierre.");
                player.pv = player.pv - 10000;
            }
            else if (choice==3){
                if (player.house==1){
                    System.out.println("Le phoenix de Dumbledore t'apporte l'épée de griffondor.");
                    griffondorSword(basilic,jedusorBook);
                }
                else {
                    System.out.println("Rien ne se passe");
                }
            }
            if (basilic.pv < 1 ) {
                System.out.println("Bravo, le Basilic est mort");
                level2_5(player);
                playlevel = false;
            } else if (player.pv < 1) {
                gameOver();
                playlevel = false;
            }
            else if (jedusorBook.pv<1){
                System.out.println(message);
                System.out.println("Bravo, tu laisses le basilic enfermé à jamais dans la chambre des secrets.");
                level2_5(player);
                playlevel = false;
            }
            else if (jedusorBook.pv>10){
                System.out.println("Le vol c'est mal. Dumbledor t'as retrouvé et tu es banni du monde des sorciers.");
                gameOver();
                playlevel = false;
            }
            else {
                System.out.println(message + "\n \nBasilic" + " PV : " + basilic.pv + ".\n" + player.playerName + " PV : " + player.pv);
            }
        }
    }
    public static void griffondorSword(Boss basilic, Boss jedusorBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nQue veux tu faire : \n 1)voler l'épée de griffondor  \n 2)utiliser l'épée de griffondor pour combattre");
        int choice = scanner.nextInt();
        if (choice==1){
            System.out.println("Le vol c'est mal. Dumbledor t'as retrouvé et tu es banni du monde des sorciers.");
            gameOver();
        }
        else {
            System.out.println("Tu tranches la tête du Basilic");
            basilic.pv = basilic.pv - 10000;
        }
    }
    public static String activeSpell(Player player, Boss basilic,Boss jedusorBook) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Quel sort ?");
        int sort = scanner.nextInt();
        boolean findSpell = false;
        String message = "";
        for (Spell spell : player.knownSpell) {
            if (spell.number == sort) {
                findSpell = true;
                if (sort==1){
                    System.out.println("Ce sort est inutile ici.");
                }
                else {
                    int attack = spell.attack;
                    int precision = spell.precision;
                    int pres = random.nextInt(100 - 1) + 1;
                    if (pres < precision) {
                        jedusorBook.pv = jedusorBook.pv - attack;
                        message = "\nLe sort a fonctionné. Tu as arraché un croc au basilic. Tu peux détruire le cahier de Tom Jedusor.";
                    } else {
                        message = "\nLe sort a échoué. tu as mal dirigé ta baguette.";
                        player.pv = player.pv - basilic.attack;
                    }
                }
            }
        }
        if (findSpell==false){
            System.out.println("Tu ne connais pas encore ce sort \n Le basilic a profité de ton moment d'hésitation pour te mettre un coup.");
            player.pv = player.pv - basilic.attack;
        }
        return message;

    }
    public static void level2_5(Player player){
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
        menu(player,3);
    }

}
