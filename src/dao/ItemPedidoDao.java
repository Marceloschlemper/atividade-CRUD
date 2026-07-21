package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.ConectaDB;
import modelos.ItemPedido;

public class ItemPedidoDao {


    public void adicionar(ItemPedido item) {

        Connection con = ConectaDB.conectar();

        try {

            String sql = "insert into tb_itens_pedido "
                    + "(id_pedido, id_produto, quantidade, valor_unitario) "
                    + "values (?, ?, ?, ?)";


            PreparedStatement stm = con.prepareStatement(sql);


            stm.setInt(1, item.getIdPedido());
            stm.setInt(2, item.getIdProduto());
            stm.setInt(3, item.getQuantidade());
            stm.setDouble(4, item.getValorUnitario());


            stm.executeUpdate();


            System.out.println("Produto adicionado ao pedido!");
            
            stm.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
