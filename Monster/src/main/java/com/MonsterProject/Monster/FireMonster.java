package com.MonsterProject.Monster;

public class FireMonster extends Monster {
    public FireMonster(String name) {
        super(name);
    }
    @Override
    public String attack(){
        return "Attack with fire!";
    }
}