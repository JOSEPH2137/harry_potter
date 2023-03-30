package com.example.harry_potter.general;

import com.example.harry_potter.classobject.Player;



import static com.example.harry_potter.console.Main.menu;
import static com.example.harry_potter.console.Display.printText;
import static com.example.harry_potter.console.InputParser.getInt;

public class GameOver {
    public static void  gameOver(Player player, int level){
        printText("Tu as perdu. espèce de naze");
        printText("Veux tu reessayer le niveaux auquel tu as perdu ?");
        printText(" 1)oui \n 2)non");
        int choice=getInt();
        if (choice==1) {
            player.pv=500;
            menu(player,level);
        }
        else {
            System.exit(0);
        }
    }

}
