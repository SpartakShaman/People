/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.People;

/**
 *
 * @author Vlad
 */
public class FileDAO extends AbstractDAO {
File outfile = new File("D:/test.txt");
    
    @Override
    public People load(People people) {
        BufferedReader bufr = null;
        String[] sss;
    
    try {
        //System.out.println(this.getClass().getName() + " Load = "+people);
        bufr = new BufferedReader (new FileReader(outfile));
        String fromf = null;     
        while ((fromf = bufr.readLine())!=null )
        {//System.out.println(fromf);
          sss =fromf.split(";");
        //    System.out.println(sss[0] + sss[1]+ sss[2]);
          if (people.getName().equals(sss[0]))
          {people.setSurname(sss[1]);
          people.setBirthday(sss[2]);
          break;
          } 
        }        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            bufr.close();
        } catch (IOException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    System.out.println(people.toString());
    return people;
    }

    @Override
    public void save(People people) {
        PrintWriter writer = null;
        try {            
            writer = new PrintWriter( new FileWriter(outfile, true));
            writer.write(people.toString()+ "\n");
            
        } catch (IOException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally 
        {
            writer.close();
        }
        
    }

    @Override
    public void update(People people) {
        System.out.println(this.getClass().getName() + " Upload = "+people);
    }

    @Override
    public void delete(People people) {
       // System.out.println(this.getClass().getName() + " Delete = "+people);
        PrintWriter writer = null;
        
        
    }
    
}
