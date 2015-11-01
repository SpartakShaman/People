/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import dao.AbstractDAO;
import dao.DBaseDAO;
import dao.FileDAO;
import model.People;

/**
 *
 * @author Vlad
 */
public class PeopleController {

    private AbstractDAO dao;

    public PeopleController(String repo) {
        if (repo.toUpperCase().equals("F")) {
            this.dao = new FileDAO();
        } else {
            this.dao = new DBaseDAO();
        }
    }
    
    public People load( People people)
    {
        return dao.load(people);
    }
    
    public void save( People people)
    {
         dao.save(people);
    }
    
     public void update( People people)
    {
         dao.update(people);
    }
     
      public void delete( People people)
    {
         dao.delete(people);
    }
}   

