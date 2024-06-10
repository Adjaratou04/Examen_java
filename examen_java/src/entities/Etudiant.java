package entities;

import java.util.List;

public class Etudiant {
   
    private int id;
    private String matricule;
    private String nomComplet;
    private String tuteur;
    List<Inscription> inscriptions;

    public Etudiant() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getTuteur() {
        return tuteur;
    }
    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }
    public List<Inscription> getInscriptions() {
        return inscriptions;
    }
    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    } 
    
}
