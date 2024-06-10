package repositories;
import entities.Classe;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClasseRepository extends Database {
    private final String SQL_SELECT_CL="select * from classe";
    private final String SQL_INSERT_CLASSE="INSERT INTO `classe` ( `niveau`,`filiere`) VALUES (?,?);";
    private final String SQL_SELECT_BY_ID="SELECT * FROM `classe` where id_cl like ? ";

    public List <Classe> selectAll(){
        List <Classe> classes= new ArrayList<>();
        try{
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_CL);
            ResultSet rs= executeSelect();
            while(rs.next()){
                Classe classe=new Classe();
                classe.setId(rs.getInt("id_cl"));
                classe.setNiveau(rs.getString("niveau"));
                classe.setFiliere(rs.getString("filiere"));
                classes.add(classe);
            }
            rs.close();
            fermerConnexion();
        }
        catch(SQLException e){
            System.out.println("Erreur de connexion a la BD");
        }
        return classes;

    }
    public void insertClasse(Classe classe){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT_CLASSE);
              statement.setString(1,classe.getNiveau());
              statement.setString(2, classe.getFiliere());
             executeUpdate();
        } catch (SQLException e) {
          
            e.printStackTrace();
        }
    }

    

    
       public Classe selectClasseById(int id){
        Classe classe = null;
        try{
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1,id);
            ResultSet rs=executeSelect();
            if(rs.next()){
                 classe=new Classe();
                 classe.setId(rs.getInt ("id_cl"));
                 classe.setNiveau(rs.getString("niveau"));
                 classe.setFiliere(rs.getString("filiere"));
                 
              

            }
            statement.close();
            rs.close();
            conn.close();

        }catch (SQLException e) {
            System.out.println("Erreur de connexion à la BD");
        }
        return classe;
    }
}




   
    



