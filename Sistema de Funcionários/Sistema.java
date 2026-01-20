/* ATENÇÃO: ESCREVA ABAIXO O NOME DO ALUNO QUE REALIZA ESTA AVALIAÇÃO 
     E QUE NÃO É O ALUNO QUE SE LOGOU NO QUIOSQUE DE PROVAS:

    Nome do aluno 2:
     
*/ 

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata que representa um funcionário genérico.
 * Todos os tipos de funcionários devem herdar dessa classe.
 */
abstract class Funcionario {
    private String nome;

    /**
     * Constrói um novo funcionário com o nome especificado.
     *
     * @param nome O nome do funcionário.
     */
    public Funcionario(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome do funcionário.
     *
     * @return O nome do funcionário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Calcula o pagamento do funcionário.
     * Esse método é abstrato e deve ser implementado pelas subclasses, pois o cálculo varia de acordo com o tipo de funcionário.
     *
     * @return O valor do pagamento do funcionário.
     */
    public abstract double calcularPagamento();

    /**
     * Calcula o bônus adicional do funcionário.
     * Cada subclass deve implementar sua própria lógica para calcular o bônus.
     *
     * @return O valor do bônus calculado.
     */
    public abstract double calcularBonus();

    @Override
    public String toString() {
        return String.format("Funcionário: %s", nome);
    }
}

/**
 * Representa um funcionário assalariado que recebe um salário semanal fixo.
 */
class FuncionarioAssalariado extends Funcionario {
    /* INCLUA ATRIBUTOS, SE ACHAR NECESSÁRIO */

    /**
     * Constrói um funcionário assalariado com o nome e salário semanal especificados.
     *
     * @param nome O nome do funcionário.
     * @param salarioSemanal O salário semanal fixo do funcionário.
     */
    public FuncionarioAssalariado(String nome, double salarioSemanal) {
        /* DESENVOLVA ESTE MÉTODO */
    }

    /**
     * Calcula o pagamento do funcionário com base no salário semanal.
     *
     * @return O valor do salário semanal.
     */
    @Override
    public double calcularPagamento() {
        /* DESENVOLVA ESTE MÉTODO */
    }

    /**
     * Calcula o bônus adicional do funcionário, que é 10% do salário semanal.
     *
     * @return O valor do bônus.
     */
    @Override
    public double calcularBonus() {
        /* DESENVOLVA ESTE MÉTODO */
    }

    @Override
    public String toString() {
        return super.toString() + 
        String.format(", Salário Semanal: R$ %.2f", 0.0 /* MUDE PARA MOSTRAR O SALÁRIO CORRETO */);
    }
}

/**
 * Representa um funcionário que é pago por horas trabalhadas e ganha extra por horas extras.
 */
class FuncionarioPorHora extends Funcionario {
    /* INCLUA ATRIBUTOS, SE ACHAR NECESSÁRIO */

    /**
     * Constrói um funcionário por hora com o nome, valor por hora e horas trabalhadas.
     *
     * @param nome O nome do funcionário.
     * @param valorHora O valor pago por hora trabalhada.
     * @param horasTrabalhadas O número total de horas trabalhadas na semana.
     */
    public FuncionarioPorHora(String nome, double valorHora, int horasTrabalhadas) {
        /* DESENVOLVA ESTE MÉTODO */
    }

    /**
     * Calcula o pagamento do funcionário com base nos valores das horas normais e horas extras.
     * Horas extras são calculadas como 1,5 vezes o valor da hora normal.
     *
     * @return O valor do pagamento semanal.
     */
    @Override
    public double calcularPagamento() {
        /* DESENVOLVA ESTE MÉTODO */
    }

    /**
     * Calcula o bônus adicional baseado nas horas extras (R$ 10,00 por hora extra).
     *
     * @return O valor do bônus.
     */
    @Override
    public double calcularBonus() {
        /* DESENVOLVA ESTE MÉTODO */
    }

    @Override
    public String toString() {
        return super.toString() + 
        String.format(", Horas Trabalhadas: %d, Valor Hora: R$ %.2f", 0.0, 0.0 /* MUDE PARA MOSTRAR O SALÁRIO CORRETO */);
    }
}

/**
 * Representa um funcionário que recebe com base em vendas realizadas, utilizando um percentual de comissão.
 */
class FuncionarioComissionado extends Funcionario {
    /* INCLUA ATRIBUTOS, SE ACHAR NECESSÁRIO */

