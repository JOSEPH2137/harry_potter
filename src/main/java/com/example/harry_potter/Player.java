package com.example.harry_potter;

import java.util.List;

public class Player {
    public String playerName;
    public Wand wand;
    public int pet;
    public int house;

    public int pv;

    public Player(String playerName, Wand wand, int pet, int house, int pv) {
        this.playerName = playerName;
        this.wand = wand;
        this.pet = pet;
        this.house = house;
        this.pv = pv;
    }
}