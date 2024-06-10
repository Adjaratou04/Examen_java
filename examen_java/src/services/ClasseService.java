package services;

import repositories.ClasseRepository;

import java.util.List;

import entities.Classe;

public class ClasseService {

    ClasseRepository classeRepository=new ClasseRepository();
    public void ajouterClasse(Classe classe){
        classeRepository.insertClasse(classe);
    }

    public List<Classe> listerClasse(){
        return classeRepository.selectAll();
     }

    public  Classe FindClasseById(int id){
        return classeRepository.selectClasseById(id);
    }
}
