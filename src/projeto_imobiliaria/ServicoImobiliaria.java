package projeto_imobiliaria;

import java.util.ArrayList;
import java.util.List;

public class ServicoImobiliaria {
	private ArrayList<Cliente> clientes;
	private ArrayList<Imovel> imoveis;
	private ArrayList<Contrato> contratos;

	public ServicoImobiliaria() {
		this.clientes = new ArrayList<Cliente>();
		this.imoveis = new ArrayList<Imovel>();
		this.contratos = new ArrayList<Contrato>();
	}

	public void cadastrarCliente(Cliente c) {
		try {
			if (this.clientes.contains(c)) {
				throw new ValidacaoException("Erro: Já existe um cleinte cadastrado com o CPF " + c.getCpf());
			} else {
				clientes.add(c);
				System.out.println("Cliente cadastrado com sucesso!");
			}
		} catch (ValidacaoException e) {
			System.err.println(e.getMessage());
		}
	}

	public void cadastrarImovel(Imovel i) {
		try {
			if (this.imoveis.contains(i)) {
				throw new ValidacaoException("Erro: esse imóvel já foi cadastrado");
			} else {
				imoveis.add(i);
				System.out.println("Imóvel cadastrado com sucesso!");
			}

		} catch (ValidacaoException e) {
			System.err.println(e.getMessage());

		}
	}

	public void venderImovel(Imovel i, Cliente clienteComprador) {
		try {
			if (i.getStatus() != StatusImovel.DISPONIVEL) {
				throw new ValidacaoImovelDisponivel("Imóvel não se encontra disponível");
			} else {
				i.setStatus(StatusImovel.VENDIDO);

				Contrato contrato = new Contrato(clienteComprador, i, TipoContrato.VENDA, i.calcularValorFinal());
				contratos.add(contrato);
			}
		} catch (ValidacaoImovelDisponivel e) {
			System.err.println(e.getMessage());
		}

	}

	public void alugarImovel(Imovel i, Cliente locatario, double valorMensal) {
		try {
			if (i.getStatus() != StatusImovel.DISPONIVEL) {
				throw new ValidacaoImovelDisponivel("Imóvel indisponível para aluguel");
			}
			if (valorMensal <= 0) {
				throw new ValorInvalidoException("Valor do aluguel não pode ser menor ou igual a zero");

			}

			i.setStatus(StatusImovel.ALUGADO);
			Contrato contrato = new Contrato(locatario, i, TipoContrato.ALUGUEL, valorMensal);
			contratos.add(contrato);

		} catch (ValidacaoImovelDisponivel e) {
			System.err.println(e.getMessage());

		} catch (ValorInvalidoException e) {
			System.err.println(e.getMessage());

		}

	}
	public List<Imovel> buscarImovelPorTipo (String tipo){
		List<Imovel> resultado = new ArrayList<>();
		for (Imovel imovel : this.imoveis){
			if (imovel.getClass().getSimpleName().equalsIgnoreCase(tipo)){
				resultado.add(imovel);
			}
		}
		return resultado;
	}
	public List<Imovel>buscarImovelPorStatus(String status){
		List<Imovel> resultado = new ArrayList<>();
		for (Imovel imovel : this.imoveis){
			if (imovel.getStatus().toString().equalsIgnoreCase(status)){
				resultado.add(imovel);
			}
		}
		return resultado;
	}
	public void gerarRelatorios(){
		int qtdDisponiveis = 0;
		int qtdVendido = 0;
		double totalVendido = 0;
		int qtdAlugados = 0;
		double totalAlugado = 0;
		Imovel imovelMaisCaro = null;
		for (Imovel imovel : this.imoveis){
			if (imovelMaisCaro == null || imovel.calcularValorFinal()>
					imovelMaisCaro.calcularValorFinal()){
				imovelMaisCaro = imovel;
			}
			if (imovel.getStatus() == StatusImovel.DISPONIVEL){
				qtdDisponiveis++;
			} else if (imovel.getStatus()== StatusImovel.VENDIDO) {
				qtdVendido++;
				totalVendido += imovel.calcularValorFinal();
			}else if (imovel.getStatus()== StatusImovel.ALUGADO){
				qtdAlugados++;
				for (Contrato contrato : this.contratos){
					if (contrato.getImovel().equals(imovel)){
						totalAlugado += contrato.getValorAcordado();
					}
				}
			}
		}
	}



}
