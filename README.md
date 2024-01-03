# API Treinar Spring Boot - E-Commerce

Este projeto é o backend de um sistema de E-Commerce, com funcionalidades de operações CRUD para produtos e clientes, além de solicitações de produtos com informações detalhadas sobre o destinatário e outros recursos.

## Tecnologias Utilizadas

- **Spring Boot**: Utilizado para a implementação do sistema.
- **Spring Data JPA**: Facilita o acesso aos dados e operações CRUD.
- **MySQL**: Banco de dados usado para armazenar os dados.
- **Flyway**: Gerencia migrações de banco de dados para manter a estrutura da base de dados consistente.

## Requisitos

Para executar este projeto, você precisa ter instalado:

- JDK 11 ou superior
- Maven 3.6 ou superior
- MySQL 8.0 ou superior

## Configuração do Banco de Dados

Antes de iniciar a aplicação, é necessário criar o banco de dados e configurar as credenciais no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=seu-username
spring.datasource.password=sua-senha
