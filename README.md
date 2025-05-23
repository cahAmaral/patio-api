README - Sistema de Controle de Pátio para Motos
Descrição
Este projeto é uma aplicação backend em Java com Spring Boot para controle inteligente de pátio de motos. O sistema permite o registro de entrada e saída de motos por meio de QR Code ou RFID, autenticação de operadores, setorização dinâmica das vagas e rastreamento completo da movimentação no pátio.

Funcionalidades Principais
Cadastro de motos com identificação via QR Code ou RFID.

Cadastro e autenticação de operadores (via crachá, biometria ou login no app).

Registro automático da entrada e saída das motos no pátio.

Setorização dinâmica que aloca motos ao setor ideal conforme regras configuráveis (tipo, capacidade e prioridade).

Visualização da ocupação do pátio e histórico de movimentações.

API RESTful para integração com aplicações web e mobile.

Tecnologias Utilizadas
Java 17

Spring Boot

Spring Data JPA

Banco de dados relacional (exemplo: PostgreSQL/Oracle)

Maven

Swagger para documentação da API

Estrutura do Projeto
entity/ — classes que representam as entidades (Moto, Operador, Setor, EntradaSaida).

repository/ — interfaces para acesso a dados via Spring Data JPA.

service/ — regras de negócio e lógica da aplicação.

controller/ — endpoints REST da API.

config/ — configuração geral do Spring Boot e do Swagger.

Pré-requisitos
JDK 17 ou superior instalado

Maven instalado

Banco de dados PostgreSQL ou Oracle configurado e rodando

IDE de sua preferência (IntelliJ IDEA, Eclipse, VSCode, etc.)

Como Rodar o Projeto
1. Clonar o repositório
bash
Copiar
Editar
git clone https://github.com/seu-usuario/seu-projeto-patio.git
cd seu-projeto-patio
2. Configurar o banco de dados
Crie o banco (ex: patio_db) no PostgreSQL ou Oracle.

Configure as credenciais no arquivo src/main/resources/application.properties:

properties
Copiar
Editar
spring.datasource.url=jdbc:postgresql://localhost:5432/patio_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
3. Build e execução
bash
Copiar
Editar
mvn clean install
mvn spring-boot:run
4. Acessar a API
A API estará disponível em http://localhost:8080/

A documentação Swagger fica em http://localhost:8080/swagger-ui.html

Endpoints Principais
Método	URL	Descrição
POST	/operadores	Cadastrar operador
POST	/motos	Cadastrar moto
POST	/entrada-saida/entrada	Registrar entrada da moto
POST	/entrada-saida/saida	Registrar saída da moto
GET	/setores	Listar setores e ocupação
GET	/motos	Listar motos


 ALUNOS:
Caroline Souza do Amaral
Heitor Romero da Rocha
Gustavo de Souza Amorim
