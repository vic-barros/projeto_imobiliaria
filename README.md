\# 🏢 Sistema de Informatização Imobiliária



Este repositório contém uma aplicação orientada a objetos desenvolvida em \*\*Java\*\* para automatizar e gerenciar os processos de cadastro e controle de imóveis, clientes e contratos de uma imobiliária. O projeto foi estruturado seguindo rigorosamente os conceitos de Programação Orientada a Objetos (POO) e modelado via Diagrama de Classes UML.



\---



\## 📌 Visão Geral do Sistema



O sistema foi concebido para centralizar todas as operações de uma imobiliária, englobando desde a estruturação física de diferentes tipos de propriedades até a formalização de transações financeiras e comerciais através de contratos de locação ou venda.



\### Principais Funcionalidades:

\* \*\*Gestão de Clientes:\*\* Cadastro e armazenamento de dados essenciais (Nome, CPF, Telefone, E-mail).

\* \*\*Gestão de Imóveis:\*\* Suporte a múltiplas categorias de imóveis (Casas, Apartamentos e Terrenos) com herança e polimorfismo.

\* \*\*Controle de Contratos:\*\* Emissão de contratos dinâmicos diferenciando os fluxos de \*\*Venda\*\* e \*\*Aluguel\*\*.

\* \*\*Motor de Busca e Relatórios:\*\* Consultas avançadas por status de disponibilidade, tipos de propriedades e geração automatizada de relatórios gerenciais.



\---



\## 📐 Arquitetura e Modelagem do Sistema



A estrutura de dados e as relações entre as entidades foram mapeadas no seguinte ecossistema de classes:



\### 1. Núcleo de Domínio (Entidades)

\* \*\*`Imovel` (Classe Abstrata):\*\* Contém os atributos universais (`cod`, `endereco`, `valor`, `area`, `status`) e herda a obrigatoriedade de cálculo financeiro.

&#x20;   \* \*\*`Casa`\*\*: Especialização contendo número de quartos, presença de garagem (`boolean`) e valor do IPTU próprio.

&#x20;   \* \*\*`Apartamento`\*\*: Especialização que adiciona andar, número do apartamento, valor do condomínio e IPTU.

&#x20;   \* \*\*`Terreno`\*\*: Especialização mapeada de acordo com o zoneamento geográfico (`TipoTerreno`).

\* \*\*`Endereco`\*\*: Classe utilitária associada ao imóvel para decompor logradouro, número, bairro e cidade.

\* \*\*`Cliente`\*\*: Representa a ponta compradora, locatária ou proprietária no sistema.

\* \*\*`Contrato`\*\*: Entidade que vincula um `Cliente` a um `Imovel`, definindo o tipo da transação e o valor acordado.



\### 2. Contratos Abstratos e Enumerações

\* \*\*`Calculavel` (Interface):\*\* Contrato abstrato que força a implementação do método `calcularValorFinal()`.

\* \*\*`StatusImovel` (Enumerador):\*\* Define o ciclo de vida do imóvel no sistema: `Disponivel`, `Alugado`, `Vendido`.

\* \*\*`TipoTerreno` (Enumerador):\*\* Restringe as opções de uso para terrenos: `Residencial`, `Comercial`.



\### 3. Classe de Serviço (Fachada / Core)

\* \*\*`ServicoImobiliaria`\*\*: Atua como o gerenciador central da aplicação. Centraliza as listas globais de clientes, imóveis e contratos, além de expor as regras de negócio:

&#x20;   \* `cadastrarCliente(Cliente c)`

&#x20;   \* `cadastrarImovel(Imovel i)`

&#x20;   \* `venderImovel(Imovel i, Cliente comprador)`

&#x20;   \* `alugarImovel(Imovel i, Cliente locatario, double valorMensal)`

&#x20;   \* `buscarImovelPorTipo(String tipo)`

&#x20;   \* `buscarImovelPorStatus(String status)`

&#x20;   \* `gerarRelatorios()`



\---



\## ⚙️ Regras de Negócio e Comportamentos



1\.  \*\*Polimorfismo no Cálculo Final (`calcularValorFinal`):\*\*

&#x20;   \* Cada tipo de imóvel calcula suas taxas e custos finais de forma individualizada com base nas variáveis de condomínio, taxas locais ou IPTU incorporado.

2\.  \*\*Ciclo de Contratos e Mutabilidade de Status:\*\*

&#x20;   \* Ao executar a operação `venderImovel()`, o sistema deve instanciar um novo `Contrato` do tipo "Venda", associá-lo ao comprador e alterar o enumerador do imóvel para `StatusImovel.Vendido`.

&#x20;   \* Na operação `alugarImovel()`, o contrato gerado será do tipo "Aluguel" e o status passará a ser `StatusImovel.Alugado`.



\---



\## 🛠️ Tecnologias Utilizadas



\* \*\*Linguagem Principal:\*\* Java (JDK 17 ou superior)

\* \*\*Paradigma:\*\* Programação Orientada a Objetos (Herança, Polimorfismo, Encapsulamento e Abstração)

\* \*\*Ferramenta de Modelagem:\*\* UML (Unified Modeling Language)

\* \*\*Controle de Versão:\*\* Git \& GitHub

