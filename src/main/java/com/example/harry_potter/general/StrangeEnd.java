package com.example.harry_potter.general;

import com.example.harry_potter.classobject.Boss;
import com.example.harry_potter.classobject.Player;

public class StrangeEnd {
    public static void strangeEnd(Player player) {
        if (player.house==1){
            System.out.println("Félicitations tu as découvert la fin spéciale Griffondor. As tu trouvé les autres ?");
        }
        else if (player.house==2){
            System.out.println("Félicitations tu as découvert la fin spéciale Serpentard. As tu trouvé les autres ?");
        }
        else if (player.house==3){
            System.out.println("Félicitations tu as découvert la fin spéciale Serdaigle. As tu trouvé les autres ?");
        }
        else {
            System.out.println("Félicitations tu as découvert la fin spéciale Poustoufle. As tu trouvé les autres ?");
        }
        System.exit(0);

    }
}
