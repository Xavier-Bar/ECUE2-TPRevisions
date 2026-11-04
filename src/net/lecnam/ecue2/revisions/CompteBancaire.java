package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public abstract class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private Client titulaire;
    private LocalDate dateOuverture;

    public CompteBancaire(String numeroCompte, Client titulaire){
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.dateOuverture = LocalDate.now();
        this.solde = 0.0;
    }

    public CompteBancaire(String numeroCompte, Client titulaire, LocalDate dateOuverture, double solde) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.titulaire = titulaire;
        this.dateOuverture = dateOuverture;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Client getTitulaire() {
        return titulaire;
    }

    public LocalDate getDateOuverture() {
        return dateOuverture;
    }

    public void deposer(double montant){
        if (montant > 0.0) {
            this.solde += montant;
        } else {
            throw new IllegalArgumentException("Le montant doit être supèrieur à zéro");
        }
    }

    // Uniquement les classes filles pourront l'utiliser
    protected void debiter(double montant){
        this.solde -= montant;
    }

    public abstract void retirer(double montant) throws SoldeInsuffisantException;

    public abstract double calculerInterets();

    public void appliquerInterets(){
        this.solde += this.calculerInterets();
    }

    @Override
    public String toString(){
        return "Compte n° " + this.numeroCompte + "\nTitulaire : " + titulaire.toString() +
                "\nSolde : " + this.solde + " €" + "\nDate d'ouverture : " + this.dateOuverture;
    }
}
