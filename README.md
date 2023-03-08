<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>README - Back End de um sistema de E-commerce</title>
  </head>
  <body>
    <h1>README - Back End de um sistema de E-commerce</h1>
    <p>Este projeto é um back end para um sistema de E-commerce com operações CRUD para Produtos e Clientes, além de solicitações de produtos com informações sobre o destinatário e outros detalhes.</p>

<p>Foi utilizado o framework Spring Boot em conjunto com Spring Data JPA para a implementação do sistema. O banco de dados utilizado foi o MySQL e para gerenciamento de migrações foi utilizado o Flyway.</p>

<h2>Requisitos</h2>

<ul>
  <li>JDK 11 ou superior</li>
  <li>Maven 3.6 ou superior</li>
  <li>MySQL 8.0 ou superior</li>
</ul>

<h2>Configuração do Banco de Dados</h2>

<p>Antes de iniciar a aplicação, é necessário criar o banco de dados e configurar as credenciais no arquivo <code>application.properties</code>:</p>

<pre>
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=<seu_username>
spring.datasource.password=<sua_senha>
</pre>

<p>O banco de dados será criado automaticamente durante a inicialização da aplicação graças à biblioteca Flyway, que irá executar as migrações necessárias.</p>

<h2>Endpoints disponíveis</h2>

<p>Abaixo estão listados os endpoints disponíveis na aplicação:</p>

<h3>Produtos</h3>

<ul>
  <li><code>GET /produtos</code>: Retorna uma lista de todos os produtos cadastrados.</li>
  <li><code>GET /produtos/{id}</code>: Retorna os detalhes de um produto específico.</li>
  <li><code>POST /produtos</code>: Cria um novo produto.</li>
  <li><code>PUT /produtos/{id}</code>: Atualiza os dados de um produto específico.</li>
  <li><code>DELETE /produtos/{id}</code>: Remove um produto específico.</li>
</ul>

<h3>Clientes</h3>

<ul>
  <li><code>GET /clientes</code>: Retorna uma lista de todos os clientes cadastrados.</li>
  <li><code>GET /clientes/{id}</code>: Retorna os detalhes de um cliente específico.</li>
  <li><code>POST /clientes</code>: Cria um novo cliente.</li>
  <li><code>PUT /clientes/{id}</code>: Atualiza os dados de um cliente específico.</li>
  <li><code>DELETE /clientes/{




