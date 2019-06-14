/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author admin
 */
public abstract class CRUD {

    public static void InvokeMethod(String nomeClasse, String operacao, Object p) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class classe = Class.forName("model." + nomeClasse);
        Object objeto = p;
        Method metodo = classe.getMethod(operacao);

        metodo.invoke(objeto);
    }
}
