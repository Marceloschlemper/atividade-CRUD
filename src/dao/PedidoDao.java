package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import utils.ConectaDB;
import interfaces.ICRUDPedido;
import modelos.Pedido;

public class PedidoDao implements ICRUDPedido {

	@Override
	public Pedido salvar(Pedido pedido) {

	    String sql = "insert into tb_pedidos(id_cliente, data, status) values (?, ?, ?)";

	    Connection con = ConectaDB.conectar();

	    try { 
	    	PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    	stm.setInt(1, pedido.getCliente().getId());
	    	stm.setDate(2, Date.valueOf(pedido.getData()));
	    	stm.setString(3, pedido.getStatus());
	    	
	    	stm.executeUpdate();

	    	ResultSet rs = stm.getGeneratedKeys();

	    	if (rs.next()) {
	    	    pedido.setId(rs.getInt(1));
	    	}

	    	rs.close();
	    	stm.close();
	    	con.close();

	    	return pedido;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}

    @Override
    public void alterar(Pedido pedido) {

    }

    @Override
    public void deletar(int id) {

    }

    @Override
    public Pedido consultar(int id) {
        return null;
    }

    @Override
    public List<Pedido> consultar() {
        return null;
    }

}