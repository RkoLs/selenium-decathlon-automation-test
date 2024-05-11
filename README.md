Teste de Automação Web com Java, JUnit 5 e Selenium - Jornada do Usuário
Este projeto consiste em um conjunto de testes de automação desenvolvidos para garantir a jornada do usuário no site da Decathlon. Os testes foram criados utilizando Java 8, JUnit 5 e Selenium WebDriver, e têm como objetivo simular as ações que um usuário realizaria ao navegar pelo site, desde a pesquisa de produtos até a verificação do produto no carrinho de compras.

Objetivo
O objetivo principal deste projeto é garantir a funcionalidade e a integridade da jornada do usuário no site da Decathlon. Os testes automatizados foram projetados para identificar eventuais falhas ou problemas durante o processo de compra, permitindo que sejam corrigidos antes que afetem a experiência do usuário final.

Funcionalidades Testadas
Os testes automatizados cobrem as seguintes funcionalidades:

Pesquisa de Produtos: Verifica se o usuário pode pesquisar por produtos utilizando a barra de pesquisa do site.
Seleção de Produto: Simula a seleção de um produto específico após a pesquisa.
Escolha do Tamanho: Testa a capacidade do usuário de selecionar o tamanho desejado do produto.
Adição ao Carrinho: Verifica se o usuário pode adicionar o produto selecionado ao carrinho de compras.
Consulta de Frete: Testa a funcionalidade de informar o CEP para calcular o frete do produto.
Verificação do Carrinho de Compras: Confirma se o produto adicionado está corretamente exibido no carrinho de compras.
Estrutura do Projeto
O projeto está estruturado da seguinte forma:

DriverFactory: Classe responsável por inicializar e gerenciar a instância do WebDriver, utilizado para interagir com o navegador durante os testes de automação.
Executa: Classe com métodos para iniciar e finalizar o teste, além de maximizar a janela do navegador e abrir a página inicial do site da Decathlon.
Metodos: Classe contendo métodos para realizar as diferentes etapas da jornada do usuário, como clicar em botões, preencher campos de formulário e capturar textos.
Teste: Classe de teste que utiliza os métodos da classe Metodos para executar os testes automatizados.
Configuração e Execução
Para configurar e executar o projeto, siga estes passos:

Clone o repositório em sua máquina local.
Abra o projeto em sua IDE preferida.
Certifique-se de ter o JDK 8 e o Maven instalados em seu sistema.
Configure o WebDriver para o navegador Google Chrome.
Execute a classe de teste Teste.java para iniciar os testes automatizados.
