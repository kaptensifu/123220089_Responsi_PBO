/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdatabuku.databukuDAO;
import DAOImplement.databukuimplement;
import model.*;
import view.MainView;

/**
 *
 * @author Acer
 */
public class databukucontroller {
    MainView frame;
    databukuimplement impldatabuku;
    List<databuku>dp;
    
    public databukucontroller(MainView frame){
        this.frame = frame;
        impldatabuku = new databukuDAO();
        dp = impldatabuku.getAll();
        
    }
    public void isitabel(){
        dp=impldatabuku.getAll();
        tabel_databuku mp = new tabel_databuku(dp);
        frame.getTabelbuku().setModel(mp);
    }
    public void insert(){
        databuku dp = new databuku();
        dp.setJudul(frame.getJtxtjudul().getText());
        dp.setPenulis(frame.getJtxtpenulis().getText());
        dp.setRating(Float.parseFloat(frame.getJtxtrating().getText()));
        dp.setHarga(dp.Hitung());
        impldatabuku.insert(dp);
        
    }
    public void delete(){
        databuku dp = new databuku();
        dp.setJudul(frame.getJtxtjudul().getText());
        impldatabuku.delete(dp);
    }
}
