package com.metaxiii.Game;

import com.metaxiii.Personnage.Personnage;

import java.util.InputMismatchException;
import java.util.Scanner;

class Combat {
    private boolean isDead;
    Personnage playerOne;
    Personnage playerTwo;
    Scanner sc = new Scanner(System.in);

    /**
     * Constructeur
     * @param playerOne
     * @param playerTwo
     */
    public Combat(Personnage playerOne, Personnage playerTwo) {
        this.isDead = false;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.init();
    }

    private void init() {
        int turn;
        turn = 0;
        while (!this.isDead) {
            if (turn % 2 == 0) {
                this.attaque(playerOne);
            } else {
                this.attaque(playerTwo);
            }
            turn++;
        }
    }

    /**
     *
     * @param player
     */
    private void attaque(Personnage player) {
        int choice = 0;
        if (playerOne.getVie() > 0 && playerTwo.getVie() > 0) {
            System.out.println("Joueur " + player.getJoueur() + " ( " + player.getVie() + " de vitalité)" +
                    " veuillez choisir votre action : 1 : Attaque Basique, 2 : Attaque Spéciale");
            while (true) {
                try {
                    choice = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.err.println("Veuillez choisir 1 ou 2");
                }
            }
            if (choice == 1) {
                if (player.getJoueur() == 1)
                    player.attaque(playerTwo);
                else
                    player.attaque(playerOne);
            } else if (player.getJoueur() == 1)
                player.attaqueSpeciale(playerTwo);
            else
                player.attaqueSpeciale(playerOne);
        } else
            this.isDead = true;
    }
}
