# Sistema de Controle de Pátio - Spring Boot

Este projeto consiste em uma API RESTful desenvolvida com Spring Boot para controle de entrada e saída de veículos (carros e motos) em pátios. O sistema realiza identificação de veículos via QR Code ou RFID e oferece funcionalidades para cadastro, listagem e gerenciamento de vagas, veículos e movimentações.

## Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Banco de Dados H2 (pode ser substituído por Oracle/PostgreSQL)
* Swagger UI (Documentação interativa da API)

## Funcionalidades

* Cadastro de veículos (carros e motos)
* Cadastro de vagas
* Registro de entradas e saídas
* Validação de disponibilidade de vaga
* Mapeamento dinâmico do pátio
* Setorização automática baseada em tipo de veículo

## Estrutura do Projeto

* `VeiculoController.java` - Controlador de veículos
* `VagaController.java` - Controlador de vagas
* `EntradaSaidaController.java` - Controlador de movimentações
* `Veiculo`, `Vaga`, `EntradaSaida` - Entidades principais
* `VeiculoService`, `VagaService`, `EntradaSaidaService` - Regras de negócio
* `VeiculoRepository`, etc. - Acesso a dados

## Como Executar o Projeto

### Pré-requisitos

* Java 17 ou superior
* Maven ou IDE como IntelliJ/Eclipse

### Passos:

1. Clone o repositório:

   ```bash
   git clone https://github.com/seuusuario/nome-do-repositorio.git
   ```

2. Acesse a pasta do projeto:

   ```bash
   cd nome-do-repositorio
   ```

3. Execute o projeto com sua IDE ou pelo terminal:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse o Swagger para testar a API:
   [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Alunos

* Caroline Souza do Amaral
* Heitor Romero da Rocha
* Gustavo de Souza Amorim

