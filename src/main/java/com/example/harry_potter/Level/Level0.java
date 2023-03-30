package com.example.harry_potter.Level;

import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Potion;
import com.example.harry_potter.classobject.Spell;
import com.example.harry_potter.classobject.Wand;
import com.example.harry_potter.console.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.example.harry_potter.console.Main.inputParser;
import static com.example.harry_potter.console.Main.menu;
import static com.example.harry_potter.console.Display.printText;


public class Level0 {

    public static void level0() {


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        printText("Bienvenue dans le monde de Harry Potter. Tout d'abord, quel est ton nom jeune sorcier intrépide ?");
        String playerName = inputParser.getName();
        printText("Bon aventure, cher " + playerName);
        System.out.println("Tu as rendez-vous chez Olivander pour acheter ta baguette magique. C'est la baguette qui choisit son sorcier " + playerName + ", te rappelles le vieil homme.");
        int coreWand = random.nextInt(3 - 0) + 1;
        int sizeWand = random.nextInt(12 - 0) + 20;
        if (coreWand == 1) {
            printText("Ca y est je le sens il y a un lien entre toi et cette baguette à"+ Color.RED +" crin de licorne "+Color.RESET);
        } else if (coreWand == 2) {
            printText("Ca y est je le sens il y a un lien entre toi et cette baguette à "+ Color.RED +" plume de phoenix !"+Color.RESET);
        } else {
            printText("Ca y est je le sens il y a un lien entre toi et cette baguette à"+ Color.RED +" ventricule de dragon !"+Color.RESET);
        }
        printText("Elle mesure " + Color.GREEN_2 +sizeWand + " cms"+Color.RESET);
        printText("Maintenant, tu peux choisir un animal de compagnie");
        printText("Tu peux choisir : 1)une chouette. 2)un rat. 3)un chat. 4)un crapaud.");
        int validPet = 0;
        int pet= inputParser.getInt();
        while (validPet == 0) {
            if (pet == 1) {
                printText("Une chouette, très bon choix, ce rapace aux aptitudes inouïes surveillera tes arrières et te restera fidèle.");
                validPet = 1;
            } else if (pet == 2) {
                printText("Un rat, très bon choix, ce petit rongeur peut se faufiler nimporte où et te sera d'une grande utilité.");
                validPet = 1;
            } else if (pet == 3) {
                printText("Un chat, très bon choix, ce félin aux sens aiguisé t'aidera durant ton voyage à travers la magie.");
                validPet = 1;
            } else if (pet == 4) {
                printText("Un crapaud, très bon choix, cet animal aux apparences hideuses est cependant une bête au grand coeur.");
                validPet = 1;
            } else {
                printText("Entre un numéro valide.");
                pet=inputParser.getInt();
            }
        }
        printText("Premier jour à Poudlard ; tu vas enfin connaitre ta maison. on pose le choipeau sur ta tête.");
        int house = random.nextInt(4 - 0) + 1;
        if (house == 1) {
            printText(Color.RED+"Griffondor"+Color.RESET+", crie le choipeau !");
        } else if (house == 2) {
            printText(Color.GREEN_1+"Serpentard"+Color.RESET+", crie le choipeau !");
        } else if (house == 3) {
            printText(Color.BLUE+"Serdaigle"+Color.RESET+", crie le choipeau  !");
        } else {
            printText(Color.YELLOW+"Poustouffle"+Color.RESET+", crie le choipeau  !");
        }
        Wand wand = new Wand(coreWand, sizeWand);
        int pv = 100;
        List<Spell> knownSpell = new ArrayList();
        List<Potion> knownPotion = new ArrayList();
        Player player = new Player(pv,playerName, wand, pet, house,knownSpell,knownPotion);
        menu(player,1);
    }




}
