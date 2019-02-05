package com.metaxiii.Personnage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GuerrierTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    Guerrier wrongWarrior = new Guerrier(100, 100, 100, 100, 1);
    Guerrier warrior = new Guerrier(100, 100, 0, 0, 0);
    Guerrier victime = new Guerrier(1, 1, 0, 0, 0);

    @Test
    void Given_WarriorDescription_When_Created_Then_PrintOutDescription() {
        warrior.decrisToi();
        assertEquals("Woarg, je suis le Guerrier Joueur 0 niveau 100" +
                        " je possede 500 de vitalite, 100 de force, 0 d'agilité et 0 d'intelligence !\n",
                outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_WarriorWithWrongParameter_When_Created_Then_DisplayAlert() {
        wrongWarrior.decrisToi();
        assertEquals("Je ne suis pas normal\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_OffrandeToWarrior_When_Combat_Then_DisplayNormalAttackSentence() {
        warrior.attaque(victime);
        assertEquals("Joueur 0 utilise coup d'épée et inflige 100 dommages\n" +
                "Joueur 0 perd 100 points de vie\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_OffrandeToWarrior_When_Combat_Then_DisplaySpecialAttackSentence() {
        warrior.attaqueSpeciale(victime);
        assertEquals("Joueur 0 utilise coup de rage et inflige 200 dommages\n" +
                "Joueur 0 perd 200 points de vie\n" +
                "Joueur 0 perd 50 points de vie\n", outContent.toString().replace("\r\n", "\n"));
    }
}
