package org.example.strategy;

public class MediumLevel implements DifficultyLevelStrategy {
    @Override
    public void modifyGameRules() {
        System.out.println("Game rules for medium level: Standard time limit and scoring.");
    }
}
