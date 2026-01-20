/**
 * Representa uma conta bancária com operações básicas de depósito, saque e transferência.
 */
public class ContaBancaria {

    private String numero;
    private double saldo;

    /**
     * Construtor da classe ContaBancaria.
     *
     * @param numero Número da conta.
     * @param saldo Saldo inicial da conta.
     */
    public ContaBancaria(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    /**
     * Retorna o número da conta.
     *
     * @return número da conta.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Retorna o saldo atual da conta.
     *
     * @return saldo da conta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Efetua um depósito na conta.
     *
     * @param valor Quantia a ser depositada.
     */
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    /**
     * Efetua um saque da conta, se houver fundos suficientes.
     *
     * @param valor Quantia a ser sacada.
     * @return true se o saque for bem-sucedido, false caso contrário.
     */
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    /**
     * Transfere um valor desta conta para a conta informada, se houver fundos suficientes.
     *
     * @param valor Quantia a ser transferida.
     * @param destino Conta bancária de destino.
     * @return true se a transferência for bem-sucedida, false caso contrário.
     */
    public boolean transferir(double valor, ContaBancaria destino) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    /**
     * Retorna uma representação em String dos dados da conta.
     *
     * @return String contendo o número e o saldo da conta.
     */
    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero='" + numero + '\'' +
                ", saldo=" + saldo +
                '}';
    }

}
