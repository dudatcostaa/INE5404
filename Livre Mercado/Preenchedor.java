import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Preenchedor {

    /**
     * Inicializa o objeto Mercado preenchendo-o com clientes, contas bancárias, formas de pagamento,
     * estoques, categorias e produtos.
     * <p>
     * - São criados 20 clientes, sendo os 10 primeiros também definidos como vendedores (com estoque).
     * - Uma forma de pagamento é definida e adicionada ao mercado.
     * - São criadas categorias com subcategorias formando uma hierarquia, e para cada categoria folha são
     * cadastrados 5 produtos, os quais são adicionados ao estoque de vendedores escolhidos aleatoriamente.
     * </p>
     *
     * @param mercado o objeto Mercado a ser inicializado.
     */
    public void inicializaMercado(Mercado mercado) {
        Random random = new Random();

        // 1. Criação dos clientes com suas contas bancárias.
        List<Cliente> listaClientes = new ArrayList<>();
        List<Cliente> vendedores = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            double saldoInicial = 100 + random.nextDouble() * (5000 - 100);
            ContaBancaria conta = new ContaBancaria("Conta_" + i, saldoInicial);
            Cliente cliente = new Cliente("Cliente_" + i, "", conta);
            listaClientes.add(cliente);
            // Define os 10 primeiros clientes como vendedores, ou seja, com estoque
            if (i <= 5) {
                vendedores.add(cliente);
            }
        }
        for (Cliente cliente : listaClientes) {
            mercado.adicionarCliente(cliente);
        }
        for (Cliente cliente : vendedores) {
            mercado.adicionarCliente(cliente);
        }

        // 2. Criação da hierarquia de categorias.
        Categoria categoriaRaiz = mercado.getCategoriaRaiz();

        // Exemplo de categoria: Eletrônicos
        Categoria eletronicos = new Categoria("Eletrônicos", "Produtos eletrônicos em geral");
        Categoria celulares = new Categoria("Telefones Celulares", "Smartphones e celulares convencionais");
        Categoria computadores = new Categoria("Computadores", "Laptops, desktops e acessórios");
        eletronicos.adicionarSubcategoria(celulares);
        eletronicos.adicionarSubcategoria(computadores);
        categoriaRaiz.adicionarSubcategoria(eletronicos);

        // Exemplo de categoria: Vestuário
        Categoria vestuario = new Categoria("Vestuário", "Roupas, calçados e acessórios");
        Categoria masculino = new Categoria("Masculino", "Roupas e acessórios para homens");
        Categoria feminino = new Categoria("Feminino", "Roupas e acessórios para mulheres");
        vestuario.adicionarSubcategoria(masculino);
        vestuario.adicionarSubcategoria(feminino);
        categoriaRaiz.adicionarSubcategoria(vestuario);

        // Exemplo de categoria: Casa e Jardim
        Categoria casaJardim = new Categoria("Casa e Jardim", "Produtos para o lar, decoração e jardim");
        Categoria moveis = new Categoria("Móveis", "Móveis residenciais e comerciais");
        Categoria decoracao = new Categoria("Decoração", "Itens decorativos para ambientes");
        casaJardim.adicionarSubcategoria(moveis);
        casaJardim.adicionarSubcategoria(decoracao);
        categoriaRaiz.adicionarSubcategoria(casaJardim);

        // 4. Cadastro de produtos para cada categoria.
        // Para cada categoria, cadastrar 5 produtos; os produtos serão adicionados aos estoques de vendedores aleatórios.
        cadastraProdutosNaCategoriaESubcategorias(categoriaRaiz, vendedores, 1);
    }

    private int cadastraProdutosNaCategoriaESubcategorias(Categoria categoria, List<Cliente> vendedores, int produtoContador) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            double precoProduto = 50 + random.nextDouble() * 950; // preço entre 50 e 1000
            int quantidadeProduto = 1 + random.nextInt(49); // quantidade em estoque entre 1 e 50
            // Seleciona um vendedor aleatório para associar o produto ao seu estoque
            int idx = random.nextInt(vendedores.size());
            Cliente vendedor = vendedores.get(idx);
            // cria o produto e o adiciona ao estoque do vendedor
            Produto produto = new Produto("Produto_" + produtoContador, "Descrição do Produto_" + produtoContador, precoProduto, vendedor,  categoria);
            categoria.adicionarProduto(produto);
            vendedor.getEstoque().adicionarItem (new ItemProduto(produto, quantidadeProduto));
            produtoContador++;
        }
        for (Categoria cat : categoria.getSubcategorias()) {
            produtoContador =  cadastraProdutosNaCategoriaESubcategorias(cat, vendedores, produtoContador);
        }
        return produtoContador;
    }
}
