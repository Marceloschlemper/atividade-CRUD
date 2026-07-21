package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pedido {

    private int id;
    private Cliente cliente;
    private LocalDate data;
    private String status;
    private List<ItemPedido> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public Pedido(Cliente cliente, LocalDate data, String status) {
        this.cliente = cliente;
        this.data = data;
        this.status = status;
        this.itens = new ArrayList<>();
    }

    public Pedido(int id, Cliente cliente, LocalDate data, String status, List<ItemPedido> itens) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.status = status;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public void adicionarItem(Produto produto, int quantidade) {

        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        ItemPedido item = new ItemPedido();

        item.setIdProduto(produto.getId());
        item.setQuantidade(quantidade);
        item.setValorUnitario(produto.getPreco());

        itens.add(item);
    }

    public void removerItem(int idProduto) {

        Iterator<ItemPedido> iterator = itens.iterator();

        while (iterator.hasNext()) {

            ItemPedido item = iterator.next();

            if (item.getIdProduto() == idProduto) {
                iterator.remove();
                break;
            }
        }
    }

}