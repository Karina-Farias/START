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
import model.Project;
import util.ConnectionFactory;
/**
 *
 * @author gabri
 */
public class ProjectController {
   
    public void save(Project project) throws ClassNotFoundException {
        
        String sql = "INSERT INTO projects (name, "
                + "description, "
                + "createdAt, "
                + "updatedAt, "
                + "VALUES (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Cria uma conexão com o Banco de Dados
            connection = ConnectionFactory.getConnection();
            //Preparando a Query
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            
            //Executa a sql para inserção dos dados
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o projeto", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update(Project project) throws ClassNotFoundException {
        
         String sql = "UPDATE projects SET "
                 + "name = ?, "
                 + "description = ?, "
                 + "createdAt = ?, "
                 + "updatedAt = ?, "
                 + "WHERE id = ?";
         
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Cria uma conexão com o Banco de Dados
            connection = ConnectionFactory.getConnection();
            //Preparando a Query
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            
            //Executa a sql para inserção dos dados
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro em atualizar o projeto", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
   
    public List<Project> getAll() throws ClassNotFoundException {
        
         String sql = "SELECT * FROM projects";
         
         List<Project> projects = new ArrayList<>();
        
         
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            //Cria uma conexão com o Banco de Dados
            connection = ConnectionFactory.getConnection();
            //Preparando a Query
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
                Project project = new Project();
                
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                projects.add(project);   
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar os projetos", ex);
        } finally {
           ConnectionFactory.closeConnection(connection, statement, resultSet); 
        }
        return projects;   
    }
    
    public  void  removeById(int idProject) throws ClassNotFoundException {
        
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            statement.execute();
        } catch (SQLException ex) {
           throw new RuntimeException("Erro ao deletar os projetos", ex); 
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
}
