import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma categoria de produtos.
 * Uma categoria possui um nome, uma lista de subcategorias (utilizando o padrão Composite)
 * e uma lista de produtos que pertencem a esta categoria.
 */
public class Categoria {

    private String nome;
    private String descricao;
    private List<Categoria> subcategorias;
    private List<Produto> produtos;

    /**
     * Construtor para criação de uma categoria.
     *
     * @param nome Nome da categoria.
     */
    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.subcategorias = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    /**
     * Retorna o nome da categoria.
     *
     * @return nome da categoria.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a descrição da categoria.
     *
     * @return descrição da categoria.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna a lista de subcategorias.
     * TODO: Retornar uma lista costuma não ser uma prática. Deveria ser evitado
     *
     * @return subcategorias.
     */
    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }

    /**
     * Retorna a lista de produtos pertencentes à categoria.
     * TODO: Retornar uma lista costuma não ser uma prática. Deveria ser evitado
     *
     * @return produtos.
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Adiciona uma subcategoria à categoria.
     *
     * @param subcategoria Subcategoria a ser adicionada.
     */
    public void adicionarSubcategoria(Categoria subcategoria) {
        this.subcategorias.add(subcategoria);
    }

    /**
     * Remove uma subcategoria da categoria.
     * Se a subcategoria não existir, nada é feito.
     * Se a subcategoria existir, então todos os produtos da subcategoria passam a ser
     * produtos desta categoria (this, a categoria-pai da subcategoria a ser removida), e
     * todas as subcategorias da subcategoria a ser removida passam a ser
     * subcategorias desta categoria.
     *
     * @param subcategoria Subcategoria a ser removida.
     */
    public void removerSubcategoria(Categoria subcategoria) {
        if (!subcategorias.contains(subcategoria)) {
            throw new IllegalArgumentException("A subclasse não existe");
        }

        for (Produto produto : new ArrayList<>(subcategoria.produtos)) {
            this.adicionarProduto(produto);
        }

        for (Categoria subSub : new ArrayList<>(subcategoria.subcategorias)) {
            this.adicionarSubcategoria(subSub);
        }

        subcategorias.remove(subcategoria);
    }

    /**
     * Adiciona um produto à categoria.
     *
     * @param produto Produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    /**
     * Remove um produto da categoria.
     *
     * @param produto Produto a ser removido.
     */
    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    @Override
    public String toString() {
        String result = "Categoria: " + nome + "\n";
        result += "Descrição: " + descricao + "\n";
        result += "Produtos:\n";
        if (produtos != null && !produtos.isEmpty()) {
            for (Produto produto : produtos) {
                result += "  - " + produto.toString() + "\n";
            }
        } else {
            result += "  [Nenhum produto]\n";
        }
        result += "Subcategorias:\n";
        if (subcategorias != null && !subcategorias.isEmpty()) {
            for (Categoria subcategoria : subcategorias) {
                result += "  - " + subcategoria.toString() + "\n";
            }
        } else {
            result += "  [Nenhuma subcategoria]\n";
        }

        return result;
    }
}
