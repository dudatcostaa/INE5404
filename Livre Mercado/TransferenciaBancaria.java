/**
 * Implementação da forma de pagamento utilizando transferência bancária.
 */
public class TransferenciaBancaria implements FormaDePagamento {

    /**
     * Efetua o pagamento via transferência bancária.
     * Transfere o valor da conta origem para a conta destino
     *
     * @param origem Conta de onde o valor será debitado.
     * @param destino Conta que receberá o valor.
     * @param valor Valor a ser transferido.
     * @return true se a transferência ocorrer com sucesso, false caso contrário.
     */
    @Override
    public boolean pagar(ContaBancaria origem, ContaBancaria destino, double valor) {
        return origem.transferir(valor, destino);
    }
}