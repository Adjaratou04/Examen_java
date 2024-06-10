package entities;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    private int id;
  
    private String niveau;
    private String  filiere;
    private List<ProfesseurClasse> professeurClasses=new ArrayList<>();
    public String getNiveau() {
        return niveau;
    }
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    
    public void setProfesseurClasses(List<ProfesseurClasse> professeurClasses) {
        this.professeurClasses = professeurClasses;
    }
    public List<ProfesseurClasse> getProfesseurClasses() {
        return professeurClasses;
    }
    List<Inscription> inscriptions;

    
    public Classe() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
  
   
 
    public List<Inscription> getInscriptions() {
        return inscriptions;
    }
    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
    
    

}
