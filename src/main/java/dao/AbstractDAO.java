/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.People;

/**
 *
 * @author Vlad
 */
public abstract class AbstractDAO {
    public abstract People load(People people);
    public abstract void save(People people);
    public abstract void update(People people);  
    public abstract void delete(People people);
}
