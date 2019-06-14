/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.lang.reflect.InvocationTargetException;
import model.Equipe;
import utils.CRUD;

/**
 *
 * @author admin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.NoSuchMethodException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        // TODO code application logic here
        Equipe equipe = new Equipe();
        String nome ="Cruzeiro";
        equipe.setNome(nome);
        System.out.println(equipe.getNome());
        
        CRUD.CRUD("Equipe","save",equipe);
     
    }
    
}
