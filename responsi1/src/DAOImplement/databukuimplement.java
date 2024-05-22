/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author Acer
 */
public interface databukuimplement {
    public void insert(databuku p);
    public void update(databuku p);
    public void delete(databuku p);
    public List<databuku>getAll();
    
}
