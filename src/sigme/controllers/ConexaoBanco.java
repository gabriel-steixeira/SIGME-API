package sigme.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    public Connection Conectar() {
        try {
            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "APP_SIGME_SIS", "sigme_2024");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
