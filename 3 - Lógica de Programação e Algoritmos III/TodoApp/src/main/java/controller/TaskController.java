/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author gabri
 */
public class TaskController {
    
    public void save(Task task){
        String sql = "INSERT INTO tasks (idProject,"
                + "name,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            //Estabelecendo conexão com o Banco de Dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a Query
            statement = connection.prepareStatement(sql);
            
             //Setando os valores do Statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            
            //Executando a Query
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa" + ex.getMessage(), ex);
        } finally {
           ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update(Task task){
         String sql = "UPDATE tasks SET"
                + "idProject = ?, "
                + "name = ?, "
                + "description  = ?, "
                + "completed = ?, "
                + "notes = ?, "
                + "deadline = ?, "
                + "createdAt = ?, "
                + "updatedAt = ? "
                + "WHERE id = ?";
         
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
       
            //Estabelecendo conexão com o Banco de Dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a Query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores do Statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            
            //Executando a Query
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atializar a tarefa" + ex.getMessage(), ex);
        }
    }
    
    public void removeById(int taskId) throws SQLException{
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            
            //Estabelecendo conexão com o Banco de Dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a Query
            statement = connection.prepareStatement(sql);
            
             //Setando os valores do Statement
            statement.setInt(1, taskId);
            
            //Executando a Query
            statement.execute();
        } catch(Exception ex){
           throw new RuntimeException("Erro ao deletar a tarefa" + ex.getMessage(), ex);
           
        } finally {
            ConnectionFactory.closeConnection(connection , statement);
        }
    }
    
    public List<Task> getAll(int idProject){
        
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //Lista de Tarefas que será devolvida quando a chamada dp método acontecer
        List<Task> tasks = new ArrayList<Task>();
        
        try {
            
            //Estabelecendo conexão com o Banco de Dados
            connection = ConnectionFactory.getConnection();
            
             //Preparando a Query
            statement = connection.prepareStatement(sql);
            
            //Setando o valor que corresponde ao filtro de busca
            statement.setInt(1, idProject);
            
            //Valor retornado pela execusão da Query
            resultSet = statement.executeQuery();
            
            //Enquanto hoverem valores a serem percorridos no meu ResultSet
            while (resultSet.next()) {                
                
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                tasks.add(task);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir a tarefa" + ex.getMessage(), ex);
        }finally {
            ConnectionFactory.closeConnection(connection , statement, resultSet); 
        }
        
        //Lista de tarefas que foi criada e carregada do Banco de Dados 
        return tasks;  
    }
}


