package com.metaxiii.Comportement;

import com.metaxiii.Personnage.Personnage;

/**
 * Interface
 */
public interface Attaque {
    void attaque(Personnage personnage);
    void attaqueSpeciale(Personnage personnage);
    static void isAlive(Personnage personnage) {
        if (personnage.getVie() == 0)
            System.out.println("Joueur " + personnage.getJoueur() + " est mort");
    }
}