    /**
     * Constrói um funcionário comissionado com o nome, vendas semanais e percentual de comissão.
     *
     * @param nome O nome do funcionário.
     * @param vendasSemanais O valor total das vendas realizadas na semana.
     * @param percentualComissao O percentual de comissão sobre as vendas.
     */
    public FuncionarioComissionado(String nome, double vendasSemanais, double percentualComissao) {
        /* DESENVOLVA ESTE MÉTODO */
    }

    /**
     * Calcula o pagamento do funcionário com base no percentual de comissão sobre as vendas semanais.
     *
     * @return O valor da comissão.
     */
    @Override
    public double calcularPagamento() {
        /* DESENVOLVA ESTE MÉTODO */
    }

    /**
     * Calcula o bônus adicional baseado em 5% extra sobre as vendas semanais realizadas.
     *
     * @return O valor do bônus.
     */
    @Override
    public double calcularBonus() {
        /* DESENVOLVA ESTE MÉTODO */
    }

    @Override
    public String toString() {
        return super.toString() + 
        String.format(", Vendas Semanais: R$ %.2f, Comissão: %.2f%%", 0.0, 0.0 /* MUDE PARA MOSTRAR O SALÁRIO CORRETO */);
    }
}

/**
 * Representa um funcionário que recebe um salário fixo e uma comissão por vendas.
 */
class FuncionarioAssalariadoComissionado extends Funcionario {
    /* INCLUA ATRIBUTOS, SE ACHAR NECESSÁRIO */

    /**
     * Constrói um funcionário assalariado com comissão.
     *
     * @param nome O nome do funcionário.
     * @param salarioBase O salário base fixo do funcionário.
     * @param vendasSemanais O valor total das vendas realizadas na semana.
     * @param percentualComissao O percentual de comissão sobre as vendas.
     */
    public FuncionarioAssalariadoComissionado(String nome, double salarioBase, double vendasSemanais, double percentualComissao) {
        /* DESENVOLVA ESTE MÉTODO */
    }

    /**
     * Calcula o pagamento do funcionário somando o salário base com a comissão por vendas semanais.
     *
     * @return O valor do pagamento.
     */
    @Override
    public double calcularPagamento() {
        /* DESENVOLVA ESTE MÉTODO */
    }

    /**
     * Calcula o bônus adicional como um valor fixo de R$ 200,00 mais 5% das vendas semanais.
     *
     * @return O valor do bônus.
     */
    @Override
    public double calcularBonus() {
        /* DESENVOLVA ESTE MÉTODO */
    }

    @Override
    public String toString() {
        return super.toString() + 
        String.format(", Salário Base: R$ %.2f, Vendas Semanais: R$ %.2f, Comissão: %.2f%%",
                0.0, 0.0, 0.0 /* MUDE PARA MOSTRAR O SALÁRIO CORRETO */);
    }
}

/**
 * Representa uma empresa que gerencia uma lista de funcionários e suas folhas de pagamento.
 */
class Empresa {
    private List<Funcionario> funcionarios;

    /**
     * Constrói uma nova empresa com uma lista de funcionários vazia.
     */
    public Empresa() {
        this.funcionarios = new ArrayList<>();
    }

    /**
     * Adiciona um novo funcionário à lista de empregados da empresa.
     *
     * @param funcionario O funcionário a ser adicionado.
     */
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    /**
     * Calcula e exibe a folha de pagamento de todos os funcionários, incluindo o pagamento e o bônus.
     */
    public void calcularFolhaDePagamento() {
        System.out.println("===== Folha de Pagamento =====");
        for (Funcionario funcionario : funcionarios) {
            System.out.printf("%s: Salário: R$ %.2f, Bônus: R$ %.2f%n",
                    funcionario.getNome(), funcionario.calcularPagamento(), funcionario.calcularBonus());
        }
    }

    /**
     * Lista todos os funcionários cadastrados na empresa, exibindo seus detalhes.
     */
    public void listarFuncionarios() {
        System.out.println("===== Lista de Funcionários =====");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }
}
