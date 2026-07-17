package interfaces;

import java.util.List;
import modelos.Cliente;

public interface ICRUDCliente {

    Cliente salvar(Cliente cli);

    void alterar(Cliente cli);

    void deletar(int id);

    Cliente consultar(int id);

    List<Cliente> consultar();
}