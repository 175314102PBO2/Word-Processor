/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import model.Dokumen;

/**
 *
 * @author ACER
 */
public class Test1 {
    public static void main(String[] args) {
        Dokumen c = new Dokumen();

        c.push("Amel");
        c.push("Makan");
        c.push("Nasi");
        c.pop();
        c.push("Siska");
        c.push("Dan");
        c.push("Katrin");
        

        System.out.println(" Data :" + c.toString());
        System.out.println(" Size : " + c.getSize());
    }
}
