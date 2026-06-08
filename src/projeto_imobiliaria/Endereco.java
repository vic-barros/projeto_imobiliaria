package projeto_imobiliaria;

public class Endereco {
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	
	public Endereco(String logradouro, int numero, String bairro, String cidade) {
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		if(logradouro == null || logradouro.strip().isEmpty()) {
			System.out.println("Valor de Logradouro Inválido!");
		}else {
			this.logradouro = logradouro;
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("Numéro Inválido!");
		}else {
			this.numero = numero;
		}
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		if(bairro == null || bairro.strip().isEmpty()) {
			System.out.println("Valor de Bairro Inválido!");
		}else {
			this.bairro = bairro;
		}
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		if(cidade == null || cidade.strip().isEmpty()) {
			System.out.println("Valor de Cidade Inválido!");
		}else {
			this.cidade = cidade;
		}
	}

	@Override
	public String toString() {
	    return "Endereco [" +
	           "Logradouro: " + logradouro +
	           ", Número: " + numero +
	           ", Bairro: " + bairro +
	           ", Cidade: " + cidade + "]";
	}
	
	
	
	
	

}
