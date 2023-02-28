package com.example.harry_potter;

public class Player {
    public String playerName;
    public Wand wand;
    public int pet;
    public int house;

    public Player(String playerName, Wand wand, int pet, int house) {
        this.playerName = playerName;
        this.wand = wand;
        this.pet = pet;
        this.house = house;
    }
}