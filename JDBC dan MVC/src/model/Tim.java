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
import java.util.ArrayList;

public class Tim {
    private int Id;
    private String Judul;
    private ArrayList<Peserta> Anggota;
    
    public Tim(String Judul) {
        this.Judul = Judul;
        Anggota = new ArrayList();
    }
    
    public Tim(int Id, String Judul) {
        this.Id = Id;
        this.Judul = Judul;
        Anggota = new ArrayList();
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public int getId() {
        return Id;
    }

    public String getJudul() {
        return Judul;
    }

    public Peserta getAnggota(String Username) {
        for (Peserta P : Anggota) {
            if (P.getUssername().equals(Username)) {
                return P;
            }
        }
        return null;
    }
    
    public void addAnggota(Peserta P) {
        Anggota.add(P);
    }
    
    public void removeAnggota(String Username) {
        Peserta P = getAnggota(Username);
        Anggota.remove(P);
    }

    @Override
    public String toString() {
        String S = "Tim " + Id + " : \n" 
                + "Judul\t: " + Judul + " \n"  
                + "Daftar Anggota:\n";
        for (Peserta P1 : Anggota) {
            S += P1.getUssername() + "\n";
        }
        return S;
    }
    
}
