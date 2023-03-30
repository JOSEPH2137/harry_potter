package com.example.harry_potter.general;

import com.example.harry_potter.classobject.Player;

import static com.example.harry_potter.console.Display.printText;

public class StrangeEnd {
    public static void strangeEnd(Player player) {
        if (player.house==1){
            printText("Félicitations tu as découvert la fin spéciale Griffondor. As tu trouvé les autres ?");
        }
        else if (player.house==2){
            printText("Félicitations tu as découvert la fin spéciale Serpentard. As tu trouvé les autres ?");
        }
        else if (player.house==3){
            printText("Félicitations tu as découvert la fin spéciale Serdaigle. As tu trouvé les autres ?");
        }
        else {
            printText("Félicitations tu as découvert la fin spéciale Poustoufle. As tu trouvé les autres ?");
        }
        System.exit(0);

    }
}
