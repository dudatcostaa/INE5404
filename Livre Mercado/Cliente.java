/**
 * Classe que representa um cliente do sistema de comércio eletrônico.
 * Um cliente possui dados de identificação, endereço, conta bancária,
 * um estoque de produtos (para venda) e um carrinho de produtos (para compra).
 */
public class Cliente {

    private String nome;
    private String endereco;

    /** Conta bancária composta pelo cliente. */
    private ContaBancaria contaBancaria;

    /** Estoque de produtos para venda. */
    private ColecaoProdutos estoque;

    /** Carrinho de produtos para compra. */
    private ColecaoProdutos carrinho;

    /**
     * Construtor da classe Cliente.
     *
     * @param nome Nome do cliente.
     * @param endereco Endereço do cliente.
     * @param contaBancaria Conta bancária do cliente.
     */
    public Cliente(String nome, String endereco, ContaBancaria contaBancaria) {
        this.nome = nome;
        this.endereco = endereco;
        this.contaBancaria = contaBancaria;
        this.estoque = new ColecaoProdutos();
        this.carrinho = new ColecaoProdutos();
    }

    // Métodos getters e setters

    /**
     * Retorna o nome do cliente.
     *
     * @return nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o endereço do cliente.
     *
     * @return endereço do cliente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Retorna a conta bancária do cliente.
     *
     * @return conta bancária associada.
     */
    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    /**
     * Retorna o estoque de produtos do cliente.
     *
     * @return coleção de produtos para venda.
     */
    public ColecaoProdutos getEstoque() {
        return estoque;
    }

    /**
     * Retorna o carrinho de produtos do cliente.
     *
     * @return coleção de produtos para compra.
     */
    public ColecaoProdutos getCarrinho() {
        return carrinho;
    }

    @Override
    public String toString() {
        String result = "Cliente: " + nome + "\n";
        result += "Endereço: " + endereco + "\n";
        result += "Conta Bancária: " + (contaBancaria != null ? contaBancaria.toString() : "null") + "\n";
        result += "Estoque: " + (estoque != null ? estoque.toString() : "null") + "\n";
        result += "Carrinho: " + (carrinho != null ? carrinho.toString() : "null") + "\n";
        return result;
    }
}
