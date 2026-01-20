abstract class Comando {
    abstract void executar();
    abstract EquipamentoDecorator getEquipamento();
}

// Comandos de Liga/Desliga
class ComandoLigar extends Comando {
    private DecoradorLigaDesliga decorador;

    ComandoLigar(DecoradorLigaDesliga decorador) {
        this.decorador = decorador;
    }

    @Override
    public void executar() {
        decorador.ligar();
    }

    @Override
    public EquipamentoDecorator getEquipamento() {
        return decorador;
    }

    @Override
    public String toString() {
        return "Ligar " + decorador.toString();
    }
}

class ComandoDesligar extends Comando {
    private DecoradorLigaDesliga decorador;

    ComandoDesligar(DecoradorLigaDesliga decorador) {
        this.decorador = decorador;
    }

    @Override
    public void executar() {
        decorador.desligar();
    }

    @Override
    public EquipamentoDecorator getEquipamento() {
        return decorador;
    }

    @Override
    public String toString() {
        return "Desligar " + decorador.toString();
    }
}

// Comandos de Brilho
class ComandoAumentarBrilho extends Comando {
    private DecoradorBrilho decoradorBrilho;

    ComandoAumentarBrilho(DecoradorBrilho decoradorBrilho) {
        this.decoradorBrilho = decoradorBrilho;
    }

    @Override
    public void executar() {
        decoradorBrilho.aumentarBrilho();
    }

    @Override
    public EquipamentoDecorator getEquipamento() {
        return decoradorBrilho;
    }

    @Override
    public String toString() {
        return "AumentarBrilho em " + decoradorBrilho.toString();
    }
}

class ComandoDiminuirBrilho extends Comando {
    private DecoradorBrilho decoradorBrilho;

    ComandoDiminuirBrilho(DecoradorBrilho decoradorBrilho) {
        this.decoradorBrilho = decoradorBrilho;
    }

    @Override
    public void executar() {
        decoradorBrilho.diminuirBrilho();
    }

    @Override
    public EquipamentoDecorator getEquipamento() {
        return decoradorBrilho;
    }

    @Override
    public String toString() {
        return "DiminuirBrilho em " + decoradorBrilho.toString();
    }
}

class ComandoAjustarBrilho extends Comando {
    private DecoradorBrilho decoradorBrilho;
    private final int valor;

    ComandoAjustarBrilho(DecoradorBrilho decoradorBrilho, int valor) {
        this.decoradorBrilho = decoradorBrilho;
        this.valor = valor;
    }

    @Override
    public void executar() {
        decoradorBrilho.ajustarBrilho(valor);
    }

    @Override
    public EquipamentoDecorator getEquipamento() {
        return decoradorBrilho;
    }

    @Override
    public String toString() {
        return "AjustarBrilho em " + decoradorBrilho.toString() + " para " + valor;
    }
}

// Comandos de Volume
class ComandoAumentarVolume extends Comando {
    private DecoradorVolume decoradorVolume;

    ComandoAumentarVolume(DecoradorVolume decoradorVolume) {
        this.decoradorVolume = decoradorVolume;
    }

    @Override
    public void executar() {
        decoradorVolume.aumentarVolume();
    }

    @Override
    public EquipamentoDecorator getEquipamento() {
        return decoradorVolume;
    }

    @Override
    public String toString() {
        return "AumentarVolume em " + decoradorVolume.toString();
    }
}

class ComandoDiminuirVolume extends Comando {
    private DecoradorVolume decoradorVolume;

    ComandoDiminuirVolume(DecoradorVolume decoradorVolume) {
        this.decoradorVolume = decoradorVolume;
    }

    @Override
    public void executar() {
        decoradorVolume.diminuirVolume();
    }

    @Override
    public EquipamentoDecorator getEquipamento() {
        return decoradorVolume;
    }

    @Override
    public String toString() {
        return "DiminuirVolume em " + decoradorVolume.toString();
    }
}

class ComandoAjustarVolume extends Comando {
    private DecoradorVolume decoradorVolume;
    private final int valor;

    ComandoAjustarVolume(DecoradorVolume decoradorVolume, int valor) {
        this.decoradorVolume = decoradorVolume;
        this.valor = valor;
    }

    @Override
    public void executar() {
        decoradorVolume.ajustarVolume(valor);
    }

    @Override
    public EquipamentoDecorator getEquipamento() {
        return decoradorVolume;
    }

    @Override
    public String toString() {
        return "AjustarVolume em " + decoradorVolume.toString() + " para " + valor;
    }
}