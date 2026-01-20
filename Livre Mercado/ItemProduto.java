/**
 * Classe que representa um item de produto com sua quantidade.
 */
public class ItemProduto {
    private Produto produto;
    private int quantidade;

    /**
     * Construtor para criação de um item de produto.
     *
     * @param produto    Produto associado ao item.
     * @param quantidade Quantidade do produto.
     */
    public ItemProduto(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    /**
     * Retorna o produto associado ao item.
     *
     * @return produto.
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Retorna a quantidade do produto.
     *
     * @return quantidade.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Seta a quantidade do produto.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemProduto{" + "produto=" + produto + ", quantidade=" + quantidade + '}';
    }
}
