package com.example.harry_potter.Level;

import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Potion;
import com.example.harry_potter.classobject.Spell;
import com.example.harry_potter.classobject.Wand;
import com.example.harry_potter.general.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.example.harry_potter.Main.menu;

public class Level0 {

    private static Player player;

    public static void level0() {


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Bienvenue dans le monde de Harry Potter. Tout d'abord, quel est ton nom jeune sorcier intrépide ?");
        String playerName = scanner.next();
        System.out.println("Bon aventure, cher " + playerName);
        System.out.println("Tu as rendez-vous chez Olivander pour acheter ta baguette magique. C'est la baguette qui choisit son sorcier " + playerName + ", te rappelles le vieil homme.");
        int coreWand = random.nextInt(3 - 0) + 1;
        int sizeWand = random.nextInt(12 - 0) + 20;
        if (coreWand == 1) {
            System.out.println("Ca y est je le sens il y a un lien entre toi et cette baguette à"+ Color.RED +" crin de licorne "+Color.RESET);
        } else if (coreWand == 2) {
            System.out.println("Ca y est je le sens il y a un lien entre toi et cette baguette à "+ Color.RED +" plume de phoenix !"+Color.RESET);
        } else {
            System.out.println("Ca y est je le sens il y a un lien entre toi et cette baguette à"+ Color.RED +" ventricule de dragon !"+Color.RESET);
        }
        System.out.println("Elle mesure " + Color.GREEN_2 +sizeWand + " cms"+Color.RESET);
        System.out.println("Maintenant, tu peux choisir un animal de compagnie");
        System.out.println("Tu peux choisir : 1)une chouette. 2)un rat. 3)un chat. 4)un crapaud.");
        int validPet = 0;
        int pet = scanner.nextInt();
        while (validPet == 0) {
            if (pet == 1) {
                System.out.println("Une chouette, très bon choix, ce rapace aux aptitudes inouïes surveillera tes arrières et te restera fidèle.");
                validPet = 1;
            } else if (pet == 2) {
                System.out.println("Un rat, très bon choix, ce petit rongeur peut se faufiler nimporte où et te sera d'une grande utilité.");
                validPet = 1;
            } else if (pet == 3) {
                System.out.println("Un chat, très bon choix, ce félin aux sens aiguisé t'aidera durant ton voyage à travers la magie.");
                validPet = 1;
            } else if (pet == 4) {
                System.out.println("Un crapaud, très bon choix, cet animal aux apparences hideuses est cependant une bête au grand coeur.");
                validPet = 1;
            } else {
                System.out.println("Entre un numéro valide.");
                pet = scanner.nextInt();
            }
        }
        System.out.println("Premier jour à Poudlard ; tu vas enfin connaitre ta maison. on pose le choipeau sur ta tête.");
        int house = random.nextInt(4 - 0) + 1;
        if (house == 1) {
            System.out.println(Color.RED+"Griffondor"+Color.RESET+", crie le choipeau !");
        } else if (house == 2) {
            System.out.println(Color.GREEN_1+"Serpentard"+Color.RESET+", crie le choipeau !");
        } else if (house == 3) {
            System.out.println(Color.BLUE+"Serdaigle"+Color.RESET+", crie le choipeau  !");
        } else {
            System.out.println(Color.YELLOW+"Poustouffle"+Color.RESET+", crie le choipeau  !");
        }
        Wand wand = new Wand(coreWand, sizeWand);
        int pv = 100;
        List<Spell> knownSpell = new ArrayList();
        List<Potion> knownPotion = new ArrayList();
        player = new Player(playerName, wand, pet, house, pv,knownSpell,knownPotion);
        menu(player,1);
    }




}
