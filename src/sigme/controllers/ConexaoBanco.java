package sigme.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    public Connection Conectar() {
        try {
            return DriverManager.getConnection("DB_URL=jdbc:oracle:thin:(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.sa-saopaulo-1.oraclecloud.com))(connect_data=(service_name=g1f69bdd1ef191b_baseatp_medium.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))", "APP_SIGME", "Usr_Sigme_2024");
            //return DriverManager.getConnection("jdbc:oracle:thin:@adb.sa-saopaulo-1.oraclecloud.com:1522/g1f69bdd1ef191b_baseatp_medium.adb.oraclecloud.com", "APP_SIGME", "Usr_Sigme_2024");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
