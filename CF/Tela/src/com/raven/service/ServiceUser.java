package com.raven.service;

import com.raven.connection.DatabaseConnection;
import com.raven.model.ModelLogin;
import com.raven.model.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;

public class ServiceUser {

    private final Connection con;

    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    public ModelUser login(ModelLogin login) throws SQLException {
        ModelUser data = null;
        PreparedStatement p = null;
        ResultSet r = null;
        
        try {
            System.out.println("Tentando fazer login com email: " + login.getEmail());
            
            if (con == null || con.isClosed()) {
                System.out.println("Erro: Conexão com o banco de dados está fechada ou nula");
                throw new SQLException("Conexão com o banco de dados não está disponível");
            }
            
            
            p = con.prepareStatement("select ID, Nome, Email, Status from `usuarios` where Email=? and Senha=? limit 1");
            p.setString(1, login.getEmail());
            p.setString(2, login.getPassword());
            
            System.out.println("Executando query de login...");
            r = p.executeQuery();
            
            if (r.next()) {
                int userID = r.getInt(1);
                String userName = r.getString(2);
                String email = r.getString(3);
                String status = r.getString(4);
                
                System.out.println("Usuário encontrado:");
                System.out.println("ID: " + userID);
                System.out.println("Nome: " + userName);
                System.out.println("Email: " + email);
                System.out.println("Status: " + status);
                
                
                data = new ModelUser(userID, userName, email, "");
                System.out.println("Login realizado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com essas credenciais");
            }
        } finally {
            if (r != null) r.close();
            if (p != null) p.close();
        }
        return data;
    }

    public void insertUser(ModelUser user) throws SQLException {
        PreparedStatement p = null;
        ResultSet r = null;
        
        try {
            p = con.prepareStatement(
                "insert into `usuarios` (Nome, Email, `Senha`, CodigoVerificacao, `Status`) values (?,?,?,?,'Verified')", 
                PreparedStatement.RETURN_GENERATED_KEYS
            );
            
            String code = generateVerifyCode();
            p.setString(1, user.getUserName());
            p.setString(2, user.getEmail());
            p.setString(3, user.getPassword());
            p.setString(4, code);
            
            int affectedRows = p.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Falha ao criar usuário, nenhuma linha afetada.");
            }
            
            r = p.getGeneratedKeys();
            if (r.next()) {
                int userID = r.getInt(1);
                user.setUserID(userID);
                user.setVerifyCode(code);
                System.out.println("Novo usuário registrado: " + user.getUserName() + " (ID: " + userID + ")");
            } else {
                throw new SQLException("Falha ao criar usuário, nenhum ID obtido.");
            }
            
        } finally {
            if (r != null) r.close();
            if (p != null) p.close();
        }
    }

    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  //  Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = null;
        ResultSet r = null;
        
        try {
            p = con.prepareStatement("select ID from `usuarios` where CodigoVerificacao=? limit 1");
            p.setString(1, code);
            r = p.executeQuery();
            duplicate = r.next();
        } finally {
            if (r != null) r.close();
            if (p != null) p.close();
        }
        return duplicate;
    }

    public boolean checkDuplicateUser(String user) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = null;
        ResultSet r = null;
        
        try {
            p = con.prepareStatement("select ID from `usuarios` where Nome=? and `Status`='Verified' limit 1");
            p.setString(1, user);
            r = p.executeQuery();
            duplicate = r.next();
        } finally {
            if (r != null) r.close();
            if (p != null) p.close();
        }
        return duplicate;
    }

    public boolean checkDuplicateEmail(String email) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = null;
        ResultSet r = null;
        
        try {
            p = con.prepareStatement("select ID from `usuarios` where Email=? and `Status`='Verified' limit 1");
            p.setString(1, email);
            r = p.executeQuery();
            duplicate = r.next();
        } finally {
            if (r != null) r.close();
            if (p != null) p.close();
        }
        return duplicate;
    }

    public void doneVerify(int userID) throws SQLException {
        PreparedStatement p = null;
        
        try {
            p = con.prepareStatement("update `usuarios` set CodigoVerificacao='', `Status`='Verified' where ID=? limit 1");
            p.setInt(1, userID);
            int affectedRows = p.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Usuário verificado com sucesso (ID: " + userID + ")");
            }
        } finally {
            if (p != null) p.close();
        }
    }

    public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
        boolean verify = false;
        PreparedStatement p = null;
        ResultSet r = null;
        
        try {
            p = con.prepareStatement("select ID from `usuarios` where ID=? and CodigoVerificacao=? limit 1");
            p.setInt(1, userID);
            p.setString(2, code);
            r = p.executeQuery();
            verify = r.next();
            
            if (verify) {
                System.out.println("Código de verificação válido para usuário (ID: " + userID + ")");
            }
        } finally {
            if (r != null) r.close();
            if (p != null) p.close();
        }
        return verify;
    }
}
