package com.metaxiii.Personnage;

public abstract class Personnage {
    private int niveau;
    private int vie;
    private int force;
    private int agilite;
    private int intelligence;
    private String type;
    private int joueur;

    /**
     *
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     * @param type
     * @param joueur
     */
    public Personnage(int niveau, int force, int agilite, int intelligence, String type, int joueur) {
        this.niveau = niveau;
        this.vie = niveau * 5;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
        this.type = type;
        this.joueur = joueur;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getForce() {
        return force;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getType() {
        return type;
    }

    public int getJoueur() {
        return joueur;
    }

    /**
     * @param personnage
     */
    public abstract void attaque(Personnage personnage);

    /**
     *
     * @param playerOne
     */
    public abstract void attaqueSpeciale(Personnage playerOne);

    /**
     *
     */
    public abstract void decrisToi();
}
