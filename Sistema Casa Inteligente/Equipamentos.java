class Equipamento {
    private final String nome;

    Equipamento(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome=" + nome;
    }
}

class Lampada extends Equipamento {
    Lampada(String nome) {
        super(nome);
    }
}

class CaixaDeSom extends Equipamento {
    CaixaDeSom(String nome) {
        super(nome);
    }
}

class Televisao extends Equipamento {
    Televisao(String nome) {
        super(nome);
    }
}