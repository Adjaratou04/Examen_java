import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Classe;
import entities.Etudiant;
import entities.Inscription;
import entities.ProfesseurClasse;
import entities.Professeurs;
import services.ClasseService;
import services.EtudiantService;
import services.InscriptionService;
import services.ProfesseurService;

public class View {

    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        ClasseService classeService=new ClasseService();
        ProfesseurService professeurService=new ProfesseurService();
        InscriptionService inscriptionService=new InscriptionService();
        EtudiantService etudiantService=new EtudiantService();
        
      
        do {
            System.out.println("*******GESTION SCOLAIRE******");
            System.out.println("*******MENU RESPONSABLE PEDAGOGIQUE******");
            System.out.println("1-Ajouter une classe");
            System.out.println("2-Lister les classes");
            System.out.println("3-Ajouter des professeurs et leur affecter des classes");
            System.out.println("4-Lister les professeurs");
            System.out.println("5-Filtrer les classes d'un professeurs");
        
            System.out.println("***********MENU ATTACHE DE CLASSE***************");
            System.out.println("6-Faire une inscription ou une reinscription");
            System.out.println("7-Lister les etudiants inscrit dans une classe");
            System.out.println("8-Quitter");
          

            choix=sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                System.out.println("Entrer le niveau de la classe (L1, L2, L3):");
                String niveau = sc.nextLine();
                System.out.println("Entrer la filière de la classe (GLRS, IAGE, ETSE, TTL):");
                String filiere = sc.nextLine();
                Classe cl = new Classe();
                cl.setNiveau(niveau);
                cl.setFiliere(filiere);
                classeService.ajouterClasse(cl);
                System.out.println("Classe ajoutée avec succès.");


                break;

                case 2:
                System.out.println("Les classes sont les suivants:");
                List<Classe> classe = classeService.listerClasse();
                for (Classe c : classe) {
                  System.out.println("ID :"+c.getId());
                  System.out.println("Niveau:"+c.getNiveau());
                  System.out.println("Filiere: "+c.getFiliere());
                  System.out.println("********************");
                }


                break;            
                case 3:
                                
                        Professeurs professeur = new Professeurs();
                        
                        System.out.println("Entrer le Nci");
                        professeur.setNci(sc.nextLine());
                        
                        System.out.println("Entrer le Nom complet");
                        professeur.setNomComplet(sc.nextLine());
                        
                        System.out.println("Entrer le grade");
                        professeur.setGrade(sc.nextLine());
                        
                        List<Classe> classe2 = classeService.listerClasse();
                        int response = 2;
                        List<ProfesseurClasse> listeClasseProf = new ArrayList<>();
                        
                        do {
                            for (Classe c : classe2) {
                                System.out.println(c.getId() + " " + c.getNiveau() + " " + c.getFiliere());
                            }
                            
                            System.out.println("Veuillez selectionner la classe à laquelle vous voulez ajouter un professeur");
                            int idClasse = sc.nextInt(); 
                            sc.nextLine(); 
                            
                            Classe cl1 = classeService.FindClasseById(idClasse);                            
                            if (cl1 != null) {
                                ProfesseurClasse professeurClasse = new ProfesseurClasse(cl1);
                                professeurClasse.setProfesseur(professeur);
                                
                                boolean inside = false;
                                for (ProfesseurClasse p : listeClasseProf) {
                                    if (p.getClasse().getId() == cl1.getId()) {
                                        inside = true;
                                        System.out.println("Classe deja passée au professeur");
                                        break;
                                    }
                                }
                                
                                if (!inside) {
                                    listeClasseProf.add(professeurClasse);
                                }
                            } else {
                                System.out.println("Cet Id n'existe pas");
                            } 
                            
                            System.out.println("Voulez continuez 1-Oui 2-Non"); 
                            response = sc.nextInt();
                            sc.nextLine(); 
                        } while (response == 1);
                        
                        professeur.setProfesseurClasses(listeClasseProf);
                        
                        if (professeur.getProfesseurClasses().isEmpty()) {
                            System.out.println("Le professeur doit avoir au moins une classe");
                        } else {
                            professeurService.ajouterProfesseur(professeur);
                        }
                
                       break;
                        case 4: 
                        System.out.println("Les différents professeurs de cette etablissement sont:");
                        List<Professeurs> listerProfesseurs = professeurService.listerProfesseurs();
                            for (Professeurs p : listerProfesseurs) {
                                System.out.println("ID :" + p.getId());
                                System.out.println("NCI :" + p.getNci());
                                System.out.println("Nom Complet: " + p.getNomComplet());
                                System.out.println("Grade: " + p.getGrade());
                                System.out.println("********************");
                        }
                    break;
                    case 5:
                            System.out.println("Les différents professeurs de cette etablissement sont:");
                            List<Professeurs> listerProfesseurs1 = professeurService.listerProfesseurs();
                                    for (Professeurs p : listerProfesseurs1) {
                                        System.out.println("ID :" + p.getId());
                                        System.out.println("NCI :" + p.getNci());
                                        System.out.println("Nom Complet: " + p.getNomComplet());
                                        System.out.println("Grade: " + p.getGrade());
                                        System.out.println("********************");
                                        }
                            System.out.println("Entrez l'Id du professeur pour filtrer ses classes :");
                            int professeurId = sc.nextInt();
                            List<Classe> classes = professeurService.getClassesByProfesseurId(professeurId);
                            if (classes.isEmpty()) {
                                System.out.println("Aucune classe trouvée pour ce professeur.");
                            } else {
                                for (Classe c : classes) {
                                    System.out.println("Classe Id: " + c.getId() + ", Niveau: " + c.getNiveau() + ", Filière: " + c.getFiliere());
                                
                                }
                            }
                    break;

                     case 6:
                        System.out.println("Veuillez entrer le matricule de l'etudiant");
                        String matricule=sc.nextLine();
                        Inscription inscription=new Inscription();
                        inscription= inscriptionService.rechercherInscriptionParMatriculeEtu(matricule);
                        Etudiant etudiant  =new Etudiant();
                        if (inscription==null) {
                            System.out.println("Etudiant inexistant. Veuilez l'inscrire");
                            System.out.println(" Veuillez Entrer le matricule de l'etudiant");
                            matricule=sc.nextLine();
                            System.out.println("Veuillez entrer le nom complet de l'etudiant");
                            String nomComplet=sc.nextLine();
                            System.out.println("Veuillez entrer le tuteur de l'etudiant");
                            String tuteur=sc.nextLine();
                            etudiant =new Etudiant();
                            etudiant.setMatricule(matricule);
                            etudiant.setNomComplet(nomComplet);
                            etudiant.setTuteur(tuteur);
                            etudiantService.ajouterEtudiant(etudiant);

                            
                        }else{
                            System.out.println("La matricule existe deja.Veuillez reinscrir l'etudiant");
                        }
                        inscription=new Inscription();
                        System.out.println("Veuillez choisir l'année");
                        String anneeScolaire=sc.nextLine();
                        System.out.println("Les classes sont les suivantes");
                        List <Classe> classes2= classeService.listerClasse();
                        for(Classe cl1:classes2){
                            System.out.println(cl1.getId()+"\n "+cl1.getNiveau()+" \n"+cl1.getFiliere());
                            System.out.println("***************************************");
                        
                        }
                        int idClasse=sc.nextInt();
                        Classe classe3=new Classe();
                        classe3=classeService.FindClasseById(idClasse);
                        inscription.setClasse(classe3);
                        inscription.setAnneeScolaire(anneeScolaire);
                        inscription.setEtudiant(etudiant);
                        inscriptionService.faireInscription(inscription);
                        break;


                        case 7:
                        System.out.println("Saisir l'année d'inscription");
                        anneeScolaire=sc.nextLine();
                        List<Inscription> inscriptions=inscriptionService.rechercherInscriptionParAnne(anneeScolaire);
                        for(Inscription in:inscriptions){
                            System.out.println("Matricule: "+in.getEtudiant().getMatricule()+"\n "+"nomComplet: "+in.getEtudiant().getNomComplet()+"\n "+in.getEtudiant().getTuteur());
                            System.out.println("***************************************");
                        }
                        System.out.println("Voulez vous filtrer cette liste par classe ?  Oui/Non");
                        String reponse=sc.nextLine();
                        if(reponse.equalsIgnoreCase("oui")){
                            System.out.println("Les classes sont les suivantes");
                            classes= classeService.listerClasse();
                            for(Classe cl3:classes){
                                System.out.println(cl3.getId()+"\n "+cl3.getNiveau()+"\n"+cl3.getFiliere());
                                System.out.println("***************************************");
                            
                            }
                            idClasse=sc.nextInt();
                            inscriptions=inscriptionService.rechercherInscriptionParAnne(anneeScolaire,idClasse);
                            for(Inscription in:inscriptions){
                                System.out.println("Matricule: "+in.getEtudiant().getMatricule()+"\n "+"nomComplet: "+in.getEtudiant().getNomComplet()+"\n "+in.getEtudiant().getTuteur());
                                System.out.println("***************************************");
                            }

                        }else if (reponse.equalsIgnoreCase("non")){
                            break;
                        }

                        case 8:
                        System.out.println("******************MERCI*********************");




                        break;







                            }     
    
        } while (choix!=8);

     
    }   
}


