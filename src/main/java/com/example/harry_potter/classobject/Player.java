package com.example.harry_potter.classobject;

import java.util.List;

public class Player {
    public String playerName;
    public Wand wand;
    public int pet;
    public int house;

    public int pv;

    public List<Spell> knownSpell;
    public List<Potion> knownPotion;

    public Player(String playerName, Wand wand, int pet, int house, int pv,List<Spell> knownSpell,List<Potion> knownPotion) {
        this.playerName = playerName;
        this.wand = wand;
        this.pet = pet;
        this.house = house;
        this.pv = pv;
        this.knownSpell = knownSpell;
        this.knownPotion=knownPotion;
    }
}