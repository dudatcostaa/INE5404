/**
 UFSC/CTC/INE/INE5404
 Description: Classe Categoria com persistência em arquivo texto e binário
 */
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private List<Categoria> subcategorias;
	private List<Produto> produtos;

	public Categoria(String nome) {
		this.nome = nome;
		this.subcategorias = new ArrayList<>();
		this.produtos = new ArrayList<>();
	}

	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}

	public void adicionarSubcategoria(Categoria subcategoria) {
		subcategorias.add(subcategoria);
	}

	public String getNome() {
		return nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

	/**
	 * Salva a hierarquia de categorias em arquivo texto
	 * Formato: CATEGORIA;nivel;nome
	 *          PRODUTO;dados...
	 */
	public static void salvarCategoria(Categoria categoria, String fileName) throws IOException {
		Path path = Paths.get(fileName);

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			salvarCategoriaRecursivo(categoria, writer, 0);
		}
	}

	/**
	 * Método recursivo para salvar categoria e suas subcategorias
	 */
	private static void salvarCategoriaRecursivo(Categoria categoria, BufferedWriter writer, int nivel) throws IOException {
		// Escreve a linha da categoria
		writer.write("CATEGORIA;" + nivel + ";" + categoria.nome);
		writer.newLine();

		// Escreve os produtos da categoria
		for (Produto produto : categoria.produtos) {
			writer.write(produto.salvarProduto());
			writer.newLine();
		}

		// Recursivamente salva as subcategorias
		for (Categoria subcategoria : categoria.subcategorias) {
			salvarCategoriaRecursivo(subcategoria, writer, nivel + 1);
		}
	}

	/**
	 * Carrega hierarquia de categorias de arquivo texto
	 */
	public static Categoria carregarCategoria(String fileName) throws IOException {
		Path path = Paths.get(fileName);

		if (!Files.exists(path)) {
			throw new IOException("Arquivo não encontrado: " + fileName);
		}

		Categoria raiz = null;
		Stack<Categoria> pilha = new Stack<>();
		int nivelAnterior = -1;

		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String linha;
			Categoria categoriaAtual = null;

			while ((linha = reader.readLine()) != null) {
				if (linha.trim().isEmpty()) {
					continue;
				}

				String[] partes = linha.split(";");

				if (partes[0].equals("CATEGORIA")) {
					int nivel = Integer.parseInt(partes[1]);
					String nomeCategoria = partes[2];

					Categoria novaCategoria = new Categoria(nomeCategoria);

					if (nivel == 0) {
						raiz = novaCategoria;
						pilha.clear();
						pilha.push(raiz);
					} else {
						// Ajusta a pilha para o nível correto
						while (pilha.size() > nivel) {
							pilha.pop();
						}

						// Adiciona como subcategoria do pai
						Categoria pai = pilha.peek();
						pai.adicionarSubcategoria(novaCategoria);
						pilha.push(novaCategoria);
					}

					categoriaAtual = novaCategoria;
					nivelAnterior = nivel;

				} else if (partes[0].equals("PRODUTO")) {
					if (categoriaAtual != null) {
						Produto produto = Produto.carregarProduto(linha);
						categoriaAtual.adicionarProduto(produto);
					}
				}
			}
		}

		return raiz;
	}

	/**
	 * Salva categoria usando serialização binária
	 */
	public static void salvarObjetoCategoria(Categoria categoria, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(categoria);
		}
	}

	/**
	 * Carrega categoria usando desserialização binária
	 */
	public static Categoria carregarObjetoCategoria(String fileName) throws IOException, ClassNotFoundException {
		try (FileInputStream fis = new FileInputStream(fileName);
			 ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (Categoria) ois.readObject();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Categoria)) {
			return false;
		}
		Categoria categoria = (Categoria) o;
		return Objects.equals(nome, categoria.nome)
				&& Objects.equals(subcategorias, categoria.subcategorias)
				&& Objects.equals(produtos, categoria.produtos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, subcategorias, produtos);
	}

	@Override
	public String toString() {
		return "Categoria{"
				+ "nome='" + nome + '\''
				+ ", subcategorias=" + subcategorias
				+ ", produtos=" + produtos
				+ '}';
	}
}