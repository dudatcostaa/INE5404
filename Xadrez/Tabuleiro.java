import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

    private Peca[][] tabuleiro = new Peca[8][8];

    public void setPeca(Peca peca) {
        if (posicaoValida(peca.posicao)) {
            tabuleiro[peca.posicao.linha][peca.posicao.coluna] = peca;
        }
    }

    public Peca getPeca(Posicao posicao) {
        if (posicaoValida(posicao)) {
            return tabuleiro[posicao.linha][posicao.coluna];
        }
        return null;
    }

    public List<Peca> getPecasPorCor(boolean ehBranca) {
        List<Peca> pecas = new ArrayList<>();
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                Peca peca = tabuleiro[linha][coluna];
                if (peca != null && peca.ehBranca == ehBranca) {
                    pecas.add(peca);
                }
            }
        }
        return pecas;
    }

    public boolean posicaoValida(Posicao posicao) {
        return posicao.linha >= 0 && posicao.linha < 8 && posicao.coluna >= 0 && posicao.coluna < 8;
    }

    public boolean estaEmXeque(boolean ehBranco) {
        Peca rei = encontrarRei(ehBranco);
        for (Peca p: getPecasPorCor(!ehBranco)) {
            if (p.ameacadas(this).contains(rei)){
                return true;
            }
        }

        return false;
    }

    public List<Peca> getAmeacandoRei(boolean ehBranco) {
        List<Peca> pecasAmeacadoras = new ArrayList<>();
        Peca rei = encontrarRei(ehBranco);
        for (Peca p: getPecasPorCor(!ehBranco)) {
            if (p.ameacadas(this).contains(rei)){
                pecasAmeacadoras.add(p);
            }
        }
        return pecasAmeacadoras;
    }

    public boolean estaEmXequeMate(boolean ehBranco) {
        if (!estaEmXeque(ehBranco)) {
            return false;
        }

        List<Peca> minhasPecas = getPecasPorCor(ehBranco);

        for (Peca cadaPeca : minhasPecas) {

            List <Posicao> posicoesPossiveis = cadaPeca.movimentosPossiveis(this);

            for (Posicao posicaoPossivel : posicoesPossiveis) {
                Posicao inicial = cadaPeca.posicao; // pega a posição inicial da peça
                Peca capturada = getPeca(posicaoPossivel);

                // move as peças do lugar
                tabuleiro[inicial.linha][inicial.coluna] = null; // tira a peça da posicão inicial
                cadaPeca.posicao = posicaoPossivel;
                tabuleiro[posicaoPossivel.linha][posicaoPossivel.coluna] = cadaPeca; // coloca a peça na posição nova

                boolean emXeque = estaEmXeque(ehBranco);

                // devolve as peças para a posição original
                tabuleiro[posicaoPossivel.linha][posicaoPossivel.coluna] = capturada;
                cadaPeca.posicao = inicial;
                tabuleiro[inicial.linha][inicial.coluna] = cadaPeca;

                if (!emXeque) {
                    return false;
                }

            }
        }

        // DESENVOLVA ESTE METODO, POSSIVELMENTE UTILIZANDO O METODO estaEmXeque
        return true;
    }

    private Peca encontrarRei(boolean ehBranco) {
        for (Peca[] linha : tabuleiro) {
            for (Peca peca : linha) {
                if (peca instanceof Rei && peca.ehBranca == ehBranco) {
                    return peca;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                Peca peca = tabuleiro[linha][coluna];
                if (peca == null) {
                    sb.append((linha + coluna) % 2 == 0 ? "■  " : "□  ");
                } else {
                    sb.append(peca.toString()).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}