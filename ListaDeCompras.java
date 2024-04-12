import java.util.ArrayList;

public class ListaDeCompras {
    private ArrayList<String> itens;

    public ListaDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String item) {
        itens.add(item);
    }

    // Atualização do método removerItem para incluir um tratamento nos casos em que o item a ser removido não esteja presente na lista previamente 
    public void removerItem(String item) {
        if (!itens.remove(item)) {  // Tenta remover o item
            System.out.println(item + " não encontrado na lista e não pode ser removido."); // Imprime uma mensagem informativa caso o item não exista na lista
        }
    }

    public void exibirLista() {
        System.out.println("Lista de Compras:");
        for (String item : itens) {
            System.out.println("- " + item);
        }
    }

    public static void main(String[] args) {
        ListaDeCompras lista = new ListaDeCompras();
        lista.adicionarItem("Maçã");
        lista.adicionarItem("Banana");
        lista.adicionarItem("Pêra");
        lista.removerItem("Banana");
        lista.removerItem("Laranja");
        lista.exibirLista();
    }
}
