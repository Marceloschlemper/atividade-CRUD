import java.util.Scanner;
import modelos.Produto;
import java.util.List;
import dao.ProdutoDao;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProdutoDao dao = new ProdutoDao();

        int opcao;

        do {

        	System.out.println(" MENU PRODUTOS");
        	System.out.println("1 - Cadastrar produto");
        	System.out.println("2 - Listar produtos");
        	System.out.println("3 - Consultar produto");
        	System.out.println("4 - Alterar produto");
        	System.out.println("5 - Excluir produto");
        	System.out.println("0 - Sair");
        	
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
        	    
        	    Produto produto = new Produto(descricao, preco);
        	    
        	    Produto retorno = dao.salvar(produto);
        	    
        	    System.out.println("Produto cadastrado com sucesso!");
        	    System.out.println("ID: " + retorno.getId());
        	    break;
        	}
        	    
        	    
        		
        	 case 2: {

        	    List<Produto> lista = dao.consultar();

        	    System.out.println("\n------ LISTA DE PRODUTOS ------");

        	    for (Produto p : lista) {
        	        System.out.println(
        	            p.getId() + " | " +
        	            p.getDescricao() + " | R$ " +
        	            p.getPreco()
        	        );
        	    }

        	    System.out.println("-------------------------------");

        	    break;
        	}
        	
        	case 3: {
        		System.out.print("Digite o ID do produto: ");
        		int id = sc.nextInt();
        		sc.nextLine();
        		
        		Produto produto = dao.consultar(id);
        		
        		if (produto != null) {
        		    System.out.println("ID: " + produto.getId());
        		    System.out.println("Descrição: " + produto.getDescricao());
        		    System.out.println("Preço: " + produto.getPreco());
        		} else {
        		    System.out.println("Produto não encontrado.");
        		}
        		
        		break;
        	}
        		
        		

        	case 4: {
        	    System.out.print("Digite o ID do produto: ");
        	    int id = sc.nextInt();
        	    sc.nextLine();

        	    Produto produto = dao.consultar(id);

        	    if (produto != null) {

        	        System.out.println("Descrição atual: " + produto.getDescricao());
        	        System.out.println("Preço atual: " + produto.getPreco());

        	        System.out.print("Nova descrição: ");
        	        String descricao = sc.nextLine();

        	        System.out.print("Novo preço: ");
        	        double preco = sc.nextDouble();
        	        sc.nextLine();

        	        produto.setDescricao(descricao);
        	        produto.setPreco(preco);

        	        dao.alterar(produto);

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
        		
        		dao.deletar(id);
        		System.out.println("Produto excluído com sucesso!");
        		
        		break;
        	}

        	case 0:
        	    System.out.println("Encerrando...");
        	    break;
        	    
        	default:
        	    System.out.println("Opção inválida.");
        	}

        } while (opcao != 0);

        // sc.close();
    }

}


	

