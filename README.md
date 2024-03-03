# Rocket Cadastro

Este é um projeto de serviço de cadastro de clientes chamado Rocket Cadastro. O serviço oferece operações básicas para gerenciamento de cadastros de clientes, incluindo salvar, consultar e listar.

## Funcionalidades

- **Salvar Cadastro:** Endpoint para salvar um novo cadastro de cliente.
- **Consultar por CPF:** Endpoint para buscar um cadastro por CPF.
- **Listar todos os Cadastros:** Endpoint para listar todos os cadastros de clientes.

## Tecnologias Utilizadas

- Java 17 
- Spring Boot
- Spring Data JPA
- Spring Web
- RESTful API
- Redis

## Como Utilizar

1. **Clonar o Repositório:**
git clone (https://github.com/seu-usuario/rocket-cadastro.git)

2. **Configurar o Banco de Dados:**

- Configure as propriedades do banco de dados no arquivo `application.properties`.

3. **Executar o Projeto:**

- Execute o projeto Spring Boot. A aplicação estará disponível em `http://localhost:8080`.

4. **Endpoints Disponíveis:**

- **Salvar Cadastro:** 
  - Método: POST
  - URL: `http://localhost:8080/rocket/save`
  - Corpo da requisição: JSON contendo os dados do cadastro

- **Consultar por CPF:**
  - Método: GET
  - URL: `http://localhost:8080/rocket/consultar/{cpf}`
  - Parâmetros: `cpf` (CPF do cliente a ser consultado)

- **Listar todos os Cadastros:**
  - Método: GET
  - URL: `http://localhost:8080/rocket/consulta/all`

5. **Exemplo de Corpo de Requisição para Salvar Cadastro:**

```json
{
  "nomeCompleto": "Nome Sobrenome",
  "dataNascimento": "YYYY-MM-DD",
  "cpf": "123.456.789-00",
  "nomeMae": "Nome da Mãe",
  "fotoRosto": "URL da foto do rosto",
  "fotoDocumento": "URL da foto do documento",
  "fotoComprovante": "URL da foto do comprovante",
  "senha": "senha123"
}


