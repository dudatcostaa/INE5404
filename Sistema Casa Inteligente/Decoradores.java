class EquipamentoDecorator {
    protected Equipamento equipamento;

    EquipamentoDecorator(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}

class DecoradorLigaDesliga extends EquipamentoDecorator {
    private boolean ligado;

    DecoradorLigaDesliga(Equipamento equipamento) {
        super(equipamento);
        this.ligado = false;
    }

    public boolean isLigado() {
        return ligado;
    }

    void ligar() {
        ligado = true;
    }

    void desligar() {
        ligado = false;
    }

    @Override
    public String toString() {
        return equipamento.toString() + ",Ligado=" + ligado;
    }
}

class DecoradorBrilho extends EquipamentoDecorator {
    private int brilho;

    DecoradorBrilho(Equipamento equipamento) {
        super(equipamento);
        this.brilho = 50;
    }

    public int getBrilho() {
        return brilho;
    }

    void ajustarBrilho(int valor) {
        if (valor >= 0 && valor <= 100) brilho = valor;
    }

    void aumentarBrilho() {
        if (brilho < 100) brilho += 10;
    }

    void diminuirBrilho() {
        if (brilho > 0) brilho -= 10;
    }

    @Override
    public String toString() {
        return equipamento.toString() + ",Brilho=" + brilho;
    }
}

class DecoradorVolume extends EquipamentoDecorator {
    private int volume;

    DecoradorVolume(Equipamento equipamento) {
        super(equipamento);
        this.volume = 50;
    }

    public int getVolume() {
        return volume;
    }

    void ajustarVolume(int valor) {
        if (valor >= 0 && valor <= 100) volume = valor;
    }

    void aumentarVolume() {
        if (volume < 100) volume += 10;
    }

    void diminuirVolume() {
        if (volume > 0) volume -= 10;
    }

    @Override
    public String toString() {
        return equipamento.toString() + ",Volume=" + volume;
    }
}