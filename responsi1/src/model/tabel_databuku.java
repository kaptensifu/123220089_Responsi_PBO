/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class tabel_databuku extends AbstractTableModel {
    List<databuku>dp;
    public tabel_databuku(List<databuku>dp){
        this.dp=dp;
    }

    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getJudul();
            case 1:
                return dp.get(row).getPenulis();
            case 2:
                return dp.get(row).getRating();
            case 3:
                return dp.get(row).getHarga();
            case 4:
                return dp.get(row).getId();
                
                default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Penulis";
            case 2:
                return "Rating";
            case 3:
                return "Harga";
            case 4:
                return "ID";
            default:
                return null;
            
        }
    }

    

}
