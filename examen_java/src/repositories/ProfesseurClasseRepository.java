package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Classe;
import entities.ProfesseurClasse;

public class ProfesseurClasseRepository extends Database {
    private final String SQL_INSERT_PROFESSEUR_CLASSE = "INSERT INTO professeur_classe (id_pr, id_cl) VALUES (?, ?)";
    private final String SQL_FIND_CLASSES_BY_PROFESSEUR_ID = "SELECT c.* FROM classe c INNER JOIN professeur_classe pc ON c.id_cl = pc.id_cl WHERE pc.id_pr = ?";

    public void insert(ProfesseurClasse professeurClasse) {
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_INSERT_PROFESSEUR_CLASSE);
            statement.setInt(1, professeurClasse.getProfesseur().getId());
            statement.setInt(2, professeurClasse.getClasse().getId());
            executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Classe> findClassesByProfesseurId(int professeurId) {
        List<Classe> classes = new ArrayList<>();
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_FIND_CLASSES_BY_PROFESSEUR_ID);
            statement.setInt(1, professeurId);
            ResultSet rs = executeSelect();
            if (rs != null) {
                while (rs.next()) {
                    Classe classe = new Classe();
                    classe.setId(rs.getInt("id_cl"));
                    classe.setNiveau(rs.getString("niveau"));
                    classe.setFiliere(rs.getString("filiere"));
                    classes.add(classe);
                }
            } else {
                System.out.println("Aucun résultat trouvé pour l'ID professeur : " + professeurId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }
}
