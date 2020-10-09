# spring-client-crud
Spring Boot Rest API for CRUD operations on simple clients.

# Back-end
A aplicação, a ser desenvolvida em Java, deverá expor uma API de cadastro, alteração, remoção e consulta de pessoas com as seguintes informações:
  Nome - obrigatório
  Sexo
  E-mail - não obrigatório, deve ser validado caso preenchido
  Data de Nascimento - obrigatório, deve ser validada
  Naturalidade
  Nacionalidade
  CPF - obrigatório, deve ser validado (formato e não pode haver dois cadastros com mesmo cpf)
Obs: a data de cadastro e atualização dos dados devem ser armazenados.

# Código fonte
A aplicação deverá possuir um endpoint /source acessível sem autenticação via HTTP GET que deverá retornar o link do projeto no github com o código fonte do projeto desenvolvido.
