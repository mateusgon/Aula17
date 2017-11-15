package br.ufjf.dcc171;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aula17Exm01 {
    
    
    
    public static void main(String[] args) {
        try {
            ProdutoDAO dao = new ProdutoDAOJDBC();
            Random rnd = new Random();
            for (int i = 0; i < 10; i++)
            {
                Produto p = new Produto();
                p.setNome("Produto " + rnd.nextInt(100));
                p.setQtd(rnd.nextInt(10) + 1);
                dao.criar(p);
            }
            List <Produto> produtos = dao.listarTodos();
            for (Produto p : produtos)
            {
                System.out.println(p.getNome() + "\t\t" + p.getQtd());
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(Aula17Exm01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
