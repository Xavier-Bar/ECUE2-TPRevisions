package net.lecnam.ecue2.revisions;

import java.time.LocalDate;

public class CompteCourant extends CompteBancaire{
    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, Client titulaire, double decouvertAutorise){
        super(numeroCompte, titulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    public CompteCourant(String numeroCompte, Client titulaire){
        this(numeroCompte, titulaire, 500.0);
    }

    public CompteCourant(String numeroCompte, Client titulaire, LocalDate dateOuverture, double solde, double decouvertAutorise){
        super(numeroCompte, titulaire, dateOuverture, solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    public void retirer(double montant){
        if (getSolde() - montant < -decouvertAutorise) {
            double montantManquant = montant - (getSolde() + decouvertAutorise);
            throw new SoldeInsuffisantException("Solde insuffisant (découvert dépassé).", montantManquant);
        }
        debiter(getSolde() - montant);
    }

}
