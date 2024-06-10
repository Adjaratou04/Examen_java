package repositories;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Etudiant;
import entities.Inscription;

public class InscriptionRepository extends Database {
    private final String SQL_INSERT="INSERT INTO `inscription` ( `id_in`, `annee_in`, `matricule_et`, `id_cl`) VALUES (?,?,?,?);";
    private final String SQL_SELECT_PAR_ANNE="select * from inscription i , etudiant e where i.matricule_et=e.matricule_et and i.annee_in like ?";
    private final String SQL_SELECT_PAR_ANNE_FILTRE="select * from inscription i , etudiant e where i.matricule_et=e.matricule_et and i.annee_in like ? and i.id_cl like ? ";
    private final String SQL_SELECT_BY_MATRICULE="SELECT * FROM `inscription` where matricule_et like ? ";
  







    public Inscription selectInscriptionByMatricule(String mat){
        Inscription inscription = null;
        try{
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_BY_MATRICULE);
            statement.setString(1,mat);
            ResultSet rs=executeSelect();
            if(rs.next()){
                 while (rs.next()) {
                     inscription=new Inscription(); 
                     inscription.setId(rs.getInt("id_in")); 
                     inscription.setAnneeScolaire(rs.getString("annee_in"));
                     Etudiant etudiant=new Etudiant();
                     etudiant.setMatricule(rs.getString("matricule_et"));
                     etudiant.setNomComplet(rs.getString("nomComplet_et"));
                     etudiant.setTuteur(rs.getString("tuteur_et")); 
                     inscription.setEtudiant(etudiant);
                    
                 }
              

            }
            statement.close();
            rs.close();
            conn.close();

        }catch (SQLException e) {
            System.out.println("Erreur de connexion à la BD");
        }
        return inscription;
    }

    public  List<Inscription>selectAllInscriptionByAnneeScolaire(String anneeScolaire){
        List<Inscription> inscriptions=new ArrayList<>();
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_PAR_ANNE);
            statement.setString(1,anneeScolaire);
       
            ResultSet rs = executeSelect();
            while (rs.next()) {
                Inscription inscription=new Inscription(); 
                inscription.setId(rs.getInt("id_in")); 
                inscription.setAnneeScolaire(rs.getString("annee_in")); 
               Etudiant etudiant=new Etudiant();
               etudiant.setMatricule(rs.getString("matricule_et"));
               etudiant.setNomComplet(rs.getString("nomComplet_et"));
               etudiant.setTuteur(rs.getString("tuteur_et"));
               inscription.setEtudiant(etudiant);
               inscriptions.add(inscription);
            }
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return inscriptions;
      }

      public  List<Inscription>selectAllInscriptionByAnneeScolaire(String anneeScolaire, int idClasse){
        List<Inscription> inscriptions=new ArrayList<>();
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_PAR_ANNE_FILTRE);
            statement.setString(1,anneeScolaire);
            statement.setInt(2,idClasse);

       
            ResultSet rs = executeSelect();
            while (rs.next()) {
                Inscription inscription=new Inscription(); 
                inscription.setId(rs.getInt("id_in")); 
                inscription.setAnneeScolaire(rs.getString("annee_in")); 
               Etudiant etudiant=new Etudiant();
               etudiant.setMatricule(rs.getString("matricule_et"));
               etudiant.setNomComplet(rs.getString("nomComplet_et"));
               etudiant.setTuteur(rs.getString("tuteur_et"));
               inscription.setEtudiant(etudiant);
               inscriptions.add(inscription);
            }
       } catch (SQLException e) {
          
           e.printStackTrace();
       }
       return inscriptions;
      }

    public void insert(Inscription inscription){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT);
             statement.setInt(1,inscription.getId());
             statement.setString(2,inscription.getAnneeScolaire());
             statement.setString(3,inscription.getEtudiant().getMatricule());
             statement.setInt(4,inscription.getClasse().getId());
             executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
