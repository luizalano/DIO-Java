package br.com.luigipietro.main;

import org.postgresql.core.ConnectionFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoJdbcFactory {
    //Construtor declarado como privado. Evitando assim criar instâncias da fábrica.
    private ConexaoJdbcFactory() {
        throw new UnsupportedOperationException();
    }

    public static Connection getConnection() {
        String urlConnection = "jdbc:postgresql://localhost:5433/dioaulabd0";
        Connection conn = null;

        try (InputStream input = ConnectionFactory.class.getClassLoader().
                getResourceAsStream("connection.properties")){
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            // 4 - Construção da string de conexão.
            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString(); //sb.toString() == "jdbc:mysql://localhost/digital_innovation_one"
            try {
                conn = DriverManager.getConnection(connectionUrl, user, password);
//                System.out.println(conn.getClientInfo().toString());
//                System.out.println(conn.getSchema());
//                System.out.println(conn.getCatalog());
//                System.out.println(conn.getMetaData().toString());
            } catch (SQLException e) {
                System.out.println("FALHA ao tentar criar conexão");
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            System.out.println("Não achei o arquivo de propriedades!");
        }
        return conn;
    }
}
