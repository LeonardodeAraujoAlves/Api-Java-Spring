# API de CRUD com Spring Boot

Esta é uma API de exemplo que implementa as operações CRUD (Create, Read, Update, Delete) em um banco de dados utilizando o framework Spring Boot, o Maven como gerenciador de dependências e o JPA para persistência de dados.

## Pré-requisitos

Certifique-se de ter instalado o seguinte antes de executar a API:

- Java Development Kit 17
- Maven
- Criar o bando de dados no mysql com o nome de api_spring
## Configuração do Banco de Dados

Esta API utiliza o JPA para a persistência de dados, portanto, é necessário configurar as informações do banco de dados no arquivo `application.properties`. Abra o arquivo e atualize as seguintes propriedades:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/{api_spring}
spring.datasource.username={nome_do_usuario}
spring.datasource.password={senha_do_usuario}

Certifique-se de substituir `{nome_do_banco_de_dados}`, `{nome_do_usuario}` e `{senha_do_usuario}` pelas informações corretas do seu banco de dados.

As tabelas serão criadas automaticamente através do JPA.

## Executando a API

Para executar a API, siga os seguintes passos:

1. Abra um terminal na pasta raiz do projeto.

2. Execute o seguinte comando para compilar o projeto e baixar as dependências:

   

bash
   mvn clean install
   

3. Após a conclusão da compilação, execute o seguinte comando para iniciar a API:

   

bash
   mvn spring-boot:run
   

   A API estará disponível em `http://localhost:8090`.
