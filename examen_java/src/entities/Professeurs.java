package entities;

import java.util.ArrayList;
import java.util.List;

public class Professeurs {
    private int id;
    private String nci;
    private String nomComplet;
    private String  grade;
    List<Classe> classes;
    public Professeurs(List<Classe> classes) {
        this.classes = classes;
    }
    private List<ProfesseurClasse> professeurClasses=new ArrayList<>();
    public void setProfesseurClasses(List<ProfesseurClasse> professeurClasses) {
        this.professeurClasses = professeurClasses;
    }
    public List<ProfesseurClasse> getProfesseurClasses() {
        return professeurClasses;
    }


    public String getNci() {
        return nci;
    }
    public void setNci(String nci) {
        this.nci = nci;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
   

    
    public Professeurs() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public List<Classe> getClasses() {
        return classes;
    }
    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }
    
}
