import java.util.ArrayList;
import java.util.List;

/**
 * Representa um funcionário assalariado que recebe um salário semanal fixo.
 */
class FuncionarioAssalariado extends Funcionario {
    private double salarioSemanal;

    public FuncionarioAssalariado(String nome, double salarioSemanal) {
        super(nome);
        this.salarioSemanal = salarioSemanal;
    }

    @Override
    public double calcularPagamento() {
        return salarioSemanal;
    }

    @Override
    public double calcularBonus() {
        return salarioSemanal * 0.10;
    }

    @Override
    public String toString() {
        return super.toString() + 
        String.format(", Salário Semanal: R$ %.2f", salarioSemanal);
    }
}

/**
 * Representa um funcionário que é pago por horas trabalhadas e ganha extra por horas extras.
 */
class FuncionarioPorHora extends Funcionario {
    private double valorHora;
    private int horasTrabalhadas;

    public FuncionarioPorHora(String nome, double valorHora, int horasTrabalhadas) {
        super(nome);
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularPagamento() {
        if (horasTrabalhadas <= 40) {
            return horasTrabalhadas * valorHora;
        } else {
            int horasNormais = 40;
            int horasExtras = horasTrabalhadas - 40;
            return (horasNormais * valorHora) + (horasExtras * valorHora * 1.5);
        }
    }

    @Override
    public double calcularBonus() {
        int horasExtras = Math.max(0, horasTrabalhadas - 40);
        return horasExtras * 10.0;
    }

    @Override
    public String toString() {
        return super.toString() + 
        String.format(", Horas Trabalhadas: %d, Valor Hora: R$ %.2f", horasTrabalhadas, valorHora);
    }
}

/**
 * Representa um funcionário que recebe com base em vendas realizadas, utilizando um percentual de comissão.
 */
class FuncionarioComissionado extends Funcionario {
    private double vendasSemanais;
    private double percentualComissao;

    public FuncionarioComissionado(String nome, double vendasSemanais, double percentualComissao) {
        super(nome);
        this.vendasSemanais = vendasSemanais;
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calcularPagamento() {
        return vendasSemanais * (percentualComissao / 100.0);
    }

    @Override
    public double calcularBonus() {
        return vendasSemanais * 0.05;
    }

    @Override
    public String toString() {
        return super.toString() + 
        String.format(", Vendas Semanais: R$ %.2f, Comissão: %.2f%%", vendasSemanais, percentualComissao);
    }
}

/**
 * Representa um funcionário que recebe um salário fixo e uma comissão por vendas.
 */
class FuncionarioAssalariadoComissionado extends Funcionario {
    private double salarioBase;
    private double vendasSemanais;
    private double percentualComissao;

    public FuncionarioAssalariadoComissionado(String nome, double salarioBase, double vendasSemanais, double percentualComissao) {
        super(nome);
        this.salarioBase = salarioBase;
        this.vendasSemanais = vendasSemanais;
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calcularPagamento() {
        double comissao = vendasSemanais * (percentualComissao / 100.0);
        return salarioBase + comissao;
    }

    @Override
    public double calcularBonus() {
        return 200.0 + (vendasSemanais * 0.05);
    }

    @Override
    public String toString() {
        return super.toString() + 
        String.format(", Salário Base: R$ %.2f, Vendas Semanais: R$ %.2f, Comissão: %.2f%%",
                salarioBase, vendasSemanais, percentualComissao);
    }
}
