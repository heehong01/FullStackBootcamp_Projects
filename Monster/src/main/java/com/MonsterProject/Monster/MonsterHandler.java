package com.MonsterProject.Monster;

public class MonsterHandler {
    public void handleMonsters(Monster[] monsters){
        for(Monster monster: monsters){
            System.out.println(monster.attack());
        }
    }
}