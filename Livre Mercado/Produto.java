/**
 * Classe que representa um produto do sistema.
 * Um produto possui nome, descrição, preço-base, vendedor e categoria.
 */
public class Produto {
    private String nome;
    private String descricao;
    private double precoBase;
    private Cliente vendedor;
    private Categoria categoria;

    /**
     * Construtor da classe Produto.
     *
     * @param nome      Nome do produto.
     * @param descricao Descrição do produto.
     * @param precoBase Preço-base do produto.
     * @param vendedor  Cliente que está vendendo o produto.
     * @param categoria Categoria à qual o produto pertence.
     */
    public Produto(String nome, String descricao, double precoBase, Cliente vendedor, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.vendedor = vendedor;
        this.categoria = categoria;
    }

    /**
     * Retorna o nome do produto.
     *
     * @return nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return descrição.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna o preço-base do produto.
     *
     * @return preço-base.
     */
    public double getPrecoBase() {
        return precoBase;
    }

    /**
     * Retorna o vendedor do produto.
     *
     * @return cliente vendedor.
     */
    public Cliente getVendedor() {
        return vendedor;
    }

    /**
     * Retorna a categoria do produto.
     *
     * @return categoria do produto.
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Seta a categoria do produto.
     * Se o produto já tinha uma categoria não nula,
     * precisa tirar o produto da lista de produtos da categoria antiga, e
     * acrescentar o produto na lista de produtos da nova categoria (se não for nula), e
     * atualizar o atributo categoria do produto.
     *
     * @param categoria do produto.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria.removerProduto(this);

        this.categoria = categoria;

        if (this.categoria != null) {
            this.categoria.adicionarProduto(this);
        }
    }

    @Override
    public String toString() {
        return "Produto{" + "nome='" + nome + "'" + ", descricao='" + descricao + "'" + ", precoBase = " + precoBase + ", vendedor = " + vendedor.getNome() + ", categoria = " + categoria.getNome() + '}';
    }

}

