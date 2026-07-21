package modelos;

public class ItemPedido {

    private int id;
    private int idPedido;
    private int idProduto;
    private int quantidade;
    private double valorUnitario;


    public ItemPedido() {

    }


    public ItemPedido(int idPedido, int idProduto, int quantidade, double valorUnitario) {

        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getIdPedido() {
        return idPedido;
    }


    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }


    public int getIdProduto() {
        return idProduto;
    }


    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }


    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public double getValorUnitario() {
        return valorUnitario;
    }


    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}