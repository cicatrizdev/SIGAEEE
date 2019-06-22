/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import model.Esporte;

/**
 *
 * @author admin
 */
public class testeFind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Long id = new Long(51);
       Esporte esporte = Esporte.find(id);
       System.out.println(esporte.getNomeEsporte());
       esporte.remove();
    }
    
}
