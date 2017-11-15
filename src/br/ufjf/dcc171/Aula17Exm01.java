package br.ufjf.dcc171;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aula17Exm01 {

    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverUrl = "jdbc:derby://localhost:1527/2017-3-dcc171";
            Connection conexao = DriverManager.getConnection(driverUrl, "USUARIO", "SENHA");
            PreparedStatement operacaoInsere = conexao.prepareStatement("insert into produto (nome, qtd, atualizado) values"
                    + "(?, ?, current_timestamp)");
            PreparedStatement operacaoListar = conexao.prepareStatement("select nome, qtd from produto where qtd > ?");
            Random rnd = new Random();
            for (int i = 0; i < 10; i++)
            {
                operacaoInsere.clearParameters();
                operacaoInsere.setString(1, "Produto " + rnd.nextInt(100));
                operacaoInsere.setInt(2, rnd.nextInt(10) + 1);
                operacaoInsere.executeUpdate();
            }
            operacaoListar.clearParameters();
            operacaoListar.setInt(1, 0);
            ResultSet resultado = operacaoListar.executeQuery();
            while (resultado.next())
            {
                Produto p = new Produto();
                p.setNome(resultado.getString(1));
                p.setQtd(resultado.getInt(2));
                System.out.println(resultado.getString(1) + "\t\t" + resultado.getInt(2));
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(Aula17Exm01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
