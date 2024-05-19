package com.example;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String filiere;  // Correction ici

    public Etudiant(int id, String nom, String prenom, String sexe, String filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", filiere=" + filiere
                + "]";
    }

    public Etudiant(String nom, String prenom, String sexe, String filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.filiere = filiere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getFiliere() {  // Correction ici
        return filiere;
    }

    public void setFiliere(String filiere) {  // Correction ici
        this.filiere = filiere;
    }
}
