/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Walter
 */
public abstract class Strings {

    public static String getOperacao(HttpServletRequest request) {
        String operation = get(request, "operacao");
        return operation == null ? get(request, "Operacao") : operation;
    }

    public static String get(HttpServletRequest request, String name) {
        return request.getParameter(name);
    }
    
}
