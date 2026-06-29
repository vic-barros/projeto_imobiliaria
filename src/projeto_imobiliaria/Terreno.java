package projeto_imobiliaria;

public class Terreno extends Imovel{
    private TipoTerreno tipo;

    public Terreno(int cod, Endereco endereco, double area, StatusImovel status, double valor, TipoTerreno tipo) {
        super(endereco, valor, area,status);
        this.tipo = tipo;
    }


    @Override
    public double calcularValorFinal (){
        return getValor()*1.08;
    }

    public TipoTerreno getTipo() {
        return tipo;
    }

    public void setTipo(TipoTerreno tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString (){
        return super.toString() + "| Tipo: Terreno "+ tipo;
    }
}
