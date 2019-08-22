/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Brama Hendra Mahendra
 */
public class Peserta {
    private String Ussername;
    private String Nama;
    
    public Peserta (String Username, String Nama) {
        this.Ussername = Username;
        this.Nama = Nama;
    }

    public String getUssername() {
        return Ussername;
    }

    public String getNama() {
        return Nama;
    }

    @Override
    public String toString() {
        return "Ussername\t:" + Ussername + "\n"
                + "Nama\t:" + Nama + "\n";
    }
    
    
}
