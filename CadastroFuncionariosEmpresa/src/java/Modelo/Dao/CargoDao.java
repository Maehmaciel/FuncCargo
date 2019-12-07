package Modelo.Dao;

import Modelo.Negocio.Cargo;
import Modelo.Negocio.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoDao {

    Connection con;

    public CargoDao() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost/banco", "usuario", "senha");

    }

    public void sair() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        CargoDao dao = new CargoDao();

        dao.sair();
    }

}
