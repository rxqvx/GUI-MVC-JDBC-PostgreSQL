package controller;

import dao.ProdutoDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Produto;
import view.CadastroJanela;
import view.VizualizarJanela;

public class Controller {
    
    private CadastroJanela cadastro;
    private VizualizarJanela vizualizar;
    
    
    public Controller(CadastroJanela janela) {
        this.cadastro = janela;
    }
    
    public Controller(VizualizarJanela vizualizar){
        this.vizualizar = vizualizar;
    }
    
    public void salvarProduto(){
            String nome = cadastro.getTxtNome().getText();
            String quantidade = cadastro.getTxtQtd().getText();
            String valor = cadastro.getTxtValor1().getText();
            String id = cadastro.getTxtId().getText();
            Produto produto = new Produto(nome, quantidade, valor ,id);
//            nome quantidade valor e id
            Conexao conn = new Conexao();

            try{
                Connection c = conn.getConexao();
                ProdutoDAO dao = new ProdutoDAO(c);
                dao.inserir(produto);
                JOptionPane.showMessageDialog(cadastro, "Produto cadastrado com sucesso!");
                System.out.println("Conectado ao banco e cadastrado.");
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(cadastro, "Falha, talvez o id já exista ou banco não quer conectar!");
                System.out.println("Falha na conexão ou na função de inserir ao banco");
            }
        }

    public void vizualizar(){
        String prod = vizualizar.getTxtProduto().getText();
        String id = vizualizar.getTxtId().getText();
        
        Produto produto = new Produto(prod, null, null, id);
        Conexao conn = new Conexao();
        try{
            Connection c = conn.getConexao();
            ProdutoDAO dao = new ProdutoDAO(c);
            ResultSet res = dao.consultar(produto);
            System.out.println(res);
            while(res.next()){
               JOptionPane.showMessageDialog(vizualizar, "Produto encontrado! " + "\nNome: " + res.getString(1) + "\nValor: " + res.getString(3) + "\nQuantidade: " + res.getString(2) + "\nId: " + res.getString(4));
            }
//            else{
//                JOptionPane.showMessageDialog(rootPane,"Errou!");
//            }
//            
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(vizualizar, "Falha!");
            System.out.println("Falha!");
        }
    }
    
}
