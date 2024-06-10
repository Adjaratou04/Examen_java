package entities;

public class ProfesseurClasse {
   
    private int  id;
    Professeurs professeur;
    Classe classe;

   
   
  
    public ProfesseurClasse(Classe classe) {
        this.classe = classe;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Professeurs getProfesseur() {
        return professeur;
    }
    public void setProfesseur(Professeurs professeur) {
        this.professeur = professeur;
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
