package projeto_imobiliaria;

public class Apartamento extends Imovel{
    private int andar;
    private int numeroApt;
    private double iptu;
    private double vlrCondominio;

    public Apartamento(int cod, Endereco endereco, double area, StatusImovel status, double valor, int andar, int numeroApt, double iptu, double vlrCondominio) {
        super(cod, endereco, area, status, valor);
        this.andar = andar;
        this.numeroApt = numeroApt;
        this.iptu = iptu;
        this.vlrCondominio = vlrCondominio;
    }
    @Override
    public double calcularValorFinal (){
        return getValor() + this.iptu + this.vlrCondominio;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getNumeroApt() {
        return numeroApt;
    }

    public void setNumeroApt(int numeroApt) {
        this.numeroApt = numeroApt;
    }

    public double getIptu() {
        return iptu;
    }

    public void setIptu(double iptu) {
        this.iptu = iptu;
    }

    public double getVlrCondominio() {
        return vlrCondominio;
    }

    public void setVlrCondominio(double vlrCondominio) {
        this.vlrCondominio = vlrCondominio;
    }
    @Override
    public String toString (){
        return super.toString () + " | Tipo: Apartamento: \nApt: "+ numeroApt+ "\nAndar: "+andar+"\nCondomínio: R$ "+
                vlrCondominio+ "IPTU R$ "+iptu;
    }
}
