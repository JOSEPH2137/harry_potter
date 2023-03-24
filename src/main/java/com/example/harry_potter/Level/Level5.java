package com.example.harry_potter.Level;

import com.example.harry_potter.classobject.Boss;
import com.example.harry_potter.classobject.Player;

import java.util.Scanner;

import static com.example.harry_potter.general.GameOver.gameOver;
import static com.example.harry_potter.general.MakePotion.makePotion;

public class Level5 {
    public static void level5(Player player) {
        System.out.println("tu dois réussir à distraire Dolores Ombrage en attendant que tes amis prépare les feux d'artifices. Attention à ne pas mettre Ombrage trop en colère.");
        Boss doloresOmbrage = new Boss(50, 30);
        int paperplanetime = 0;
        int askquestiontime = 0;
        boolean stillAlive = true;
        while (stillAlive == true) {
            System.out.println("Que veux-tu faire \n 1)lancer un avion en papier  \n 2)poser une question \n 3)ne rien faire \n 4)lancer un sort. \n 5)faire un compliment");
            int validnumber = 0;

            while (validnumber == 0) {
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                if (choice == 1) {
                    paperplanetime=paperplanetime +1;
                    paperplane(player, doloresOmbrage,paperplanetime);
                    validnumber = 1;
                } else if (choice == 2) {
                    askquestiontime=askquestiontime+1;
                    askquestion(player, doloresOmbrage, askquestiontime);
                    validnumber = 1;
                } else if (choice == 3) {
                    nothing(player);
                    validnumber = 1;

                }
                else if (choice == 4) {
                    spell();
                    validnumber = 1;
                }
                else if (choice == 5) {
                    complimente(doloresOmbrage);
                    validnumber = 1;
                }
                else {
                    System.out.println("Entre un numéro valide.");
                }
            }
            if (doloresOmbrage.pv < 1) {
                doloresOmbrage.pv=0;
            }
            if (player.pv < 1) {
                player.pv=0;
            }
            if (doloresOmbrage.attack > 100) {
                doloresOmbrage.attack=100;
            }
            System.out.println( "\nDolores Ombrage" + " jauge de patience : " + doloresOmbrage.attack + "%.\n" + player.playerName + " PV : " + player.pv+".\ntemps restant : " + doloresOmbrage.pv + "mn");
            if (player.pv < 1) {
                stillAlive = false;
                defeat(player);

            }
            else if (doloresOmbrage.attack > 99) {
                stillAlive = false;
                System.out.println("DoloresOmbrage est tellement en colère qu'elle se déplace dans toute la salle et découvre tes amis en train de préparer les feux d'artifices.");
                defeat(player);
            }
            else if (doloresOmbrage.pv < 1) {
                stillAlive = false;
                victory(player);
            }
        }
    }

    public static void paperplane(Player player,Boss doloresOmbrage, int paperplanetime){
        if (paperplanetime>2){
            System.out.println("Dolores Ombrage a remarquée que tu lançais des avions en papier. Tu reçois une punition");
            player.pv=player.pv-doloresOmbrage.attack/3;
            doloresOmbrage.attack=doloresOmbrage.attack + 10;
            doloresOmbrage.pv=doloresOmbrage.pv -5;
        }
        else{
            System.out.println("Dolores Ombrage ne comprend pas qui lance les avions. Cela l'énerve un peu.");
            doloresOmbrage.attack=doloresOmbrage.attack + 20;
            doloresOmbrage.pv=doloresOmbrage.pv -10;
        }
    }
    public static void askquestion(Player player, Boss doloresOmbrage, int askquestiontime){
        if (askquestiontime>2){
            System.out.println("Dolores Ombrage trouve que tu poses trop de questions. Tu reçois une punition");
            player.pv=player.pv-doloresOmbrage.attack/3;
            doloresOmbrage.attack=doloresOmbrage.attack + 10;
            doloresOmbrage.pv=doloresOmbrage.pv -5;
        }
        else{
            System.out.println("Dolores Ombrage te réponds, mais cela l'agace beaucoup.");
            doloresOmbrage.attack=doloresOmbrage.attack + 25;
            doloresOmbrage.pv=doloresOmbrage.pv -10;
        }
    }
    public static void nothing(Player player){
        System.out.println("La salle est tellement calme que Dolores Ombrage décide de sortir dans le couloir. Elle remarque tes amis en train de préparer les feux d'artifices");
        player.pv=0;
    }
    public static void spell(){
        System.out.println("Tu n'as pas ta baguette magique dans la salle d'examen. Donc tu ne peux pas");
    }
    public static void complimente( Boss doloresOmbrage){
        System.out.println("Tu fais un compliment à Dolores Ombrage. Cela lui fait plaisir et elle se calme un peu.");
        doloresOmbrage.attack=doloresOmbrage.attack-10;
        doloresOmbrage.pv=doloresOmbrage.pv -3;
    }
    public static void victory(Player player) {
        System.out.println("Félicitations, tes amis on pu préparer les feux d'artifices. Que la fête commence !!!");
        makePotion(player,6);
    }
    public static void defeat(Player player) {
        System.out.println("tu n'as pas réussi à distraire Dolores Ombrage. Elle a remarqué que vous prépariez une bêtise avec tes camarades. vous êtes tous puni.");
        gameOver(player,5);

    }

}
