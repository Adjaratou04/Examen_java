
package repositories;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Professeurs;

public class ProfesseurRepository extends Database {
    private final String SQL_INSERT_PROFESSEUR = "INSERT INTO professeurs ( `nci`, `nomComplet`, `grade`) VALUES ( ?, ?, ?)";
    private final String SQL_SELECT_ALL_PROFESSEURS = "SELECT * FROM professeurs";
    public void insert(Professeurs professeur) {
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_INSERT_PROFESSEUR);
            statement.setString(1, professeur.getNci());
            statement.setString(2, professeur.getNomComplet());
            statement.setString(3, professeur.getGrade());
            executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    
       public List<Professeurs> findAll() {
        List<Professeurs> professeurs = new ArrayList<>();
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_ALL_PROFESSEURS);
            ResultSet rs = executeSelect();
            while (rs.next()) {
                Professeurs professeur = new Professeurs();
                professeur.setId(rs.getInt("id_pr"));
                professeur.setNci(rs.getString("nci"));
                professeur.setNomComplet(rs.getString("nomComplet"));
                professeur.setGrade(rs.getString("grade"));
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }
    

   
}  

