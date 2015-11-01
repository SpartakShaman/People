/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import Service.PeopleController;
import java.util.Date;
import java.util.Scanner;
import model.People;

/**
 *
 * @author Vlad
 */
public class PeopleRUN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Выберите хранилище для работы F - в файл, D - база данных");
        Scanner sc = new Scanner(System.in);
        String repo = sc.next();      

        System.out.println("Введите тип операции L - загрузить, S - сохранить , U - обновить, D - удалить");
        String operetion = sc.next();
        operetion = operetion.toUpperCase();
  

        System.out.println("Введите имя");
        String name = sc.next();

        System.out.println("Введите фамилию");
        String surname = sc.next();
        
        System.out.println("Введите Дату рождения yyyy");
        String dr = sc.next();
        sc.close();

        PeopleController pc = new PeopleController(repo);
        People people = new People(name, surname, dr);
    //System.out.println(people.toString());

        switch (operetion) {
            case "L":
                pc.load(people);
                break;
            case "S":
                pc.save(people);
                break;
            case "U":
                pc.update(people);
                break;
            case "D":
                pc.delete(people);
                break;
            default:
                System.out.println("Неверная заданная операция");
        }

    }

}
