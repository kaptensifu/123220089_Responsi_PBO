/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatabuku;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.databukuimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Acer
 */
public class databukuDAO implements databukuimplement {
    Connection connection;
    
    final String select = "SELECT * FROM buku;";
    final String insert = "INSERT INTO buku(judul,penulis,rating,harga) VALUES (?,?,?,?);";
     final String update = "UPDATE buku set judul=?, penulis=?, rating=?, harga=? WHERE judul=?;";
     final String delete = "DELETE FROM `movie` WHERE judul=?";
    public databukuDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(databuku p) {
        PreparedStatement statement =null;
        try{
            statement = connection.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,p.getJudul());
            statement.setString(2,p.getPenulis());
            statement.setFloat(3,p.getRating());
            statement.setInt(4,p.getHarga());
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(databuku p) {
        PreparedStatement statement =null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1,p.getJudul());
            statement.setString(2,p.getPenulis());
            statement.setFloat(3,p.getRating());
            statement.setInt(4,p.getHarga());
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(databuku p) {
        PreparedStatement statement =null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1,p.getJudul());
            
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<databuku> getAll() {
        List<databuku> dp=null;
        try{
            dp=new ArrayList<databuku>();
        
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
        while(rs.next()){
            databuku buku = new databuku();
            buku.setJudul(rs.getString("judul"));
            buku.setPenulis(rs.getString("penulis"));
            buku.setRating(rs.getFloat("rating"));
            buku.setHarga(rs.getInt("harga"));
            buku.setId(rs.getInt("id"));
            dp.add(buku);
        }
        }catch(SQLException ex){
            Logger.getLogger(databuku.class.getName()).log(Level.SEVERE,null,ex);
        }
        return dp;
    }
    
}
