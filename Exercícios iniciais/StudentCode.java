import java.util.ArrayList;

public class StudentCode {

    /*
    1. Cálculo de PI usando a série de Gregory-Leibniz.
    Critérios: do-while, limite de termos ou precisão do último termo.
    */
    public double calculePi(double precisao, int maxTermos) {
        double pi = 0.0;
        double divisor = 1.0;
        int contador = 0;
        double valorTermo;
        boolean subtrair = false;

        do {
            valorTermo = 4.0 / divisor;

            if (subtrair) {
                pi -= valorTermo;
            } else {
                pi += valorTermo;
            }

            subtrair = !subtrair; // Alterna o sinal para o próximo termo
            divisor += 2;         // Denominadores: 1, 3, 5, 7...
            contador++;

            // Para se atingir maxTermos OU se o valor do termo atual for menor que a precisão
        } while (contador < maxTermos && valorTermo >= precisao);

        return pi;
    }

    /*
    2. Triplos de Pitágoras.
    Critérios: 3 loops "for", evitar duplicatas (ex: 3,4,5 e 4,3,5), dentro do range.
    */
    public int calculeNumTriangulosPitagoras(int valorMinimo, int valorMaximo) {
        int contadorTriangulos = 0;

        // Loop para o cateto 1
        for (int a = valorMinimo; a <= valorMaximo; a++) {
            // b começa em 'a' para evitar contar (3,4,5) e (4,3,5) separadamente
            for (int b = a; b <= valorMaximo; b++) {
                // Loop para a hipotenusa
                for (int c = valorMinimo; c <= valorMaximo; c++) {
                    if ((a * a) + (b * b) == (c * c)) {
                        contadorTriangulos++;
                    }
                }
            }
        }
        return contadorTriangulos;
    }

    /*
    3. Média Aritmética Simples.
    */
    public double calculeMediaAritmetica(int[] notas) {
        if (notas == null || notas.length == 0) return 0.0;

        double soma = 0;
        for (int nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    /*
    4. Movimentos do Cavaleiro no Xadrez.
    O cavaleiro move-se em L (2 em um eixo, 1 no outro).
    */
    public ArrayList<IntegerPair> calculaMovimentoCavaleiro(IntegerPair posicao) {
        ArrayList<IntegerPair> movimentosPossiveis = new ArrayList<>();

        // As 8 combinações de movimento em "L" do cavaleiro
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        for (int i = 0; i < 8; i++) {
            // Acesso direto aos atributos x e y, sem getX() ou getY()
            int novoX = posicao.x + dx[i];
            int novoY = posicao.y + dy[i];

            // Verifica se a nova posição ainda está dentro dos limites do tabuleiro (0 a 7)
            if (novoX >= 0 && novoX <= 7 && novoY >= 0 && novoY <= 7) {
                movimentosPossiveis.add(new IntegerPair(novoX, novoY));
            }
        }

        return movimentosPossiveis;
    }
}