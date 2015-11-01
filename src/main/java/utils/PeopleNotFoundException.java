/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Vlad
 */
public class PeopleNotFoundException extends Exception{

    @Override
    public String getMessage() {
        return "People not found.";
    }
   
}
