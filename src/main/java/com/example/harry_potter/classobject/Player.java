package com.example.harry_potter.classobject;

import java.util.List;

public class Player extends Character{
    public String playerName;
    public Wand wand;
    public int pet;
    public int house;


    public List<Spell> knownSpell;
    public List<Potion> knownPotion;

    public Player(int pv,String playerName, Wand wand, int pet, int house,List<Spell> knownSpell,List<Potion> knownPotion) {
        super(pv);
        this.playerName = playerName;
        this.wand = wand;
        this.pet = pet;
        this.house = house;
        this.knownSpell = knownSpell;
        this.knownPotion=knownPotion;
    }
}