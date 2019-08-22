/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Brama Hendra Mahendra
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.*;

public class Handler implements ActionListener {
    private Aplikasi model;
    private View view;
    
    model = new Aplikasi();
    view = new View();
    view.setVisible(true);
    view.addActionListener(this);
    view.setDaftarPeserta(model.viewPeserta());
    view.setDaftarTim(model.viewTim());
    
    public void actionPerformed(ActionEvent Ae) {
        Object source = Ae.getSource();
        try {
            if (source.equals(view.getBTambahPeserta())) {
                String Username = view.getTFUsernamePeserta();
                String Nama = view.getTFNamaPeserta();
                model.addPeserta(Username, Nama);
                view.reset();
            } else if (source.equals(view.getBTambahTim())) {
                String Judul = view.getTFJudulTim();
                model.addTim(Judul);
                view.reset();
            } else if (source.equals(view.getBCariPeserta())) {
                String Username = view.getTFUsernameCariPeserta();
                Peserta P = model.getPeserta(Username);
                view.reset();
                if (P == null) {
                    throws new IllegalArgumentException("Peserta tidak ditemukan");
                }
                view.setTAPeserta(P.toString());
            } else if (source.equals(view.getBCariTim())) {
                int id = view.getTFIDTimCariTim();
                Tim T = model.getTim(id);
                view.reset();
                if (T == null) {
                    throws new IllegalArgumentException("Id tim tidak ditemukan");
                }
                view.setTATim(T.toString());
            } else {
                
            }
        } catch (Exception e) {
        }
    }
    
}
