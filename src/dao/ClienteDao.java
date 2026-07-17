package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import interfaces.ICRUDCliente;
import modelos.Cliente;
import utils.ConectaDB;

public class ClienteDao implements ICRUDCliente {

    @Override
    public Cliente salvar(Cliente cli) {

        String sql = "insert into tb_clientes(cpf, nome, email, rua, numero, bairro, cep, cidade, estado) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection con = ConectaDB.conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stm.setString(1, cli.getCpf());
            stm.setString(2, cli.getNome());
            stm.setString(3, cli.getEmail());
            stm.setString(4, cli.getRua());
            stm.setInt(5, cli.getNumero());
            stm.setString(6, cli.getBairro());
            stm.setString(7, cli.getCep());
            stm.setString(8, cli.getCidade());
            stm.setString(9, cli.getEstado());

            stm.executeUpdate();

            ResultSet rs = stm.getGeneratedKeys();

            if (rs.next()) {
                cli.setId(rs.getInt(1));
            }

            rs.close();
            stm.close();
            con.close();

            return cli;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void alterar(Cliente cli) {

        String sql = "update tb_clientes set cpf = ?, nome = ?, email = ?, rua = ?, numero = ?, bairro = ?, cep = ?, cidade = ?, estado = ? where id = ?";

        Connection con = ConectaDB.conectar();

        try {

            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, cli.getCpf());
            stm.setString(2, cli.getNome());
            stm.setString(3, cli.getEmail());
            stm.setString(4, cli.getRua());
            stm.setInt(5, cli.getNumero());
            stm.setString(6, cli.getBairro());
            stm.setString(7, cli.getCep());
            stm.setString(8, cli.getCidade());
            stm.setString(9, cli.getEstado());
            stm.setInt(10, cli.getId());

            stm.executeUpdate();

            stm.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        
    

    @Override
    public void deletar(int id) {
        
        String sql = "delete from tb_clientes where id = ?";
        Connection con = ConectaDB.conectar();
        
        try {
        
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente consultar(int id) {

        Cliente cliente = null;

        Connection con = ConectaDB.conectar();

        try {

            PreparedStatement stm = con.prepareStatement(
                "select * from tb_clientes where id = ?"
            );

            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                cliente = new Cliente(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10)
                );
            }

            rs.close();
            stm.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    @Override
    public List<Cliente> consultar() {
    	List<Cliente> clientes = new ArrayList<Cliente>();

        Connection con = ConectaDB.conectar();
        
        try {

            PreparedStatement stm = con.prepareStatement(
                    "select * from tb_clientes");

            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {

            	    Cliente cliente = new Cliente(
            	        rs.getInt(1),
            	        rs.getString(2),
            	        rs.getString(3),
            	        rs.getString(4),
            	        rs.getString(5),
            	        rs.getInt(6),
            	        rs.getString(7),
            	        rs.getString(8),
            	        rs.getString(9),
            	        rs.getString(10)
            	    );

            	    clientes.add(cliente);
            	}
            	rs.close();
				stm.close();
				con.close();

            

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
    }
