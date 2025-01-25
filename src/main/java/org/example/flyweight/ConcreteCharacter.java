package org.example.flyweight;

public class ConcreteCharacter implements Character {
    private char character;
    public ConcreteCharacter(char character) {
        this.character = character;
    }
    @Override
    public void display(String font) {
        System.out.println("Character: " + character + ", Font: " + font);
    }
}
