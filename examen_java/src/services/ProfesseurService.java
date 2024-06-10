package services;

import java.util.List;

import entities.Classe;
import entities.ProfesseurClasse;
import entities.Professeurs;
import repositories.ProfesseurRepository;
import repositories.ProfesseurClasseRepository;




public class ProfesseurService {
    ProfesseurRepository professeurRepository=new ProfesseurRepository();
    ProfesseurClasseRepository ProfesseurClasseRepository=new ProfesseurClasseRepository();
      public  void ajouterProfesseur(Professeurs professeur){
        //Transaction
         professeurRepository.insert(professeur);
         List<ProfesseurClasse> professeurClasse = professeur.getProfesseurClasses();
         for (ProfesseurClasse pc  : professeurClasse) {
            ProfesseurClasseRepository.insert(pc);
         }

      }
    


    

    public List<Professeurs> listerProfesseurs() {
        return professeurRepository.findAll();
    }

   
    public List<Classe> getClassesByProfesseurId(int professeurId) {
      return ProfesseurClasseRepository.findClassesByProfesseurId(professeurId);
  }
}



