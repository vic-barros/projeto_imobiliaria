package projeto_imobiliaria;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class GerenciarAgenda {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        ServicoImobiliaria servico = new ServicoImobiliaria();
        int opcao =0;

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

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("                     CADASTRAR CLIENTE                 ");
                    System.out.println("=======================================================");
                    System.out.println("Por gentileza, digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o número do CPF de "+nome+ ": ");
                    String cpf = scanner.nextLine();
                    System.out.println("Qual o telefone para contato? ");
                    String contato = scanner.nextLine();
                    System.out.println("Qual o email?");
                    String email = scanner.nextLine();
                    Cliente cliente = new Cliente(nome,cpf,contato,email);
                    servico.cadastrarCliente(cliente);
                    break;
                case 2:
                    System.out.println("                      CADASTRAR IMÓVEL                 ");
                    System.out.println("=======================================================");
                    System.out.println("Qual o nome da rua do imóvel que deseja cadastrar?");
                    String logradouro = scanner.nextLine();
                    System.out.println("Qual o número? ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome do bairro: ");
                    String bairro = scanner.nextLine();
                    System.out.println("Digite o nome da cidade: ");
                    String cidade = scanner.nextLine();
                    Endereco localizaco = new Endereco(logradouro, numero, bairro, cidade);
                    System.out.println("Valor do imóvel R$: ");
                    double valor = scanner.nextDouble();
                    System.out.println("Área do imóvel m²: ");
                    double area = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Escolha uma opção de status do imóvel: " +
                            "\n1) Disponível" +
                            "\n2) Alugado" +
                            "\n3) Vendido ");
                    int opcaoStatus = scanner.nextInt();
                    scanner.nextLine();
                    StatusImovel statusImovel = null;
                    if (opcaoStatus == 1){
                        statusImovel = StatusImovel.DISPONIVEL;
                    } else if (opcaoStatus == 2) {
                        statusImovel = StatusImovel.ALUGADO;
                    } else if (opcaoStatus == 3) {
                        statusImovel = StatusImovel.VENDIDO;
                    }else {
                        System.out.println("Inválido! Tente Novamente");
                    }
                    Imovel cadastrarImovel = new Imovel(localizaco, valor, area, statusImovel) {
                        @Override
                        public double calcularValorFinal() {
                            return 0;
                            // PRECISA CORRIGIR O RETORNO DO CALCULARVALORFINAL
                            // O RETORNO SEMPRE SERÁ ZERO.
                        }
                    };
                    servico.cadastrarImovel(cadastrarImovel);
                    break;

                case 3:

                    break;
                case 4:

                    break;

                case 5:

                    break;

                case 6:
                    System.out.println("Que tipo de busca deseja realizar?");
                    System.out.println("1) Por Imovél ");
                    System.out.println("2) Por Status ");
                    System.out.println("Digite a opção: ");
                    opcao = scanner.nextInt();
                    scanner.nextLine();
                    String escolha = String.valueOf(opcao);
                    switch (opcao){
                        case 1:
                            System.out.println("Qual Imóvel deseja buscar?");
                            System.out.println("1) Casa");
                            System.out.println("2) Apartamento");
                            System.out.println("Digite a opção: ");
                            opcao = scanner.nextInt();
                            scanner.nextLine();
                            String escolhaImovel="";
                                if (opcao == 1){
                                    escolhaImovel = "casa";
                                } else if (opcao == 2) {
                                    escolhaImovel = "apartamento";

                                }else {
                                    System.out.println("Opção Inválida! Tente Novamente. ");
                                }

                                List<Imovel> imoveisEncontrados = servico.buscarImovelPorTipo(escolhaImovel);
                                if (imoveisEncontrados.isEmpty()){
                                    System.out.println("Poxa, que pena! Não foi encontrado nenhum imóvel desse tipo!");
                                }else {
                                    System.out.println("=======================================================");
                                    System.out.println("                      MENU IMOBILIÁRIA                 ");
                                    System.out.println("=======================================================");
                                    int contador = 1;
                                    for (Imovel imovel : imoveisEncontrados){
                                        System.out.println(contador+") "+imovel);
                                        contador ++;
                                    }
                                }

                            break;
                        case 2:
                            System.out.println("Qual Status do imóvel que procura?");
                            System.out.println("1) Disponível");
                            System.out.println("2) Alugado");
                            System.out.println("3) Vendido");
                            opcao = scanner.nextInt();
                            scanner.nextLine();
                            String statusEscolha="";
                            if (opcao == 1){
                                statusEscolha = "disponivel";
                            } else if (opcao ==2) {
                                statusEscolha="alugado";
                            } else if (opcao ==3) {
                                statusEscolha = "vendido";

                            }else {
                                System.out.println("Opção Inválida! Não desista dos seus sonhos! Tente Novamente!");
                            }
                            List <Imovel> buscarImovelPorStatus = servico.buscarImovelPorStatus(statusEscolha);
                            if (buscarImovelPorStatus.isEmpty()){
                                System.out.println("Poxa, que pena! Não foi encontrado nenhum imóvel desse tipo!");
                            }else {
                                System.out.println("=======================================================");
                                System.out.println("                      MENU IMOBILIÁRIA                 ");
                                System.out.println("=======================================================");
                                int contador =1;
                                for (Imovel imovel : buscarImovelPorStatus){
                                    System.out.println(contador +") "+ imovel);
                                    contador++;
                                }
                            }
                            break;
                        default:
                            System.out.println("Opção Inválida! Seu imóvel está perto de você! Tente Novamente!");
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

        }while (opcao != 8);
        scanner.close();
    }
}
