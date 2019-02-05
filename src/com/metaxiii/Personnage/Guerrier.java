package com.metaxiii.Personnage;

import com.metaxiii.Comportement.Attaque;
import com.metaxiii.Comportement.Description;

public class Guerrier extends Personnage implements Attaque, Description {
    /**
     *
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     * @param joueur
     */
    public Guerrier(int niveau, int force, int agilite, int intelligence, int joueur) {
        super(niveau, force, agilite, intelligence, "Guerrier", joueur);
    }

    /**
     * description
     */
    public void decrisToi() {
        if (this.getForce() + this.getAgilite() + this.getIntelligence() == this.getNiveau())
            System.out.println("Woarg, je suis le " + this.getType() + " Joueur " + this.getJoueur() + " niveau " +
                    this.getNiveau() + " je possede " + this.getVie() + " de vitalite, " + this.getForce() + " de force, "
                    + this.getAgilite() + " d'agilité et " + this.getIntelligence() + " d'intelligence !");
        else
            System.out.println("Je ne suis pas normal");
    }

    /**
     * override attaque
     * @param personnage
     */
    @Override
    public void attaque(Personnage personnage) {
        System.out.println("Joueur " + this.getJoueur() + " utilise coup d'épée et inflige " + this.getForce()
                + " dommages");
        System.out.println("Joueur " + personnage.getJoueur() + " perd " + this.getForce() + " points de vie");
        personnage.setVie((personnage.getVie()) - this.getForce());
        Attaque.isAlive(personnage);
    }


    /**
     * override attaqueSpeciale
     * @param personnage
     */
    @Override
    public void attaqueSpeciale(Personnage personnage) {
        System.out.println("Joueur " + this.getJoueur() + " utilise coup de rage et inflige " + (this.getForce() * 2)
                + " dommages");
        System.out.println("Joueur " + personnage.getJoueur() + " perd " + (this.getForce() * 2) + " points de vie");
        System.out.println("Joueur " + this.getJoueur() + " perd " + (this.getForce() / 2) + " points de vie");
        personnage.setVie((personnage.getVie() - (this.getForce() * 2)));
        this.setVie(this.getVie() - (this.getForce() / 2));
        Attaque.isAlive(personnage);
    }
}
