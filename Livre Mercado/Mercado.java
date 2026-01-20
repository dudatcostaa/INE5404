import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Classe principal que representa o Mercado.
 * O mercado agrega diversos clientes e possui uma conta bancária própria.
 * Além disso, disponibiliza o método para realizar a compra dos itens no carrinho.
 */
public class Mercado {

    private List<Cliente> clientes;
    private ContaBancaria contaMercado;
    private Categoria categoriaRaiz;

    /**
     * Construtor da classe Mercado.
     *
     * @param contaMercado Conta bancária do mercado.
     */
    public Mercado(ContaBancaria contaMercado) {
        this.contaMercado = contaMercado;
        this.clientes = new ArrayList<>();
        this.categoriaRaiz = new Categoria("Produtos", "Todos os produtos do mercado");
    }

    /**
     * Adiciona um cliente ao mercado.
     *
     * @param cliente Cliente a ser adicionado.
     */
    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    /**
     * Realiza a compra dos itens presentes no carrinho para o cliente informado.
     * <p>
     * O método executa as seguintes operações:
     * 1. Para cada item do carrinho, verifica se a quantidade desejada está disponível
     * no estoque do vendedor associado ao produto.
     * - A disponibilidade é determinada iterando sobre o estoque e somando as quantidades
     * dos itens que correspondem ao mesmo produto.
     * 2. Caso a quantidade disponível seja suficiente, o item é adicionado à lista de itens a serem comprados,
     * e o valor do item (preço base * quantidade) é somado ao total da compra.
     * 3. Se nenhum item estiver disponível, lança ExceptionNenhumItemDisponivel informando que não há itens disponíveis.
     * 4. Se houver itens elegíveis, tenta realizar a transferência do valor total da compra:
     * - O valor é debitado da conta do cliente e creditado na conta do mercado usando a forma de pagamento.
     * - Se a transação falhar, lança ExceptionFalhaNoPagamento.
     * 5. Após o pagamento, o método atualiza o estoque de cada vendedor:
     * - Itera o estoque para remover ou atualizar as quantidades dos itens comprados.
     * 6. Por fim, transfere o valor individual de cada item (preço base * quantidade) da conta do mercado
     * para a conta do vendedor correspondente.
     *
     * @param cliente        O cliente que realiza a compra, devendo possuir uma conta bancária válida.
     * @param carrinho       A coleção de produtos que contém os itens a serem adquiridos, onde cada item
     *                       especifica o produto e a quantidade desejada.
     * @param formaPagamento A forma de pagamento utilizada para efetivar as transferências entre as contas.
     * @throws Exception     Se nenhum item do carrinho estiver disponível no estoque.
     * @throws Exception     Se ocorrer uma falha na transferência do valor total da compra.
     */
    public void realizarCompra(Cliente cliente, ColecaoProdutos carrinho, FormaDePagamento formaPagamento)
            throws Exception {

        List<ItemProduto> itensComprados = new ArrayList<>();
        double totalCompra = 0.0;

        // Processa cada item do carrinho, verificando a disponibilidade no estoque do vendedor.
        for (ItemProduto item : carrinho.getItens()) {
            Produto produto = item.getProduto();
            int quantidadeNecessaria = item.getQuantidade();

            int quantidadeDisponivel = 0;
            for (ItemProduto estoqueItem : produto.getVendedor().getEstoque().getItens()) {
                if (estoqueItem.getProduto().equals(produto)) {
                    quantidadeDisponivel += estoqueItem.getQuantidade();
                }
            }
            if (quantidadeDisponivel >= quantidadeNecessaria) {
                itensComprados.add(item);
                totalCompra += produto.getPrecoBase() * quantidadeNecessaria;
            }
        }

        if (itensComprados.isEmpty()) {
            throw new Exception/*NenhumItemDisponivel*/("Nenhum item disponível para compra.");
        }

        // Realiza a transferência do valor total da compra, debitando do cliente e creditando na conta do mercado.
        if (!formaPagamento.pagar(cliente.getContaBancaria(), this.contaMercado, totalCompra)) {
            throw new Exception/*FalhaNoPagamento*/("Falha no pagamento do valor: " + totalCompra);
        }

        // Atualiza o estoque dos vendedores e transfere os valores individuais de cada item.
        for (ItemProduto item : itensComprados) {
            Produto produto = item.getProduto();
            int quantidadeParaDeduzir = item.getQuantidade();
            double valorItem = produto.getPrecoBase() * quantidadeParaDeduzir;

            List<ItemProduto> estoque = produto.getVendedor().getEstoque().getItens();
            for (int i = estoque.size() - 1; i >= 0 && quantidadeParaDeduzir > 0; i--) {
                if (estoque.get(i).getProduto().equals(produto)) {
                    int qntEmEstoque = estoque.get(i).getQuantidade();
                    if (qntEmEstoque > quantidadeParaDeduzir) {
                        estoque.get(i).setQuantidade(qntEmEstoque - quantidadeParaDeduzir);
                        quantidadeParaDeduzir = 0;
                    } else {
                        quantidadeParaDeduzir -= qntEmEstoque;
                        estoque.remove(i);
                    }
                }
            }
            formaPagamento.pagar(this.contaMercado, produto.getVendedor().getContaBancaria(), valorItem);
        }
    }

    /**
     * Retorna a conta bancária do mercado.
     *
     * @return conta bancária do mercado.
     */
    public ContaBancaria getContaMercado() {
        return contaMercado;
    }

    /**
     * Retorna a lista de clientes do mercado.
     * TODO: Retornar uma lista costuma não ser uma prática. Deveria ser evitado
     *
     * @return lista de clientes.
     */
    public List<Cliente> getClientes() {
        return Collections.unmodifiableList(clientes);
    }

    public Categoria getCategoriaRaiz() {
        return categoriaRaiz;
    }

    @Override
    public String toString() {
        String result = "Mercado:\n";
        result += "  Conta do Mercado: " + (contaMercado != null ? contaMercado.toString() : "null") + "\n";
        result += "  Clientes:\n";
        if (clientes != null && !clientes.isEmpty()) {
            for (Cliente cliente : clientes) {
                result += "    - " + cliente.toString() + "\n";
            }
        } else {
            result += "    [Nenhum cliente cadastrado]\n";
        }
        result += "  Categoria Raiz:\n";
        result += "    " + (categoriaRaiz != null ? categoriaRaiz.toString() : "null") + "\n";
        return result;
    }
}