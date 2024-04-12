import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControleEstoque {
    private static Map<String, Integer> estoque = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Vender Produto");
            System.out.println("3 - Exibir Estoque");
            System.out.println("4 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // método acrescentado para que seja possível capturar a linha inteira da entrada - e vitar eventuais problemas para os casos em que a entrada seja composta por mais de uma palavra

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner);
                    break;
                case 2:
                    venderProduto(scanner);
                    break;
                case 3:
                    exibirEstoque();
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    scanner.close(); // Fechamento do scanner acrescentado como boa prática para liberação dos recursos de sistema que estiverem em uso
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void adicionarProduto(Scanner scanner) {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite a quantidade do produto:");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Mesma justificativa do primeiro comentário

        estoque.merge(nome, quantidade, Integer::sum); // método merge utilizado em substituição ao condicional anterior; executa a mesma coisa, mas de maneira mais simples e concisa
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void venderProduto(Scanner scanner) {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite a quantidade a ser vendida:");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Mesma justificativa do primeiro comentário

        if (estoque.containsKey(nome)) {
            int estoqueAtual = estoque.get(nome);
            if (estoqueAtual >= quantidade) {
                estoque.put(nome, estoqueAtual - quantidade);
                System.out.println("Venda realizada com sucesso!");
            } else {
                System.out.println("Quantidade insuficiente em estoque!");
            }
        } else {
            System.out.println("Produto não encontrado em estoque!");
        }
    }

    private static void exibirEstoque() {
        System.out.println("Estoque atual:");
        for (Map.Entry<String, Integer> entrada : estoque.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}
