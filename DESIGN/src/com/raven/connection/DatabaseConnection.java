package com.raven.connection;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {
    }

    public void connectToDatabase() throws SQLException {
        String server = "localhost";
        String port = "3306";
        String database = "login_db";
        String userName = "root";
        String password = "";  // Coloque sua senha do MySQL aqui, se houver
        
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Tenta estabelecer a conexão
            String url = "jdbc:mysql://" + server + ":" + port + "/" + database + 
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            
            connection = java.sql.DriverManager.getConnection(url, userName, password);
            
            // Testa a conexão
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            }
            
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver MySQL não encontrado!\nErro: " + e.getMessage() + 
                "\n\nVerifique se o arquivo mysql-connector-j-8.0.33.jar está na pasta lib.";
            JOptionPane.showMessageDialog(null, errorMsg, "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            throw new SQLException(errorMsg);
            
        } catch (SQLException e) {
            String errorMsg = "Erro ao conectar com o banco de dados!\n" +
                "Verifique se:\n" +
                "1. O MySQL está rodando\n" +
                "2. As credenciais estão corretas\n" +
                "3. O banco 'login_db' existe\n" +
                "4. A tabela 'usuarios' existe\n\n" +
                "Erro: " + e.getMessage();
            System.out.println(errorMsg);  // Log no console para debug
            JOptionPane.showMessageDialog(null, errorMsg, "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }

    public Connection getConnection() {
        try {
            // Verifica se a conexão está fechada ou nula
            if (connection == null || connection.isClosed()) {
                System.out.println("Conexão está nula ou fechada. Tentando reconectar...");
                connectToDatabase();
            }
            
            // Testa a conexão com uma query simples
            if (connection != null && !connection.isClosed()) {
                try {
                    connection.createStatement().executeQuery("SELECT 1");
                    System.out.println("Conexão está ativa e funcionando");
                } catch (SQLException e) {
                    System.out.println("Conexão falhou no teste. Tentando reconectar...");
                    connectToDatabase();
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar conexão: " + e.getMessage());
            try {
                connectToDatabase();
            } catch (SQLException ex) {
                System.err.println("Erro ao reconectar: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, 
                    "Erro ao reconectar com o banco de dados!\nErro: " + ex.getMessage(),
                    "Erro de Conexão",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexão com o banco de dados fechada.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
