package com.example.harry_potter.general;

import com.example.harry_potter.classobject.Player;
import com.example.harry_potter.classobject.Potion;
import com.example.harry_potter.console.Color;



import static com.example.harry_potter.console.Main.menu;
import static com.example.harry_potter.console.Display.printText;
import static com.example.harry_potter.console.InputParser.getInt;

public class MakePotion {

    public static void makePotion(Player player,int level){
        printText("Tu as du temps libre. Veux-tu concocter une potion ?");
        printText(" 1)oui \n 2)non");
        int choice=getInt();
        if (choice==1) {
            printText("Laquelle ?");
            choice=getInt();
            boolean findPotion = false;
            for (Potion potion : player.knownPotion) {
                if (potion.number == choice) {
                    findPotion = true;
                    if (potion.number==1){
                        player.pv=player.pv +20;
                        if (player.house==4){
                            player.pv=player.pv+20;
                        }
                        printText("tu as récupéré de la vie. Tu as maintenant : "+ Color.RED+" PV"+ player.pv+Color.RESET);
                    }
                }
            }
            if (findPotion==false){
                printText("Tu ne maitrise pas encore cette Potion. Tu as raté ta préparation. ");
            }
        }
        menu(player,level);
    }
}
