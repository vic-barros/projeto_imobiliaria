package projeto_imobiliaria;

import java.util.Objects;

public abstract class Imovel implements Calculavel {
	private int cod;
	private Endereco endereco;
	private double valor;
	private double area;
	private StatusImovel status;
	
	private static int contadorCodigo = 0;
	
	public Imovel(Endereco endereco, double valor, double area, StatusImovel status) {
		this.cod = ++contadorCodigo;
		this.endereco = endereco;
		this.valor = valor;
		this.area = area;
		this.status = status;
	}
	
	public abstract double calcularValorFinal();
	 

	@Override
	public String toString() {
	    return "Imovel [" +
	           "Código: " + cod +
	           ", Endereço: " + endereco +
	           ", Valor: R$ " + valor +
	           ", Área: " + area + "m²" +
	           ", Status: " + status + "]";
	}

	 @Override
	 public int hashCode() {
		return Objects.hash(cod);
	 }

	 @Override
	 public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		return cod == other.cod;
	 }

	 public int getCod() {
		 return cod;
	 }

	 public Endereco getEndereco() {
		 return endereco;
	 }

	 public void setEndereco(Endereco endereco) {
		 this.endereco = endereco;
	 }

	 public double getValor() {
		 return valor;
	 }

	 public void setValor(double valor) {
		 this.valor = valor;
	 }

	 public StatusImovel getStatus() {
		 return status;
	 }

	 public void setStatus(StatusImovel status) {
		 this.status = status;
	 }

	 public double getArea() {
		 return area;
	 }

	 public void setArea(double area) {
		 this.area = area;
	 }
	 
	 

}
