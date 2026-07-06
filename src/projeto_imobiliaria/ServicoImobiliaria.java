package projeto_imobiliaria;

import java.util.ArrayList;

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

}
