package utils;

import javax.servlet.http.HttpServletRequest;

public abstract class Strings {

    public static String getOperacao(HttpServletRequest request) {
        String operation = get(request, "operacao");
        return operation == null ? get(request, "Operacao") : operation;
    }

    public static String get(HttpServletRequest request, String name) {
        return request.getParameter(name);
    }
    
}
