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
public class DBaseDAO extends AbstractDAO{

    @Override
    public People load(People people) {
        System.out.println(this.getClass().getName() + " Load = "+people);
        return people;
    }

    @Override
    public void save(People people) {
        System.out.println(this.getClass().getName() + " Save = "+people);
    }

    @Override
    public void update(People people) {
        System.out.println(this.getClass().getName() + " Update = "+people);
    }

    @Override
    public void delete(People people) {
        System.out.println(this.getClass().getName() + " Delete = "+people);
    }
    
}
