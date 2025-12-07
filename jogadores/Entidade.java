package jogadores;

import enums.Cor;

// a idéia é fazer uma Factory de entidades para criar casas especiais e jogadores

public abstract class Entidade {
    protected byte casa;
    protected Cor cor;
    protected byte tipo;

    // jogadores
    public Entidade(byte tipo, byte casa, Cor cor) {
        this.cor = cor;
        this.tipo = tipo;
        this.casa = casa;
    }

    // casas especiais
    public Entidade(byte casa) {
        this.casa = casa;
    }

    public byte getcasa() {return casa;}
    public void setcasa(byte casa) {this.casa = casa;}

    public byte getTipo() {return tipo;}
    public void setTipo(byte tipo) {this.tipo = tipo;}

    public Cor getCor() {return cor;}
    public void setCor() {this.cor = cor;} // acho que não precisa mas ok


    
}