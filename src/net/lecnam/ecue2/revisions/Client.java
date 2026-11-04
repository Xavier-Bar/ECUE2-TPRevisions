package net.lecnam.ecue2.revisions;

public class Client {
    private String nom;
    private String prenom;
    private String numeroClient;

    public Client(String nom, String prenom, String numeroClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroClient = numeroClient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroClient() {
        return numeroClient;
    }

    @Override
    public String toString(){
        return "Nom client ; " + this.nom + "\nPrénom client : " + this.prenom + "\nNuméro client : " + this.numeroClient;
    }

    @Override
    public boolean equals(Object obj) {
        Client client = (Client) obj;
        return this.numeroClient != null && this.numeroClient.equals(client.numeroClient);
    }
}
