/**
 * Interface que define o contrato para formas de pagamento.
 */
public interface FormaDePagamento {

    /**
     * Método para efetivar um pagamento entre duas contas bancárias.
     *
     * @param origem Conta de onde o valor será debitado.
     * @param destino Conta que receberá o valor.
     * @param valor Valor a ser transferido.
     * @return true se o pagamento for efetuado com sucesso, false caso contrário.
     */
    boolean pagar(ContaBancaria origem, ContaBancaria destino, double valor);
}