package services;
import repositories.EtudiantRepository;
import entities.Etudiant;
public class EtudiantService {
    EtudiantRepository etudiantRepository=new EtudiantRepository();

    public void ajouterEtudiant(Etudiant etudiant){
        etudiantRepository.insert(etudiant);
    }



   

   
}
