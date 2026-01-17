## Encurtador de Links – Spring Boot

API REST desenvolvida em Java com Spring Boot para encurtamento e redirecionamento de URLs, aplicando boas práticas de arquitetura em camadas e conceitos fundamentais de backend.

O projeto permite criar links curtos, armazená-los em banco de dados e realizar redirecionamentos HTTP a partir do código gerado.

---

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- Jackson (JSON)
- REST API

---

## Arquitetura

O projeto segue uma arquitetura em camadas:

- **Controller**: expõe os endpoints REST
- **Service**: contém a lógica de negócio
- **Repository**: responsável pela persistência dos dados (JPA)
- **Model**: representa a entidade de domínio
- **DTO**: responsável por receber e validar dados da requisição

Essa separação facilita manutenção, testes e evolução do projeto.

---

## Funcionalidades

- Criar um link encurtado a partir de uma URL original
- Listar todos os links cadastrados
- Redirecionar automaticamente para a URL original usando o código curto
- Retornar códigos HTTP adequados (201, 303, 404, etc.)

---

## Criar um link encurtado

### Endpoint
Adicionar 

POST
json
{
  "originalUrl": "http://exemp\lo.com"
}

Resposta
json
{
    "id": 1,
    "originalLink": "http://exemp\lo.com",
    "shortLink": "12345678290"
}

GET
/links
Sem argumentos retorna todos os links cadastrads

/links/{codigo curto}
Redireciona para o link original

Projeto para estudo 
