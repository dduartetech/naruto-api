# 🍃 Naruto API

API REST desenvolvida em Java com Spring Boot para gerenciamento de dados do universo Naruto — ninjas, clãs, aldeias e jutsus.

## 🛠️ Tecnologias

- Java 17
- Spring Boot 4.1.0
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Lombok
- Springdoc OpenAPI (Swagger)
- Maven

## 📦 Entidades

- **Aldeia** — aldeias do mundo ninja (ex: Konoha, Suna)
- **Clã** — clãs vinculados a uma aldeia (ex: Uchiha, Hyuga)
- **Ninja** — ninjas com rank, chakra e vínculo com aldeia e clã
- **Jutsu** — técnicas com tipo e rank
- **NinjaJutsu** — relação entre ninjas e seus jutsus

## 🚀 Como rodar localmente

### Pré-requisitos

- Java 17+
- PostgreSQL
- Maven

### Configuração

1. Clone o repositório:
```bash
git clone https://github.com/dduartetech/naruto-api.git
```

2. Crie o banco de dados no PostgreSQL:
```sql
CREATE DATABASE db_naruto;
```

3. Configure as credenciais no `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/db_naruto
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

4. Rode o projeto:
```bash
./mvnw spring-boot:run
```

## 📄 Documentação

Com o projeto rodando, acesse o Swagger em:

```
http://localhost:8080/swagger-ui.html
```

## 🔗 Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /aldeia | Cadastrar aldeia |
| GET | /aldeia | Listar aldeias |
| GET | /aldeia/{id} | Buscar aldeia por id |
| PUT | /aldeia/{id} | Atualizar aldeia |
| DELETE | /aldeia/{id} | Deletar aldeia |
| POST | /cla | Cadastrar clã |
| GET | /cla | Listar clãs |
| GET | /cla/{id} | Buscar clã por id |
| PUT | /cla/{id} | Atualizar clã |
| DELETE | /cla/{id} | Deletar clã |
| POST | /ninja | Cadastrar ninja |
| GET | /ninja | Listar ninjas |
| GET | /ninja/{id} | Buscar ninja por id |
| PUT | /ninja/{id} | Atualizar ninja |
| DELETE | /ninja/{id} | Desativar ninja (soft delete) |
| POST | /jutsu | Cadastrar jutsu |
| GET | /jutsu | Listar jutsus |
| GET | /jutsu/{id} | Buscar jutsu por id |
| PUT | /jutsu/{id} | Atualizar jutsu |
| DELETE | /jutsu/{id} | Deletar jutsu |
| POST | /ninja-jutsu | Atribuir jutsu a ninja |
| GET | /ninja-jutsu | Listar relações ninja-jutsu |
| GET | /ninja-jutsu/{id} | Buscar por id |
| DELETE | /ninja-jutsu/{id} | Remover jutsu de ninja |

## 👤 Autor

Diego Duarte — [GitHub](https://github.com/dduartetech) • [LinkedIn](https://www.linkedin.com/in/diego-duarte-7797a3369/)
