package projeto_imobiliaria;

import java.util.Objects;

public class Cliente {
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	
	public Cliente(String nome, String cpf, String telefone, String email) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome == null || nome.strip().isEmpty()) {
			System.out.println("Nome Nulo ou Vazio!");
		}else {
			this.nome = nome;
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpfSujo) {
String cpfLimpo = cpfSujo.replaceAll("\\D", "");
		
		if(cpfLimpo.length() != 11) {
			System.out.println("Tamanho Inválido!");
			return;
		}
		//DV1
		int somaDv1 = 0;
		for(int i = 0; i < 9; i++) {
			int num = Character.getNumericValue(cpfLimpo.charAt(i));
			somaDv1 = somaDv1 + num * (10 - i);
		}
		
		int resto1 = somaDv1 % 11;
		int dv1;
		if(resto1 < 2) {
			dv1 = 0;
		}else {
			dv1 = 11 - resto1;
		}
		
		//DV2
		int somaDv2 = 0;
		for(int i = 0; i < 10; i++) {
			int num = Character.getNumericValue(cpfLimpo.charAt(i));
			somaDv2 = somaDv2 + num * (11 - i);
		}
		
		int resto2 = somaDv2 % 11;
		int dv2;
		if(resto2 < 2) {
			dv2 = 0;
		}else {
			dv2 = 11 - resto2;
		}
		
		//Verificação Final
		if(dv1 == Character.getNumericValue(cpfLimpo.charAt(9))
				&& dv2 == Character.getNumericValue(cpfLimpo.charAt(10))) {
			this.cpf = cpfLimpo;
		}else {
			System.out.println("CPF Inválido!");
		}
		
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if(telefone == null || telefone.strip().isEmpty()) {
			System.out.println("Telefone Nulo ou Vazio");
		}else {
			this.telefone = telefone.replaceAll("\\D", "");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email == null || email.strip().isEmpty()) {
			System.out.println("E-mail Nulo ou Vazio!");
		}else if(!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
			System.out.println("E-mail Inválido!");
		}else {
			this.email = email;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	@Override
	public String toString() {
	    return "Cliente [" +
	           " Nome: " + nome +
	           ", CPF: " + cpf +
	           ", Telefone: " + telefone +
	           ", E-mail: " + email + "]";
	}
	
	
	
	

}
