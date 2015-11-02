/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.People;

/**
 *
 * @author Vlad
 */
public class DBaseDAO extends AbstractDAO{
    
    private Connection con = null;
    private PreparedStatement preparedStatement = null; 
    
    private Connection getConnection() throws SQLException, IOException{

            InputStream input = new FileInputStream("jdbc.properties");
            Properties prop = new Properties();
            prop.load(input);
           return DriverManager.getConnection(prop.getProperty("database"), prop.getProperty("dbuser"),
					prop.getProperty("dbpassword"));
    }

    @Override
    public People load(People people) {
        String selectSQL = "SELECT namee, surname, birthday FROM people WHERE surname = ?";
        try {
            con = getConnection();

            preparedStatement = con.prepareStatement(selectSQL);
            preparedStatement.setString(1, people.getSurname());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                people.setName(rs.getString("namee"));
                people.setSurname(rs.getString("surname"));
                people.setBirthday(rs.getString("birthday"));
                System.out.println(people.getName() + " " + people.getSurname() + " " + people.getBirthday());           
            } 
            preparedStatement.close();
            con.close(); 
        } catch (Exception ex) {
            Logger.getLogger(DBaseDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            preparedStatement = null;
            con = null;
        }
        //System.out.println(this.getClass().getName() + " Load = " + people);
        return people;
    }

    @Override
    public void save(People people) {
    String selectSQL = "insert into people(namee, surname, birthday) values (?, ?, ?)";
        try {
            con = getConnection();

            preparedStatement = con.prepareStatement(selectSQL);
            preparedStatement.setString(1, people.getName());
            preparedStatement.setString(2, people.getSurname());
            preparedStatement.setString(3, people.getBirthday());
            preparedStatement.executeQuery();

            preparedStatement.close();
            con.close(); 
        } catch (Exception ex) {
            Logger.getLogger(DBaseDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            preparedStatement = null;
            con = null;
        }   
    // System.out.println(this.getClass().getName() + " Save = "+people);
    }

    @Override
    public void update(People people) {
     String selectSQL = "update people set namee=?, birthday=?  where surname = ?";
        try {
            con = getConnection();

            preparedStatement = con.prepareStatement(selectSQL);
            preparedStatement.setString(1, people.getName());
            preparedStatement.setString(2, people.getBirthday());
            preparedStatement.setString(3, people.getSurname());
            preparedStatement.executeQuery();

            preparedStatement.close();
            con.close(); 
        } catch (Exception ex) {
            Logger.getLogger(DBaseDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            preparedStatement = null;
            con = null;
        }      

    //System.out.println(this.getClass().getName() + " Update = "+people);
    }

    @Override
    public void delete(People people) {
    String selectSQL = "delete from people where surname= ?";
        try {
            con = getConnection();

            preparedStatement = con.prepareStatement(selectSQL);
            preparedStatement.setString(1, people.getSurname());
            preparedStatement.executeQuery();

            preparedStatement.close();
            con.close(); 
        } catch (Exception ex) {
            Logger.getLogger(DBaseDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            preparedStatement = null;
            con = null;
        }      
        
    //System.out.println(this.getClass().getName() + " Delete = "+people);
    }
    
}
