package com.metaxiii.Personnage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RodeurTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    Rodeur wrongRodeur = new Rodeur(100, 100, 100, 100, 1);
    Rodeur rodeur = new Rodeur(100, 100, 0, 0, 0);
    Rodeur victime = new Rodeur(1, 1, 0, 0, 0);

    @Test
    void Given_MagicianDescription_When_Created_Then_PrintOutDescription() {
        rodeur.decrisToi();
        assertEquals("Salut, je suis le Rodeur Joueur 0 niveau 100 je possede 500 de vitalite, " +
                        "100 de force, 0 d'agilité et 0 d'intelligence !\n",
                outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_MagicianWithWrongParameter_When_Created_Then_DisplayAlert() {
        wrongRodeur.decrisToi();
        assertEquals("Je ne suis pas normal\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_OffrandeToMagician_When_Combat_Then_DisplayNormalAttackSentence() {
        rodeur.attaque(victime);
        assertEquals("Joueur 0 tire à l'arc et inflige 0 dommages\n" +
                "Joueur 0 perd 0 points de vie\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_OffrandeToMagician_When_Combat_Then_DisplaySpecialAttackSentence() {
        rodeur.attaqueSpeciale(victime);
        assertEquals("Joueur 0 gagne 50 en agilité\n", outContent.toString().replace("\r\n", "\n"));
    }

}
