# spring-client-crud

Spring Boot Rest API for CRUD operations on simple clients.

Execução: - Git Clone - (backend) mvnw clean package -Dmaven.test.skip=true - docker-compose up
Necessário Docker instalado.

Há 2 hubs docker. (Há também o docker default do mysql que está configurado no arquivo docker-compose.yml).
- BackEnd: https://hub.docker.com/repository/docker/dssschiramm/spring-client-crud-backend
- FrontEnd: https://hub.docker.com/repository/docker/dssschiramm/spring-client-crud-frontend

# Back-end - OK

A aplicação, a ser desenvolvida em Java, deverá expor uma API de cadastro, alteração, remoção e consulta de pessoas com as seguintes informações:
Nome - obrigatório
Sexo
E-mail - não obrigatório, deve ser validado caso preenchido
Data de Nascimento - obrigatório, deve ser validada
Naturalidade
Nacionalidade
CPF - obrigatório, deve ser validado (formato e não pode haver dois cadastros com mesmo cpf)
Obs: a data de cadastro e atualização dos dados devem ser armazenados.

# Front-end - OK

A aplicação deverá ser acessível via navegador e possuir uma tela com formulário. Não há restrição em relação à tecnologia para o desenvolvimento do frontend.

# Código fonte - OK

A aplicação deverá possuir um endpoint /source acessível sem autenticação via HTTP GET que deverá retornar o link do projeto no github com o código fonte do projeto desenvolvido.
O projeto deverá utilizar as versões mais recentes das tecnologias/frameworks selecionados.

# Falta

-   O projeto deverá ter testes unitários da aplicação.

# Extras

-   A aplicação rodando em algum ambiente em nuvem.
-   Teste de integração da API em linguagem de sua preferência (Damos importância para pirâmide de testes)
-   A API desenvolvida em REST, seguindo o modelo de maturidade de Richardson ou utilizando GraphQL.
-   A API deverá conter documentação executável que poderá ser utilizada durante seu desenvolvimento. (Utilizar swagger)
-   Integração com OAuth 2 Google (https://developers.google.com/identity/protocols/OAuth2)
-   Implementar Chat entre as pessoas que estão na aplicação
-   Versão 2 da API que deve incluir endereço da pessoa como dado obrigatório. Versão 1 deve continuar funcionando.

# Useful commands

-   mvnw clean package -Dmaven.test.skip=true
-   mvnw spring-boot:build-image -Dmaven.test.skip=true

-   docker-compose up --build --remove-orphans
-   docker-compose down -v

-   docker login
-   docker-compose build --pull
-   docker-compose push
