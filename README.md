# Projeto Sistema AutoEscola 

API REST desenvolvida com **Java e Spring Boot** para gerenciamento de instrutores de uma autoescola.

O projeto aplica conceitos modernos de desenvolvimento back-end, como arquitetura em camadas, JPA/Hibernate, Soft Delete e boas práticas REST.

---

## 📌 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate (ORM)
- Banco de Dados Relacional
- Maven
- Lombok
- Jakarta Persistence API (JPA)

---

## 🏗 Arquitetura do Projeto

O projeto segue uma arquitetura em camadas:
controller → domain → repository → banco de dados


### 🔹 Controller
Responsável por expor os endpoints REST e receber as requisições HTTP.

### 🔹 Domain
Contém as entidades JPA e regras de negócio da aplicação.

### 🔹 Repository
Responsável pela comunicação com o banco de dados através do Spring Data JPA.

---

## 🚀 Funcionalidades

### ✅ Cadastro de Instrutor
Permite cadastrar um novo instrutor com:
- Nome
- Email
- Telefone
- CNH
- Especialidade
- Endereço

### ✅ Atualização de Instrutor
Atualização parcial dos dados do instrutor.

### ✅ Listagem de Instrutores
Lista apenas instrutores ativos.

### ✅ Soft Delete (Padrão de Mercado)
Ao excluir um instrutor, o registro não é removido do banco.  
O sistema apenas altera o campo `ativo` para `false`, garantindo:

- Segurança dos dados  
- Manutenção de histórico  
- Integridade relacional  
- Possibilidade de recuperação futura  

---

## 📡 Endpoints

### 🔹 Criar Instrutor
POST /instrutores

### 🔹 Listar Instrutores Ativos
GET /instrutores


### 🔹 Atualizar Instrutor
PUT /instrutores


### 🔹 Excluir Instrutor (Soft Delete)
DELETE /instrutores/{id}

Retorno:
204 No Content


---

## ▶️ Como Executar o Projeto

### 1️⃣ Clonar o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

2️⃣ Acessar a pasta do projeto
cd nome-do-projeto

3️⃣ Executar a aplicação
mvn spring-boot:run

A API estará disponível em:
http://localhost:8080

---

### 🧠 Conceitos Aplicados

- RESTful API
- Injeção de Dependência (@Autowired)
- Controle de Transações com @Transactional
- Mapeamento Objeto-Relacional (ORM)
- Uso de DTOs
- Soft Delete
- Enum persistido como String
- @Embedded para composição de Endereço

---

### 🎯 Objetivo do Projeto

- Consolidar conhecimentos em Spring Boot
- Aplicar boas práticas utilizadas no mercado
- Compreender o funcionamento do JPA/Hibernate
- Construir uma API REST estruturada e organizada

Por: Gabrielly F. Nascimento - Curso Spring Boot SENAI Tatuapé
