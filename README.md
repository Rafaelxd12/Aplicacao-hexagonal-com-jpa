# Aplicacao Hexagonal com JPA

API REST de cadastro e consulta de herois usando Spring Boot, arquitetura hexagonal e persistencia com MySQL.

## Stack
- Java 21
- Spring Boot 3.5.11
- Spring Web
- Spring Data JPA
- MySQL
- Maven

## Arquitetura (Hexagonal)

Fluxo principal:

Controller -> UseCase (porta in) -> Service -> RepositoryPort (porta out) -> Adapter JPA/MySQL -> Banco

Pacotes principais em `exemplo-hexagonal/src/main/java/sptech/school/exemplo_hexagonal`:
- `domain/model`: entidade de dominio (`Heroi`)
- `application/port/in`: casos de uso (`HeroiUseCase`)
- `application/port/out`: contrato de persistencia (`HeroiRepositoryPort`)
- `application/service`: implementacao dos casos de uso (`HeroiService`)
- `adapters/in/web`: API REST (`HeroiController`, DTOs e mapper)
- `adapters/out/persistence`: adaptador de saida JPA/MySQL

## Como rodar

1. Entre na pasta do projeto Spring:

```bash
cd exemplo-hexagonal
```

2. Crie o banco e dados iniciais (opcional, mas recomendado):

```sql
source mysql-init.sql
```

3. Configure credenciais locais em `src/main/resources/application.properties`.
   Exemplo de base: `src/main/resources/application.properties-template`.

4. Execute a aplicacao:

```bash
./mvnw spring-boot:run
```

No Windows:

```bat
mvnw.cmd spring-boot:run
```

## Endpoints

Base URL: `http://localhost:8080/herois`

- `GET /herois` -> lista todos
- `GET /herois/{id}` -> busca por id
- `POST /herois` -> cadastra
- `PUT /herois/{id}` -> atualiza
- `DELETE /herois/{id}` -> remove
- `GET /herois/forca?maior=90` -> filtra por forca
- `GET /herois/filtro?busca=man` -> filtra por nome

Exemplo de payload para POST/PUT:

```json
{
  "nome": "Diana",
  "forca": 95,
  "arma": "Laco da Verdade",
  "temCapa": false
}
```

## Boas praticas de configuracao

- Nao versionar segredos no Git.
- Versionar apenas template de configuracao (`application.properties-template`).
- Manter `application.properties` no `.gitignore`.