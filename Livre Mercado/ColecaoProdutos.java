import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma coleção de itens de produtos.
 * Pode ser utilizada tanto para o estoque de venda quanto para o carrinho de compras.
 */
public class ColecaoProdutos {

    /** Lista de itens de produtos. */
    private List<ItemProduto> itens;

    /**
     * Construtor que inicializa a coleção vazia.
     */
    public ColecaoProdutos() {
        this.itens = new ArrayList<ItemProduto>();
    }

    /**
     * Adiciona um item de produto à coleção.
     *
     * @param item Item do produto a ser adicionado.
     */
    public void adicionarItem(ItemProduto item) {
        this.itens.add(item);
    }

    /**
     * Remove um item de produto da coleção.
     *
     * @param item Item do produto a ser removido.
     * @return true se o item for removido com sucesso, false caso contrário.
     */
    public boolean removerItem(ItemProduto item) {
        return this.itens.remove(item);
    }

    /**
     * Retorna a lista de itens de produto.
     * TODO: Retornar uma lista costuma não ser uma prática. Deveria ser evitado
     * @return lista de itens.
     */
    public List<ItemProduto> getItens() {
        return itens;
    }

    /**
     * Calcula o valor total dos itens na coleção.
     *
     * @return valor total dos produtos na coleção.
     */
    public double calcularTotal() {
        double total = 0;
        for (ItemProduto item : itens){
            total += item.getProduto().getPrecoBase() * item.getQuantidade();
        }
        return total;
    }

    @Override
    public String toString() {
        String result = "ColecaoProdutos:\n";
        if (itens != null && !itens.isEmpty()) {
            for (ItemProduto item : itens) {
                result += "  - " + item.toString() + "\n";
            }
        } else {
            result += "  [Nenhum item]";
        }
        return result;
    }
}
