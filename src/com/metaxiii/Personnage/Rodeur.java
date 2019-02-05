package com.metaxiii.Personnage;

import com.metaxiii.Comportement.Attaque;
import com.metaxiii.Comportement.Description;

public class Rodeur extends Personnage implements Attaque, Description {

    /**
     *
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     * @param joueur
     */
    public Rodeur(int niveau, int force, int agilite, int intelligence, int joueur) {
        super(niveau, force, agilite, intelligence, "Rodeur", joueur);
    }

    /**
     *
     */
    public void decrisToi() {
        if (this.getForce() + this.getAgilite() + this.getIntelligence() == this.getNiveau())
            System.out.println("Salut, je suis le " + this.getType() + " Joueur " + this.getJoueur() + " niveau " +
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
        System.out.println("Joueur " + this.getJoueur() + " tire à l'arc et inflige " + this.getAgilite()
                + " dommages");
        System.out.println("Joueur " + personnage.getJoueur() + " perd " + this.getAgilite() + " points de vie");
        personnage.setVie((personnage.getVie()) - this.getAgilite());
        Attaque.isAlive(personnage);
    }

    /**
     *
     * @param personnage
     */
    @Override
    public void attaqueSpeciale(Personnage personnage) {
        System.out.println("Joueur " + this.getJoueur() + " gagne " + (this.getNiveau() / 2) + " en agilité");
        this.setAgilite(this.getAgilite() + (this.getNiveau() / 2));
    }
}
