package org.example.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.connection.Conexao.fazerConexao;

public class UsuarioService {

    private Statement statement;

    public UsuarioService(){
        try{
            statement = fazerConexao().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //método que insere dados dentro do banco
    public void inserirDados(String nome){
        String sql = "INSERT INTO usuarios (nome) VALUES ('" + nome + "')";
        try{
            statement.executeUpdate(sql);
            System.out.println("Usuário " + nome + " foi adicionado com sucesso no banco!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //método que consulta todos os dados dentro do banco
    public void consultaTodosDados(){
        String sql = "SELECT * FROM usuarios";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id_usuario" +
                        " | NOME: " + resultSet.getString("nome")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
