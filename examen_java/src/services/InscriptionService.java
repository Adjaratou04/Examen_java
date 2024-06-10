package services;
import java.util.List;

import entities.Inscription;
import repositories.InscriptionRepository;


public class InscriptionService {
    InscriptionRepository inscriptionRepository=new InscriptionRepository();
    public void faireInscription(Inscription inscription){
        inscriptionRepository.insert(inscription);
    }


    public Inscription rechercherInscriptionParMatriculeEtu(String matricule){
        return inscriptionRepository.selectInscriptionByMatricule(matricule);
    }

    public List <Inscription>rechercherInscriptionParAnne(String anneeScolaire){
        return inscriptionRepository.selectAllInscriptionByAnneeScolaire(anneeScolaire);
    }


    //Surcharge de fonction

    public List <Inscription>rechercherInscriptionParAnne(String anneeScolaire, int idClasse){
        return inscriptionRepository.selectAllInscriptionByAnneeScolaire(anneeScolaire,idClasse);
    }


   

}

