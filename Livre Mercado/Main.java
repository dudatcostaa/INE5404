import java.util.List;
import java.util.Scanner;


public class Main {

     public static void main(String[] args) {
         Mercado mercado = new Mercado(new ContaBancaria("123456", 0.0));
         Preenchedor preenchedor = new Preenchedor();
         preenchedor.inicializaMercado(mercado);
         //
         System.out.println(mercado.toString());
    }
}
