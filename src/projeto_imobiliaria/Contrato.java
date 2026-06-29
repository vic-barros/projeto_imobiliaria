package projeto_imobiliaria;

public class Contrato {
	private Cliente cliente;
	private Imovel imovel;
	private TipoContrato tipoContrato;
	private double valorAcordado;

	public Contrato(Cliente cliente, Imovel imovel, TipoContrato tipoContrato, double valorAcordado) {
		this.cliente = cliente;
		this.imovel = imovel;
		this.tipoContrato = tipoContrato;
		this.valorAcordado = valorAcordado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public double getValorAcordado() {
		return valorAcordado;
	}

	public void setValorAcordado(double valorAcordado) {
		this.valorAcordado = valorAcordado;
	}

	public String emitirContrato() {
		return "Dados do Contrato\n"
				+ "Cliente:" + cliente + "\n"
				+ "Imóvel:" + imovel + "\n"
				+ "Tipo do Contrato:" + tipoContrato + "\n"
				+ "Valor do Contrato:" + valorAcordado;

	}

	

}
