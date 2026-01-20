/**
 UFSC/CTC/INE/INE5404
 Description: Classe Produto com persistência em arquivo texto
 */
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String modelo;
	private String marca;
	private double preco;
	private String nomeCategoria;
	private transient Categoria categoria;

	public Produto(String nome, String modelo, String marca, double preco, String nomeCategoria) {
		this.nome = nome;
		this.modelo = modelo;
		this.marca = marca;
		this.preco = preco;
		this.nomeCategoria = nomeCategoria;
		this.categoria = null;
	}

	public Produto(String nome, String modelo, String marca, double preco, Categoria categoria) {
		this.nome = nome;
		this.modelo = modelo;
		this.marca = marca;
		this.preco = preco;
		this.nomeCategoria = categoria.getNome();
		this.categoria = categoria;
	}

	/**
	 * Converte o produto para string CSV para salvar em arquivo
	 * Formato: PRODUTO;nome;modelo;marca;preco;nomeCategoria
	 */
	public String salvarProduto() {
		return String.join(";",
				"PRODUTO",
				nome,
				modelo,
				marca,
				String.valueOf(preco),
				nomeCategoria
		);
	}

	/**
	 * Cria um produto a partir de uma linha CSV
	 * Formato esperado: PRODUTO;nome;modelo;marca;preco;nomeCategoria
	 */
	public static Produto carregarProduto(String linha) {
		String[] campos = linha.split(";");

		if (campos.length != 6) {
			throw new IllegalArgumentException("Formato inválido. Esperado 6 campos, encontrado: " + campos.length);
		}

		if (!campos[0].equals("PRODUTO")) {
			throw new IllegalArgumentException("Linha não começa com 'PRODUTO'");
		}

		String nome = campos[1];
		String modelo = campos[2];
		String marca = campos[3];
		double preco = Double.parseDouble(campos[4]);
		String nomeCategoria = campos[5];

		return new Produto(nome, modelo, marca, preco, nomeCategoria);
	}

	/**
	 * Carrega lista de produtos de um arquivo texto
	 */
	public static List<Produto> carregarProdutos(String filePath) throws IOException {
		List<Produto> produtos = new ArrayList<>();

		Path path = Paths.get(filePath);

		if (!Files.exists(path)) {
			throw new IOException("Arquivo não encontrado: " + filePath);
		}

		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				if (!linha.trim().isEmpty()) {
					produtos.add(carregarProduto(linha));
				}
			}
		}

		return produtos;
	}

	/**
	 * Salva lista de produtos em um arquivo texto
	 */
	public static void salvarProdutos(List<Produto> produtos, String filePath) throws IOException {
		Path path = Paths.get(filePath);

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			for (Produto produto : produtos) {
				writer.write(produto.salvarProduto());
				writer.newLine();
			}
		}
	}

	// Getters
	public String getNome() {
		return nome;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public double getPreco() {
		return preco;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Produto)) {
			return false;
		}
		Produto produto = (Produto) o;
		return Double.compare(produto.preco, preco) == 0
				&& Objects.equals(nome, produto.nome)
				&& Objects.equals(modelo, produto.modelo)
				&& Objects.equals(marca, produto.marca)
				&& Objects.equals(nomeCategoria, produto.nomeCategoria);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, modelo, marca, preco, nomeCategoria);
	}

	@Override
	public String toString() {
		return "Produto{"
				+ "nome='" + nome + '\''
				+ ", modelo='" + modelo + '\''
				+ ", marca='" + marca + '\''
				+ ", preco=" + preco
				+ ", categoria='" + nomeCategoria + '\''
				+ '}';
	}
}