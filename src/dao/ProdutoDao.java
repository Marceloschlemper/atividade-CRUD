package dao;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException; 

import interfaces.ICRUD;
import modelos.Produto;
import utils.ConectaDB;

public class ProdutoDao implements ICRUD {

	@Override
	public Produto salvar(Produto prod) {
		String sql = "insert into tb_produtos(descricao, preco, estoque) values(?, ?, ?)";

	    Connection con = ConectaDB.conectar();

	    try {
	        PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	        stm.setString(1, prod.getDescricao());
	        stm.setDouble(2, prod.getPreco());
	        stm.setInt(3, prod.getEstoque());
	        

	        stm.executeUpdate();

	        ResultSet rs = stm.getGeneratedKeys();

	        if (rs.next()) {
	            prod.setId(rs.getInt(1));
	        }

	        rs.close();
	        stm.close();
	        con.close();

	        return prod;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}
	

	public void listar() {
		String sql = "select * from produto";
		
		try {
			Connection con = ConectaDB.conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println(
						rs.getInt("id")+ " - " +
				        rs.getString("descricao")+ " -" +
				        rs.getDouble("preco")+ " -" +
				        rs.getInt("quantidade"));
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
			
		}
	}

	@Override
	public void deletar(int id) {
		    String sql = "delete from tb_produtos where id = ?";			
			Connection con = ConectaDB.conectar();
			try {
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setInt(1, id);
				stm.execute();			
				
				stm.close();
				con.close();			
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}

	@Override
	public void alterar(Produto prod) {
		String sql = "update tb_produtos set descricao = ?, preco = ?, estoque = ? where id = ?";
		
		Connection con = ConectaDB.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, prod.getDescricao());
			stm.setDouble(2, prod.getPreco());
			stm.setInt(3, prod.getId());
	        stm.setInt(4, prod.getId());

			stm.execute();			
			
			stm.close();
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}


	@Override
	public Produto consultar(int id) {
	    Produto produto = null;
	    Connection con = ConectaDB.conectar();

	    try {
	        PreparedStatement stm = con.prepareStatement("select * from tb_produtos where id = ?");
	        stm.setInt(1, id);

	        ResultSet rs = stm.executeQuery();

	        while (rs.next()) {
	            produto = new Produto(
	                rs.getInt(1),
	                rs.getString(2),
	                rs.getDouble(3),
	                rs.getInt(4)
	            );
	        }

	        rs.close();
	        stm.close();
	        con.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return produto;
	}
	    
	    	
	    


	@Override
	public List<Produto> consultar() {
	    List<Produto> produtos = new ArrayList<Produto>();
	    Connection con = ConectaDB.conectar();

	    try {
	        PreparedStatement stm = con.prepareStatement("select * from tb_produtos");
	        ResultSet rs = stm.executeQuery();

	        while (rs.next()) {
	            Produto p = new Produto(
	                rs.getInt("id"),
	                rs.getString("descricao"),
	                rs.getDouble("preco"),
	                rs.getInt("estoque")
	            );

	            produtos.add(p);
	        }

	        rs.close();
	        stm.close();
	        con.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return produtos;
	}
}

