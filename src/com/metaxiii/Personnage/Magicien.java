package com.metaxiii.Personnage;

import com.metaxiii.Comportement.Attaque;
import com.metaxiii.Comportement.Description;

public class Magicien extends Personnage implements Attaque, Description {

    /**
     *
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     * @param joueur
     */
    public Magicien(int niveau, int force, int agilite, int intelligence, int joueur) {
        super(niveau, force, agilite, intelligence, "Mage", joueur);
    }

    /**
     *
     */
    public void decrisToi() {
        if (this.getForce() + this.getAgilite() + this.getIntelligence() == this.getNiveau())
            System.out.println("Bonjour, je suis le " + this.getType() + " Joueur " + this.getJoueur() + " niveau " +
                this.getNiveau() + " je possede " + this.getVie() + " de vitalite, " + this.getForce() + " de force, "
                + this.getAgilite() + " d'agilité et " + this.getIntelligence() + " d'intelligence !");
        else
            System.out.println("Je ne suis pas normal");
    }

    /**
     *
     * @param personnage
     */
    @Override
    public void attaque(Personnage personnage) {
        System.out.println("Joueur " + this.getJoueur() + " utilise Boule de feu et inflige " + this.getIntelligence()
                + " dommages");
        System.out.println("Joueur " + personnage.getJoueur() + " perd " + this.getIntelligence() + " points de vie");
        personnage.setVie((personnage.getVie()) - this.getIntelligence());
        Attaque.isAlive(personnage);
    }

    /**
     *
     * @param personnage
     */
    @Override
    public void attaqueSpeciale(Personnage personnage) {
        System.out.println("Joueur " + this.getJoueur() + " utilise Soin et regagne " + (this.getNiveau() * 5)
                + " points de vie");
        if (this.getVie() + (this.getIntelligence() * 2) > (this.getNiveau() * 5))
            this.setVie(this.getNiveau() * 5);
        else
            this.setVie(this.getVie() + (this.getIntelligence() * 2));
    }
}
