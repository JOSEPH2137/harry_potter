package com.example.harry_potter.Level;

import com.example.harry_potter.classobject.Boss;
import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Spell;

import java.util.Random;

import static com.example.harry_potter.console.Display.printText;
import static com.example.harry_potter.console.InputParser.getInt;
import static com.example.harry_potter.console.Main.menu;
import static com.example.harry_potter.general.GameOver.gameOver;

public class Level7 {
    public static void level7(Player player) {

        Spell expelliarmus = new Spell(20, 0, 5);
        if (player.knownSpell.size() < 5) {
            printText("tu as appris le sort expelliarmus. C'est le sort numéro 5; Il te permet de désarmer un adversaire.");
            player.knownSpell.add(expelliarmus);
        }
        Boss bellatrix = new Boss(200, 25);
        Boss voldemort = new Boss(300, 50);
        if (player.house == 3) {
            expelliarmus.precision = expelliarmus.precision + 13;
        } else if (player.house == 2) {
            expelliarmus.attack = expelliarmus.attack + 50;
        } else if (player.house == 1) {
            bellatrix.attack = bellatrix.attack - 10;
            voldemort.attack = voldemort.attack - 10;
        }
        fightlevel6(player, voldemort, bellatrix);


    }
    public static void fightlevel6(Player player,Boss voldemort,Boss bellatrix) {
        printText("Tu dois combattre Bellatrix Lestrange et Voldemort. Bon courage");
        boolean playlevel = true;
        while (playlevel == true) {
            printText("Tu décides :\n1)De les attaquer en lançant un sort \n2)De te protéger derrière un pilier");
            int validnumber = 0;
            while (validnumber == 0) {
                int choice = getInt();
                if (choice == 1) {
                    spell(player, voldemort, bellatrix);
                    validnumber = 1;
                } else if (choice == 2) {
                    protect(player);
                    validnumber = 1;
                } else {
                    printText("entre un numéro valide");
                }

                if (voldemort.pv < 1 && bellatrix.pv < 1) {
                    playlevel = false;
                    victory(player);

                }
                if (voldemort.attack < 1 && bellatrix.attack < 1) {
                    playlevel = false;
                    victory2(player);
                }
                else if (player.pv < 1) {
                    defeat(player);
                    playlevel = false;
                } else {
                    printText("\n Voldemort" + " PV : " + voldemort.pv + ".\n" + "Bellatrix Lestrange" + " PV : " + bellatrix.pv + ".\n" + player.playerName + " PV : " + player.pv);
                }
            }
        }
    }
    public static void spell(Player player,Boss voldemort,Boss bellatrix) {
        printText("Quel sort ?");
        int sort = getInt();
        boolean findSpell = false;
        for (Spell spell : player.knownSpell) {
            if (spell.number == sort) {
                findSpell = true;
                int attack = spell.attack;
                int precision = spell.precision;
                if (sort == 1 || sort == 2 || sort == 3) {
                    printText("Ces sorts sont inutiles ici.");
                    if (bellatrix.attack>0) {
                        printText("Bellatrix Lestrange a profité de ton moment d'hésitation pour lancer un sort.");
                        player.pv = player.pv - bellatrix.attack;
                    }
                }
                else if (sort==4){
                    printText("quel mangemort veux tu attaquer :\n 1)Voldemort \n 2)Bellatrix Lestrange");
                    int boss = getInt();
                    if (boss == 1) {
                        fightvoldemort(player, voldemort, bellatrix, attack, precision);
                    } else if (boss == 2) {
                        fightbellatrix(player, voldemort, bellatrix, attack, precision);
                    } else {
                        printText("ton sort a percuté un arbre");
                        player.pv = player.pv - 20;
                    }

                }
                else {
                    printText("quel ennemi veux tu essayer de désarmer :\n 1)Voldemort \n 2)Bellatrix Lestrange");
                    int boss = getInt();
                    if (boss == 1) {
                        disarmvoldemort(player, voldemort, bellatrix, attack, precision);
                    } else if (boss == 2) {
                        disarmbellatrix(player, voldemort, bellatrix, attack, precision);
                    } else {
                        printText("ton sort a percuté un arbre");
                        player.pv = player.pv - 20;
                    }

                }
            }
        }
        if (findSpell == false) {
            printText("Tu ne connais pas encore ce sort");
            if (bellatrix.attack>0){
                printText("\n Bellatrix Lestrange a profité de ton moment d'hésitation pour lancer un sort.");
                player.pv = player.pv - bellatrix.attack;
            }
        }
    }
    public static void fightvoldemort(Player player,Boss voldemort, Boss bellatrix,int attack,int precision) {
        Random random = new Random();
        int pres = random.nextInt(100 - 1) + 1;
        if (pres < precision) {
            voldemort.pv = voldemort.pv - attack;
            printText("le sort a fonctionné");
            if (voldemort.pv < 1) {
                voldemort.pv = 0;
            }
        } else if (voldemort.pv > 1) {
            pres = random.nextInt(2-1)+1;
            if (pres==1){
                printText("Tu as échoué en lançant le sort");
                if (voldemort.attack>0){
                    printText("\n Voldemort T'as lancé un Avada Kedavra.");
                    player.pv = 0;
                }
            }
            else {
                printText("Tu as échoué en lançant le sort");
                if (voldemort.attack>0){
                    printText("\n Voldemort T'as infligé des dégâts.");
                    player.pv = player.pv - voldemort.attack;
                }
            }
        }
        if (bellatrix.pv > 1) {
            if (bellatrix.attack>0){
                printText("Bellatrix Lestrange T'as infligé des dégâts.");
                player.pv = player.pv - bellatrix.attack;
            }
        }

    }
    public static void fightbellatrix(Player player,Boss voldemort, Boss bellatrix,int attack,int precision) {
        Random random = new Random();
        int pres = random.nextInt(100 - 1) + 1;
        if (pres < precision) {
            bellatrix.pv = bellatrix.pv - attack;
            printText("le sort a fonctionné");
            if (bellatrix.pv < 1) {
                bellatrix.pv = 0;
            }
        } else if (bellatrix.pv > 1) {
            pres = random.nextInt(3-1)+1;
            if (pres==1){
                printText("Tu as échoué en lançant le sort");
                if (bellatrix.attack>0){
                    printText("\n Bellatrix Lestrange T'as lancé un Avada Kedavra.");
                    player.pv = 0;
                }
            }
            else {
                printText("Tu as échoué en lançant le sort");
                if (bellatrix.attack>0){
                    printText("\n Bellatrix Lestrange T'as infligé des dégâts.");
                    player.pv = player.pv - bellatrix.attack;
                }
            }
        }
        if (voldemort.pv > 1) {
            if (voldemort.attack>0){
                printText("Voldemort T'as infligé des dégâts.");
                player.pv = player.pv - voldemort.attack;
            }
        }

    }
    public static void disarmvoldemort(Player player,Boss voldemort, Boss bellatrix,int attack,int precision){
        Random random = new Random();
        int pres = random.nextInt(100 - 1) + 1;
        if (voldemort.attack==0){
            printText("Voldemort est déjà désarmé.");
            printText("Bellatrix Lestrange en a profité pour t'envoyer un sort");
            player.pv=player.pv-bellatrix.attack;
        }
        else if (pres < precision) {
            if (player.wand.coreWand==2){
                printText("Ta baguette et celle de Voldemort sont connectée. Elles ont été faites à partir du même phénix. Vous mourrez tous les deux. Tu as réussi à protéger le monde mais tu n'as pas survécu.");
                voldemort.pv=0;
                bellatrix.pv=0;

            }
            voldemort.attack=0;
            printText("bravo tu as désarmé Voldemort.");
        }
        else {
            printText("Tu n'as pas réussi à le désarmer. Bellatrix Lestrange en a profité pour t'envoyer un sort");
            player.pv=player.pv-bellatrix.attack;
        }


    }
    public static void disarmbellatrix(Player player,Boss voldemort, Boss bellatrix,int attack,int precision){
        Random random = new Random();
        int pres = random.nextInt(100 - 1) + 1;
        if (bellatrix.attack==0){
            printText("Bellatrix est déjà désarmé.");
            printText("Voldemort en a profité pour t'envoyer un sort");
            player.pv=player.pv-bellatrix.attack;
        }
        else if (pres < precision) {
            bellatrix.attack=0;
            printText("bravo tu as désarmé Bellatrix Lestrange.");
        }
        else {
            printText("Tu n'as pas réussi à la désarmer. Voldemort en a profité pour t'envoyer un sort");
            player.pv=player.pv-voldemort.attack;
        }


    }
    public static void protect(Player player) {
        printText("Voldemort et Bellatrix Lestrange ont lancé simultanément un Avada Kedavra. tu as réussi l'exploit de mourir deux fois, bel performance.");
        player.pv=0;

    }
    public static void victory(Player player) {
        printText("Bravo voldemort et Bellatrix Lestrange  sont morts");
        menu(player, 8);

    }
    public static void victory2(Player player) {
        printText("Bravo Voldemort et Bellatrix Lestrange  sont désarmés.");
        menu(player, 8);

    }
    public static void defeat(Player player) {
        gameOver(player, 7);
    }


}
