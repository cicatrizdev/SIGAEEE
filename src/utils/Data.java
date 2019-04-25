/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author davi
 */
public abstract class Data {

    public static String DevolveData() {
        Date hoje = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        return sdf.format(hoje);
    }
}
