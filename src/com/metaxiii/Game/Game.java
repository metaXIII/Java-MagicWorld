package com.metaxiii.Game;

import com.metaxiii.Personnage.Guerrier;
import com.metaxiii.Personnage.Magicien;
import com.metaxiii.Personnage.Rodeur;
import com.metaxiii.Personnage.Personnage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    private Personnage playerOne;
    private Personnage playerTwo;

    public void init() {
        this.createCharacter(1);
        this.createCharacter(2);
        Combat combat = new Combat(playerOne, playerTwo);
    }

    private void createCharacter(int joueur) {
        int type;
        int niveau;
        int force;
        int agilite;
        int intelligence;
        boolean isValid;
        System.out.println("Création du personnage du joueur " + joueur);
        System.out.println("Veuillez choisir la classe de votre personnage (1- Guerrier, 2- Rôdeur, 3- Magicien)");
        type = this.checkInput();
        System.out.println("Niveau du personnage ?");
        niveau = this.checkCarac(1, 100);
        System.out.println("Force du personnage ?");
        force = this.checkCarac(0, 100);
        System.out.println("Agilité du personnage ?");
        agilite = this.checkCarac(0, 100);
        System.out.println("Intelligence du personnage ?");
        intelligence = this.checkCarac(0, 100);
        isValid = checkCreationPlayer(niveau, force, agilite, intelligence);
        if (isValid) {
            switch (type) {
                case 1:
                    if (joueur == 1)
                        playerOne = new Guerrier(niveau, force, agilite, intelligence,1);
                    else
                        playerTwo = new Guerrier(niveau, force, agilite, intelligence,2);
                    break;
                case 2:
                    if (joueur == 1)
                        playerOne = new Rodeur(niveau, force, agilite, intelligence, 1);
                    else
                        playerTwo = new Rodeur(niveau, force, agilite, intelligence, 2);
                    break;
                case 3:
                    if (joueur == 1)
                        playerOne = new Magicien(niveau, force, agilite, intelligence, 1);
                    else
                        playerTwo = new Magicien(niveau, force, agilite, intelligence, 2);
                    break;
                default:
                    break;
            }
        } else {
            System.err.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");
            createCharacter(joueur);
            return;
        }
        if (joueur == 1)
            playerOne.decrisToi();
        else
            playerTwo.decrisToi();
    }

    private int checkInput() {
        boolean isValid;
        int value;
        isValid = false;
        value = 0;
        while (!isValid) {
            try {
                value = sc.nextInt();
                isValid = value >= 1 && value <= 3;
            } catch (InputMismatchException e) {
                sc.nextLine();
            }
            if (!isValid)
                System.err.println("Merci de saisir le chiffre 1, 2 ou 3 \n1- Guerrier, 2- Rôdeur, 3- Magicien");
        }
        return value;
    }

    /**
     * @param lowLimit
     * @param HighLimit
     * @return
     */
    private int checkCarac(int lowLimit, int HighLimit) {
        boolean isValid;
        int value;
        isValid = false;
        value = 0;
        while (!isValid) {
            try {
                value = sc.nextInt();
                isValid = value >= lowLimit && value <= HighLimit;
            } catch (InputMismatchException e) {
                sc.nextLine();
            }
            if (!isValid)
                System.err.println("La valeur doit être comprise entre " + lowLimit + " et " + HighLimit +
                        "\nVos caractéristiques additionnées ne peuvent pas dépasser 100");
        }
        return value;
    }


    /**
     * retourne le booleen pour savoir si les conditions sont vraies
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     * @return
     */
    private boolean checkCreationPlayer(int niveau, int force, int agilite, int intelligence) {
        return (force + agilite + intelligence) == niveau;
    }
}
