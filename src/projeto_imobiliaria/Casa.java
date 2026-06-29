package projeto_imobiliaria;

public class Casa extends Imovel {
    private int nrQuartos;
    private boolean garagem;
    private double iptu;

    public Casa (int cod, Endereco endereco, double area, StatusImovel status,
                 double valor, int nrQuartos, boolean garagem, double iptu) {
        super (cod, endereco, area, status, valor);
        this.nrQuartos = nrQuartos;
        this.garagem = garagem;
        this.iptu = iptu;
    }
    @Override
    public double calcularValorFinal(){
        return getValor() + this.iptu;
    }

    public int getNrQuartos() {
        return nrQuartos;
    }

    public void setNrQuartos(int nrQuartos) {
        this.nrQuartos = nrQuartos;
    }

    public boolean isGaragem() {
        return garagem;
    }

    public void setGaragem(boolean garagem) {
        this.garagem = garagem;
    }

    public double getIptu() {
        return iptu;
    }

    public void setIptu(double iptu) {
        this.iptu = iptu;
    }
    @Override
    public String toString (){
        return super.toString() + " Tipo: Casa \n Quartos: "+ nrQuartos+ "\n Garagem: "+(garagem ? "Sim" : "Não")+
                "\n IPTU R$ "+ iptu;
    }
}
