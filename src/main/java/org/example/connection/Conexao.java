package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    //método que faz a conexão com o banco de dados postgres
    public static Connection fazerConexao(){
        try{
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "123456");
            if (conexao != null){
                System.out.println("Conexão com o banco de dados bem sucedida! :D");
            }else{
                System.out.println("Conexão com o banco infelizmente FALHOU! :(");
            }
            return conexao;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
