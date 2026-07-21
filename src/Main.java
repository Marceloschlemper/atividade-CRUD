import java.util.Scanner;
import java.util.List;

import dao.ClienteDao;
import dao.ProdutoDao;
import modelos.Cliente;
import modelos.Produto;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProdutoDao produtoDao = new ProdutoDao();
        ClienteDao clienteDao = new ClienteDao();

        int opcaoPrincipal;
        int opcao;

        do {

            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Produtos");
            System.out.println("2 - Clientes");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcaoPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcaoPrincipal) {

            case 1:

                do {

                    System.out.println("\n===== MENU PRODUTOS =====");
                    System.out.println("1 - Cadastrar produto");
                    System.out.println("2 - Listar produtos");
                    System.out.println("3 - Consultar produto");
                    System.out.println("4 - Alterar produto");
                    System.out.println("5 - Excluir produto");
                    System.out.println("0 - Voltar");

                    System.out.print("Escolha uma opção: ");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao) {

                    case 1: {

                        System.out.print("Descrição: ");
                        String descricao = sc.nextLine();

                        System.out.print("Preço: ");
                        double preco = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Estoque: ");
                        int estoque = sc.nextInt();
                        sc.nextLine();

                        Produto produto = new Produto(descricao, preco, estoque);

                        Produto retorno = produtoDao.salvar(produto);

                        System.out.println("Produto cadastrado com sucesso!");
                        System.out.println("ID: " + retorno.getId());

                        break;
                    }

                    case 2: {

                        List<Produto> lista = produtoDao.consultar();

                        System.out.println("\n------ LISTA DE PRODUTOS ------");

                        for (Produto p : lista) {

                            System.out.println(
                                "ID: " + p.getId() +
                                " | Descrição: " + p.getDescricao() +
                                " | Preço: R$ " + p.getPreco() +
                                " | Estoque: " + p.getEstoque()
                            );

                        }

                        System.out.println("-------------------------------");

                        break;
                    }
                        

                    case 3: {

                        System.out.print("Digite o ID do produto: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        Produto produto = produtoDao.consultar(id);

                        if (produto != null) {

                            System.out.println("\n----- PRODUTO ENCONTRADO -----");
                            System.out.println("ID: " + produto.getId());
                            System.out.println("Descrição: " + produto.getDescricao());
                            System.out.println("Preço: R$ " + produto.getPreco());
                            System.out.println("Estoque: " + produto.getEstoque());
                            System.out.println("------------------------------");

                        } else {

                            System.out.println("Produto não encontrado.");

                        }

                        break;
                    }

                    case 4: {

                        System.out.print("Digite o ID do produto: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        Produto produto = produtoDao.consultar(id);

                        if (produto != null) {

                            System.out.println("Descrição atual: " + produto.getDescricao());
                            System.out.println("Preço atual: " + produto.getPreco());
                            System.out.println("Estoque atual: " + produto.getEstoque());

                            System.out.print("Nova descrição: ");
                            String descricao = sc.nextLine();

                            System.out.print("Novo preço: ");
                            double preco = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Novo estoque: ");
                            int estoque = sc.nextInt();
                            sc.nextLine();

                            produto.setDescricao(descricao);
                            produto.setPreco(preco);
                            produto.setEstoque(estoque);

                            produtoDao.alterar(produto);

                            System.out.println("Produto alterado com sucesso!");

                        } else {

                            System.out.println("Produto não encontrado.");

                        }

                        break;
                    }
                    case 5: {

                        System.out.print("Digite o ID do produto: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        Produto produto = produtoDao.consultar(id);

                        if (produto != null) {

                            produtoDao.deletar(id);

                            System.out.println("Produto excluído com sucesso!");

                        } else {

                            System.out.println("Produto não encontrado.");

                        }

                        break;
                    }

                    case 0:
                        break;

                    default:
                        System.out.println("Opção inválida.");
                    }

                } while (opcao != 0);

                break;

            case 2:

                do {

                    System.out.println("\n===== MENU CLIENTES =====");
                    System.out.println("1 - Cadastrar cliente");
                    System.out.println("2 - Listar clientes");
                    System.out.println("3 - Consultar cliente");
                    System.out.println("4 - Alterar cliente");
                    System.out.println("5 - Excluir cliente");
                    System.out.println("0 - Voltar");

                    System.out.print("Escolha uma opção: ");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao) {

                    case 1: {

                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        System.out.print("Rua: ");
                        String rua = sc.nextLine();

                        System.out.print("Número: ");
                        int numero = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Bairro: ");
                        String bairro = sc.nextLine();

                        System.out.print("CEP: ");
                        String cep = sc.nextLine();

                        System.out.print("Cidade: ");
                        String cidade = sc.nextLine();

                        System.out.print("Estado: ");
                        String estado = sc.nextLine();

                        Cliente cliente = new Cliente(
                            cpf,
                            nome,
                            email,
                            rua,
                            numero,
                            bairro,
                            cep,
                            cidade,
                            estado
                        );

                        Cliente retorno = clienteDao.salvar(cliente);

                        System.out.println("Cliente cadastrado com sucesso!");
                        System.out.println("ID: " + retorno.getId());

                        break;
                    }

                    case 2:
                        // Listar clientes
                        break;

                    case 3:
                        // Consultar cliente
                        break;

                    case 4:
                        // Alterar cliente
                        break;

                    case 5:
                        // Excluir cliente
                        break;

                    case 0:
                        break;

                    default:
                        System.out.println("Opção inválida.");
                    }

                } while (opcao != 0);

                break;

            default:

                System.out.println("Opção inválida.");
            }

        } while (opcaoPrincipal != 0);

        sc.close();
    }
}