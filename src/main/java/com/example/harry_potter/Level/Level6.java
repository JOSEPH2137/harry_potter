package com.example.harry_potter.Level;

import com.example.harry_potter.classobject.Boss;
import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Spell;

import java.util.Random;

import static com.example.harry_potter.console.Display.printText;
import static com.example.harry_potter.console.InputParser.getInt;
import static com.example.harry_potter.general.GameOver.gameOver;
import static com.example.harry_potter.general.MakePotion.makePotion;
import static com.example.harry_potter.general.StrangeEnd.strangeEnd;

public class Level6 {
    public static void level6(Player player) {
        Spell spectumsempra = new Spell(75,100,4);
        if (player.knownSpell.size() < 4) {
            printText("tu as appris le sort spectumsempra. C'est le sort numéro 4");
            player.knownSpell.add(spectumsempra);
        }
        Boss mangemort1 = new Boss( 250, 10);
        Boss mangemort2 = new Boss( 200, 20);
        if (player.house==3){
            spectumsempra.precision=spectumsempra.precision+20;
        }
        else if (player.house==2){
            spectumsempra.attack=spectumsempra.attack+50;
        }
        else if (player.house==1){
            mangemort1.attack=mangemort1.attack-5;
            mangemort2.attack=mangemort2.attack-5;
        }
        fightlevel6(player,mangemort1,mangemort2);


    }
    public static void fightlevel6(Player player,Boss mangemort1,Boss mangemort2){
        printText("Deux mangemorts sont entré dans Pouddlard. Tu te précipites vers eux.");
        boolean playlevel=true;
        while(playlevel==true) {
            printText("Tu décides :\n1)De les attaquer en lançant un sort \n2)De leur demander de t'accepter dans leurs rangs.");
            int validnumber = 0;
            while (validnumber == 0) {
                int choice = getInt();
                if (choice == 1) {
                    spell(player, mangemort1 , mangemort2);
                    validnumber = 1;
                } else if (choice == 2) {
                    negociate(player);
                    validnumber = 1;
                }
                else{
                        printText("entre un numéro valide");
                    }

                if (mangemort1.pv < 1 && mangemort2.pv < 1) {
                    playlevel = false;
                    victory(player);

                } else if (player.pv < 1) {
                    defeat(player);
                    playlevel = false;
                } else {
                    printText("\n mangemort1" + " PV : " + mangemort1.pv + ".\n" +"mangemort2" + " PV : " + mangemort2.pv + ".\n"+ player.playerName + " PV : " + player.pv);
                }
            }
        }
    }
    public static void spell(Player player,Boss mangemort1,Boss mangemort2) {
        printText("Quel sort ?");
        int sort=getInt();
        boolean findSpell = false;
        for (Spell spell : player.knownSpell) {
            if (spell.number == sort) {
                findSpell = true;
                int attack = spell.attack;
                int precision = spell.precision;
                if (sort==1||sort==2||sort==3){
                    printText("Ces sorts sont inutiles ici.");
                    printText("Un mangemort a profité de ton moment d'hésitation pour lancer un sort.");
                    player.pv=player.pv-mangemort1.attack;
                }
                else {
                    printText("quel mangemort veux tu attaquer :\n 1)mangemort1 \n 2)mangemort2");
                    int mangemort=getInt();
                    if (mangemort==1){
                        fightmangemort1(player,mangemort1,mangemort2,attack,precision);
                    }
                    else if (mangemort==2){
                        fightmangemort2(player,mangemort1,mangemort2,attack,precision);
                    }
                    else {
                        printText("ton sort a percuté un arbre");
                        player.pv=player.pv-20;
                    }

                }
            }
        }
        if (findSpell==false){
            printText("Tu ne connais pas encore ce sort \n un mangemort a profité de ton moment d'hésitation pour lancer un sort.");
            player.pv = player.pv-mangemort1.attack;
        }
    }
    public static void fightmangemort1(Player player,Boss mangemort1, Boss mangemort2,int attack,int precision){
        Random random = new Random();
        int pres = random.nextInt(100 - 1) + 1;
        if (pres < precision) {
            mangemort1.pv=mangemort1.pv-attack;
            printText("le sort a fonctionné");
            if (mangemort1.pv<1){
                mangemort1.pv=0;
            }
        }
        else if(mangemort1.pv>1){
            player.pv=player.pv-mangemort1.attack;
            printText("le mangemort t'as infligé des dégâts car tu as échoué en lançant ton sort");
        }
        if (mangemort2.pv>1){
            player.pv=player.pv-mangemort2.attack;
            printText("l'autre mangemort t'as infligé des dégâts");
        }

    }
    public static void fightmangemort2(Player player,Boss mangemort1, Boss mangemort2,int attack,int precision){
        Random random = new Random();
        int pres = random.nextInt(100 - 1) + 1;
        if (pres < precision) {
            mangemort2.pv=mangemort2.pv-attack;
            printText("le sort a fonctionné");
            if (mangemort2.pv<1){
                mangemort2.pv=0;
            }
        }
        else if(mangemort2.pv>1){
            player.pv=player.pv-mangemort2.attack;
            printText("le mangemort t'as infligé des dégâts car tu as échoué en lançant ton sort");
        }
        if (mangemort1.pv>1){
            player.pv=player.pv-mangemort1.attack;
            printText("l'autre mangemort t'as infligé des dégâts");
        }

    }
    public static void negociate(Player player){
        if (player.house==2){
            printText("Comme tu es à Serpentard, les mangemorts t'accueille dans leur équipe.");
            strangeEnd(player);
        }
        else{
            printText("l'un des mangemorts lance un avada kedavra pendant que tu parles.");
            player.pv=0;

        }
    }
    public static void victory(Player player) {
        printText("Bravo les mangemorts sont morts");
        makePotion(player,7);

    }
    public static void defeat(Player player) {
        gameOver(player,6);
    }

}
