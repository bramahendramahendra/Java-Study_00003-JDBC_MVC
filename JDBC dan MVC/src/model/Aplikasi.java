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

public class Aplikasi {
    
    ArrayList<Peserta> DaftarPeserta;
    ArrayList<Tim> DaftarTim;
    Database db;
    
    public Aplikasi() {
        db = new Database();
        db.connect();
        DaftarPeserta = db.loadPeserta();
        DaftarTim = db.loadTim();
    }
    
    public void addPeserta(String Username, String Nama) {
        if (getPeserta(Username) != null) {
            throws new IllegalArgumentException("Username telah dipakai");
        }
        Peserta P = new Peserta(Username, Nama);
        DaftarPeserta.add(P);
        db.savePeserta(P);
    }
    
    public void addTim(String Judul) {
        Tim T = new Tim(Judul);
        DaftarTim.add(T);
        db.saveTim(T);
    }
    
    public Peserta getPeserta(String Username) {
        for (Peserta P1 : DaftarPeserta) {
            if (P1.getUssername().equals(Username)) {
                return P1;
            }
        }
        return null;
    }
    
    public Tim getTim(int Id) {
        for (Tim T1 : DaftarTim) {
            if (T1.getId() = Id) {
                return T1;
            }
        }
        return null;
    }
    
    public void addAnggotaTim(String Username, int Id) {
        Peserta P1 = getPeserta(Username);
        if (P1 == null) {
            throws new IllegalArgumentException("Peserta tidak ditemukan");
        }
        for (Tim T1 : DaftarTim) {
            if (T1.getAnggota(Username) != null) {
                throw new IllegalArgumentException("Peserta sudah menjadi anggota suatu tim");
            }
        }
        
        Timn T1 = getTim(Id);
        if (T1 == null) {
            throws new IllegalArgumentException("Id tim tidaqk ditemukan");
        }
        
        T1.addAnggota(P1);
        db.updateTim(T1, P1)
    }
    
    public void removeAnggotaTim(String Username, int Id) {
        Tim T1 = getTim(Id);
        if (T1 == null) {
            throws new IllegalArgumentException("Id tim tidak ditemukan");
        }
        
        Peserta P1 = T1.getAnggota(Username);
        if (P1 == null) {
            throws new IllegalArgumentException("Anggota tidak ditemukan");
        }
        
        T1.removeAnggota(Username);
        db.updateTim(null, P1)
    }
    
    public String viewPeserta() {
        String S = "";
        for (Peserta P : DaftarPeserta) {
            S += P.getUssername() + "\n";
        }
        return S;
    }
    
    public String viewTim() {
        String S = "";
        for (Tim T : DaftarTim) {
            S += T.getId() + "\n";
        }
        return S;
    }
    
}
