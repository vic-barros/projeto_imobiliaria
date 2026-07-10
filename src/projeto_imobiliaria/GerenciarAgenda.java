package projeto_imobiliaria;

import java.util.List;
import java.util.Scanner;

public class GerenciarAgenda {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ServicoImobiliaria servico = new ServicoImobiliaria();
		int opcao = 0;

		do {
			System.out.println("=======================================================");
			System.out.println("                      MENU IMOBILIÁRIA                 ");
			System.out.println("=======================================================");
			System.out.println("1) Cadastrar Cliente");
			System.out.println("2) Cadastrar Imóvel");
			System.out.println("3) Listar Imóveis");
			System.out.println("4) Vender Imóvel");
			System.out.println("5) Alugar Imóvel");
			System.out.println("6) Buscar Imóvel");
			System.out.println("7) Relatórios");
			System.out.println("8) Sair do Sistema");
			System.out.print("Digite a sua opção: ");
			System.out.println("=======================================================");
			System.out.println("=======================================================");

			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("                     CADASTRAR CLIENTE                 ");
				System.out.println("=======================================================");
				System.out.println("Digite o nome do Cliente: ");
				String nome = scanner.nextLine();
				System.out.println("Digite o número do CPF de " + nome + ": ");
				String cpf = scanner.nextLine();
				System.out.println("Telefone de Contato: ");
				String contato = scanner.nextLine();
				System.out.println("E-mail: ");
				String email = scanner.nextLine();
				Cliente cliente = new Cliente(nome, cpf, contato, email);
				servico.cadastrarCliente(cliente);
				break;

			case 2:
				System.out.println("                      CADASTRAR IMÓVEL                 ");
				System.out.println("=======================================================");
				System.out.println("Escolha o tipo de imóvel:\n1) Casa\n2) Apartamento\n3) Terreno");
				int tipoImovel = scanner.nextInt();
				scanner.nextLine();

				System.out.println("Rua do Imóvel: ");
				String logradouro = scanner.nextLine();
				System.out.println("Número do Imóvel: ");
				int numero = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Bairro do Imóvel: ");
				String bairro = scanner.nextLine();
				System.out.println("Cidade do Imóvel: ");
				String cidade = scanner.nextLine();
				Endereco localizaco = new Endereco(logradouro, numero, bairro, cidade);

				System.out.println("Valor do imóvel R$: ");
				double valor = scanner.nextDouble();
				System.out.println("Área do imóvel m²: ");
				double area = scanner.nextDouble();
				scanner.nextLine();

				System.out.println("Escolha o status do imóvel:\n1) Disponível\n2) Alugado\n3) Vendido");
				int opcaoStatus = scanner.nextInt();
				scanner.nextLine();

				StatusImovel statusImovel = StatusImovel.DISPONIVEL;
				if (opcaoStatus == 2)
					statusImovel = StatusImovel.ALUGADO;
				else if (opcaoStatus == 3)
					statusImovel = StatusImovel.VENDIDO;

				Imovel cadastrarImovel = null;

				if (tipoImovel == 1) {
					System.out.println("Número de quartos: ");
					int quartos = scanner.nextInt();
					System.out.println("Possui garagem? (true/false): ");
					boolean garagem = scanner.nextBoolean();
					System.out.println("Valor do IPTU R$: ");
					double iptuCasa = scanner.nextDouble();
					scanner.nextLine();

					cadastrarImovel = new Casa(localizaco, valor, area, statusImovel, quartos, garagem, iptuCasa);

				} else if (tipoImovel == 2) {
					System.out.println("Andar: ");
					int andar = scanner.nextInt();
					System.out.println("Número do Apt: ");
					int numApt = scanner.nextInt();
					System.out.println("Valor do IPTU R$: ");
					double iptuApt = scanner.nextDouble();
					System.out.println("Valor do Condomínio R$: ");
					double condominio = scanner.nextDouble();
					scanner.nextLine();

					cadastrarImovel = new Apartamento(localizaco, area, statusImovel, valor, andar, numApt, iptuApt,
							condominio);

				} else if (tipoImovel == 3) {
					System.out.println("Tipo do Terreno:\n1) Residencial\n2) Comercial");
					int opcaoTerreno = scanner.nextInt();
					scanner.nextLine();

					TipoTerreno tipoTerreno = (opcaoTerreno == 2) ? TipoTerreno.COMERCIAL : TipoTerreno.RESIDENCIAL;

					cadastrarImovel = new Terreno(localizaco, area, statusImovel, valor, tipoTerreno);
				}

				if (cadastrarImovel != null) {
					servico.cadastrarImovel(cadastrarImovel);
				} else {
					System.out.println("Tipo de imóvel inválido! Cadastro cancelado.");
				}
				break;

			case 3:
				System.out.println("                      LISTAR IMÓVEIS                  ");
				System.out.println("=======================================================");

				List<Imovel> listaDeImoveis = servico.getImoveis();

				if (listaDeImoveis.isEmpty()) {
					System.out.println("Nenhum imóvel cadastrado no sistema até o momento.");
				} else {

					for (Imovel imovel : listaDeImoveis) {
						System.out.println(imovel);
						System.out.println("-------------------------------------------------------");
					}
				}
				break;

			case 4:
				System.out.println("                        VENDER IMÓVEL                  ");
				System.out.println("=======================================================");

				System.out.print("Digite o CPF do cliente comprador: ");
				String cpfBusca = scanner.nextLine();

				Cliente clienteComprador = null;
				for (Cliente c : servico.getClientes()) {
					if (c.getCpf().equals(cpfBusca)) {
						clienteComprador = c;
						break;
					}
				}

				System.out.print("Digite o Código do imóvel a ser vendido: ");
				int codBusca = scanner.nextInt();
				scanner.nextLine();

				Imovel imovelVenda = null;
				for (Imovel i : servico.getImoveis()) {
					if (i.getCod() == codBusca) {
						imovelVenda = i;
						break;
					}
				}

				if (clienteComprador == null) {
					System.out.println("Erro: Não foi encontrado nenhum cliente com o CPF informado.");
				} else if (imovelVenda == null) {
					System.out.println("Erro: Não foi encontrado nenhum imóvel com o Código informado.");
				} else {
					servico.venderImovel(imovelVenda, clienteComprador);
				}
				break;

			case 5:
				System.out.println("                        ALUGAR IMÓVEL                  ");
				System.out.println("=======================================================");

				System.out.print("Digite o CPF do cliente locatário: ");
				String cpfLocatario = scanner.nextLine();

				Cliente clienteLocatario = null;
				for (Cliente c : servico.getClientes()) {
					if (c.getCpf().equals(cpfLocatario)) {
						clienteLocatario = c;
						break;
					}
				}

				System.out.print("Digite o Código do imóvel a ser alugado: ");
				int codAluguel = scanner.nextInt();
				scanner.nextLine();

				Imovel imovelAluguel = null;
				for (Imovel i : servico.getImoveis()) {
					if (i.getCod() == codAluguel) {
						imovelAluguel = i;
						break;
					}
				}

				if (clienteLocatario == null) {
					System.out.println("Erro: Não foi encontrado nenhum cliente com o CPF informado.");
				} else if (imovelAluguel == null) {
					System.out.println("Erro: Não foi encontrado nenhum imóvel com o Código informado.");
				} else {

					System.out.print("Digite o valor mensal do aluguel R$: ");
					double valorMensal = scanner.nextDouble();
					scanner.nextLine();

					servico.alugarImovel(imovelAluguel, clienteLocatario, valorMensal);
				}
				break;

			case 6:
				System.out.println("Que tipo de busca deseja realizar?");
				System.out.println("1) Por Tipo de Imóvel (Casa/Apartamento)");
				System.out.println("2) Por Status (Disponível/Alugado/Vendido)");
				System.out.print("Digite a opção: ");
				int opcaoBusca = scanner.nextInt();
				scanner.nextLine();

				switch (opcaoBusca) {
				case 1:
					System.out.println("\nQual Tipo de Imóvel deseja buscar?");
					System.out.println("1) Casa");
					System.out.println("2) Apartamento");
					System.out.print("Digite a opção: ");
					int opTipo = scanner.nextInt();
					scanner.nextLine();

					String escolhaImovel = "";
					if (opTipo == 1) {
						escolhaImovel = "Casa";
					} else if (opTipo == 2) {
						escolhaImovel = "Apartamento";
					} else {
						System.out.println("Opção Inválida!");
						break;
					}

					List<Imovel> imoveisPorTipo = servico.buscarImovelPorTipo(escolhaImovel);
					if (imoveisPorTipo.isEmpty()) {
						System.out.println("Poxa, que pena! Não foi encontrado nenhum imóvel desse tipo.");
					} else {
						System.out.println("=======================================================");
						System.out.println("                  IMÓVEIS ENCONTRADOS                  ");
						System.out.println("=======================================================");
						for (Imovel imovel : imoveisPorTipo) {
							System.out.println(imovel);
							System.out.println("-------------------------------------------------------");
						}
					}
					break;

				case 2:
					System.out.println("\nQual Status do imóvel você procura?");
					System.out.println("1) Disponível");
					System.out.println("2) Alugado");
					System.out.println("3) Vendido");
					System.out.print("Digite a opção: ");
					int opStatus = scanner.nextInt();
					scanner.nextLine();

					String statusEscolha = "";
					if (opStatus == 1) {
						statusEscolha = "DISPONIVEL";
					} else if (opStatus == 2) {
						statusEscolha = "ALUGADO";
					} else if (opStatus == 3) {
						statusEscolha = "VENDIDO";
					} else {
						System.out.println("Opção Inválida!");
						break;
					}

					List<Imovel> imoveisPorStatus = servico.buscarImovelPorStatus(statusEscolha);
					if (imoveisPorStatus.isEmpty()) {
						System.out.println("Poxa, que pena! Não foi encontrado nenhum imóvel com esse status.");
					} else {
						System.out.println("=======================================================");
						System.out.println("                  IMÓVEIS ENCONTRADOS                  ");
						System.out.println("=======================================================");
						for (Imovel imovel : imoveisPorStatus) {
							System.out.println(imovel);
							System.out.println("-------------------------------------------------------");
						}
					}
					break;

				default:
					System.out.println("Opção de busca inválida! Tente Novamente.");
				}
				break;
			case 7:
				servico.gerarRelatorios();

				break;

			case 8:
				System.out.println("Nunca desista dos seus sonhos!");
				System.out.println("Obrigado e volte sempre! ;)");

				break;

			default:
				System.out.println("Opção Inválida! Tente Novamente! ;)");

			}

		} while (opcao != 8);
		scanner.close();
	}
}
