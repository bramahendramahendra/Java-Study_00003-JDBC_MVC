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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    private String Server = "jdbc:mysql://localhost:3305/DatabaseBrama";
    private String dbUser = "root";
    private String dbPassword = "";
    private Statement St = null;
    private Connection Con = null;
    
    public void connect() {
        try {
            Con = DriverManager.getConnection(Server, dbUser, dbPassword);
            St = Con.createStatement();
        } catch (Exception e) {
            throws new IllegalArgumentException("Terjadi Kesalahan saat koneksi");
        }
    }
    
    public void savePeserta(Peserta P) {
        try {
            String query = "insert into peserta(username,nama) values"
                    + "('" + P.getUssername() + "',"
                    + "'" + P.getNama() + "')";
            St.execute(query);
        } catch (Exception e) {
            throws new IllegalArgumentException("Terjadi Kesalahan saat save Peserta");
        }
    }
    
    public void saveTim(Tim T) {
        try {
            String query = "insert into tim(judul) values"
                    +"('" + T.getJudul() + "')";
            St.execute(query, St.RETURN_GENERATED_KEYS);
            ResultSet Rs = St.getGeneratedKeys();
            if (Rs.next()) {
                int GeneratedId = Rs.getInt(1);
                T.setId(GeneratedId);
            }
        } catch (Exception e) {
            throws new IllegalArgumentsException("Terjadi kesalahan saat save Tim");
        }
    }
    
    public ArrayList<Peserta> loadPeserta() {
        try {
            ArrayList<Peserta> DaftarPeserta = new ArrayList<>();
            String query = "select * from peserta";
            ResultSet Rs =  St.executeQuery(query);
            while (Rs.next()) {                
                Peserta P = new Peserta(Rs.getString(1), Rs.getString(2));
                DaftarPeserta.add(P);
            }
            return DaftarPeserta;
        } catch (Exception e) {
            throws new IllegalArgumentException("Terjadi Kesalahan saat load Peserta");
        }
    }
    
    public ArrayList<Tim> loadTim() {
        try {
            ArrrayList<Tim> DaftarTim = new ArrayList<>();
            String query = "select * from tim";
            ResultSet Rs = St.executeQuery(query);
            while (Rs.next()) {                
                Tim T = new Tim(Rs.getInt(1), Rs.getString(2));
                Statement St1 = Con.createStatement();
                String query1 = "select * from peserta where id=" + T.getId();
                ResultSet Rs1 = St1.executeQuery(query1);
                while (Rs1.next()) {                    
                    Peserta P = new Peserta(Rs1.getString(1), Rs1.getString(2));
                    T.addAnggota(P);
                }
                DaftarTim.add(T);
            }
            return DaftarTim;
        } catch (Exception e) {
            throws new IllegalArgumentException("Terjadi kesalahan saat load tim");
        }
    }
    
    public void updateTim(Tim T, Peserta P) {
        try {
            String query;
            if (T != null) {
                query = "update peserta set id=" +T.getId()
                        + "where username='" + P.getUssername() + "'";
            } else {
                query = "update peserta set id=null where username ='"
                        + P.getUssername() + "'";
            }
            St.execute(query);
        } catch (Exception e) {
            throws new IllegalArgumentException("terjadi kesalahan update tim");
        }
    }
    
}
