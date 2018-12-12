/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class Dokumen {

    private String isi;
    private int front;
    private int size;
    private ArrayList<String> data;

    public Dokumen() {
        data = new ArrayList<String>();
        this.size = 0;
        this.front = -1;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getIsi() {
        return isi;
    }

    public boolean push(String input) {
        if (data.size() == 0) {
            front++;
            size++;
            data.add(input);

        } else {
            if (data.size() == front + 1) {
                front++;
                size++;
                data.add(input);
            } else {
                front++;
                size++;
                data.set(front, input);
            }

        }
        return true;
    }

    public void pop() {
        if (isEmpty() == false) {
            front--;
            size--;
        }

    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String isi = " ";
        for (int i = front; i >= 0; i--) {
            isi += data.get(i) + " ";

        }
        return isi;
    }

    public void bacaDariFile(File file) {
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            String hasil = "";
            int dataInt;
            while ((dataInt = fis.read()) != -1) {
                hasil = hasil + (char) dataInt;
            }
            setIsi(hasil);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void simpanKeFile(File file) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            String data = this.getIsi();
            fos.write(data.getBytes());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
