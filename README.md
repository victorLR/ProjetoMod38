# projetoMod38

Projeto Java Web com JSF, controller, service, repository JPA, entidade mapeada e persistência no PostgreSQL.

## Estrutura

- Página JSF: `src/main/webapp/index.xhtml`
- Controller: `br.com.projetomod38.controller.ClienteController`
- Service: `br.com.projetomod38.service.ClienteService`
- Repository: `br.com.projetomod38.repository.ClienteRepository`
- Entidade: `br.com.projetomod38.entity.Cliente`
- JPA: `src/main/resources/META-INF/persistence.xml`

## Banco PostgreSQL

Crie o banco abaixo antes de subir o projeto:

```sql
CREATE DATABASE "projetoMod38";
```

Configuração padrão usada:

- banco: `projetoMod38`
- usuário: `postgres`
- senha: `postgres`
- porta: `5432`

Se seu PostgreSQL estiver diferente, altere o `persistence.xml`.

## Como rodar

1. Importe como projeto Maven.
2. Configure um servidor compatível com Jakarta EE 10 ou Tomcat com as dependências do projeto.
3. Rode o projeto e acesse `index.xhtml`.
