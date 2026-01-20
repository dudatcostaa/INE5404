
/**
 *
 * @author Professor Cancian
 *
 * Esta classe representa um par ordenado de valores, como uma coordenada (x,y)
 */
// ESTA CLASSE NAO DEVE SER MODIFICADA DE QUALQUER FORMA
class IntegerPair {

    public final int x;
    public final int y;

    IntegerPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
