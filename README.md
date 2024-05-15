# Automação Web com Java, JUnit e Selenium

Este projeto consiste em uma automação de teste de web desenvolvida em Java, utilizando JUnit como framework de teste e Selenium para interação com o navegador.

## Objetivo

O objetivo deste projeto é garantir a jornada do usuário ao testar a funcionalidade de busca de produtos, selecionar um produto, selecionar o tamanho do produto, adicionar ao carrinho, informar o CEP para consultar o frete e verificar o produto no carrinho de compras.

Durante o processo de teste com o usuário deslogado, foi identificado um problema no site, onde, durante a última etapa do processo, o usuário precisa fazer três solicitações de clique para acessar o carrinho de compras.
Isso se deve à comunicação entre o front-end e o back-end, prejudicando a experiência do usuário final. 

## Ferramentas Utilizadas

- Linguagem de Programação: Java 8
- Framework de Teste: JUnit 5
- Automação de Navegador: Selenium WebDriver
- Gerenciador de Dependências: Maven

## Estrutura do Projeto

O projeto está dividido em várias classes e pacotes, cada um com uma função específica:

- `DriverFactory`: Classe responsável por fornecer uma instância do WebDriver para os testes.
- `Executa`: Classe contendo métodos para iniciar e finalizar o teste, utilizando o ChromeDriver como navegador.
- `Metodos`: Classe contendo métodos para interagir com elementos da página, realizar ações como clicar, preencher campos, capturar texto e capturar screenshots.
- `Teste`: Classe de teste contendo o método `comprarProduto()` que executa a jornada do usuário.

## Instalação

Antes de executar o teste automatizado, certifique-se de ter os seguintes pré-requisitos instalados:

### Pré-requisitos

- Java Development Kit (JDK) 8 ou superior
- Apache Maven

### Configurar as variáveis de ambiente

Certifique-se de configurar corretamente as variáveis de ambiente para o JDK e o Maven no seu sistema.

Para executar o teste automatizado, siga as instruções abaixo:

### Clonar o Repositório

1. Clone o repositório para sua máquina local:

```bash
git clone https://github.com/RkoLs/selenium-decathlon-automation-test.git
```

### Navegar até o Diretório do Projeto

2. Navegue até o diretório do projeto:

```bash
cd decathlon.automation
```

### Buildar o Projeto Localmente

3. Antes de executar o teste automatizado, é necessário buildar o projeto localmente. Para isso, utilize o Maven:

```bash
mvn clean install
```

4. Após a build ser concluída com sucesso, você pode executar o teste:

```bash
mvn test
```

## Autor
Richard Leal Kovalski de Lima - [[LinkedIn](https://www.linkedin.com/in/richardkovalski/)]
