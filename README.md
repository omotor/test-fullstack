# Test Full Stack

Módulos:

 - test (Projeto parent)
 - test-api (Projeto de api, todos os resources deverão ficar nesse projeto)
 - test-main (Projeto para start da aplicação baseada no spring boot)
 - test-model (Projeto de model, todos os pojos e entidades deverão ficar nesse projeto)
 - test-service (Projeto de services, todos os services deverão ficar nesse projeto)
 - test-ui (Projeto de interface, todas as interfaces deverão ficar na pasta static dentro desse projeto)
 - test-config (Projeto de configuração, todas as configurações do projeto deverá ficar nesse projeto)

Classe para start do projeto: **com.test.main.TestMain**
Url para acesso: **http://localhost:5000**

O objetivo do test é mostrar suas habilidades full stack, para isso as seguintes tarefas deverão ser concluídas.

Backend:

 - Criar um modelo de dados com uma tabela de cadastro de usuários que contenha os seguintes campos:
	 - Id
	 - Nome (Obrigatório)
	 - Email (Obrigatório e válido)
	 - Telefone (Obrigatório)
	 - Sexo (Obrigatório)


----------
- Configurar a conexão com o MySql no módulo test-config. O módulo test-config não existe no projeto, crie um novo módulo para isso.
- O pool de conexão deverá ser configurado com o HikariCP(https://github.com/brettwooldridge/HikariCP)
- Configure os repositórios de acesso a dados com o Spring Data JPA
- Crie services para CRUD dessa tabela


----------
- Disponibilize via api rest e com retorno em JSON os seguintes métodos
	- endpoint POST /api/user 
		- Recebe todos os parâmetros obrigatórios para criar um novo usuário
	- endpoint GET /api/user
		- Lista todos os usuários
	- endpoint GET /api/user/{id}
		- Recupera um usuário por id
	- endpoint DELETE /api/user/{id}
		- Remove um usuário por id
	- endpoint PUT /api/user/{id}
		- Edita um usuário por id com todos os campos obrigatórios e que devem ser editados


----------

Frontend:

- No módulo test-ui crie as seguintes telas
	- url: /#/user/
		- Página que lista todos os usuários cadastrados consumindo a api
	- url: /#/user/add
		- Página para inserir um usuário consumindo a api
	- url: /#/user/{id}
		- Página para visualizar um usuário por id e edita-lo consumindo a api
	- Deverá ser implementado uma ação para remover um usuário por id consumindo a api

- No final do desenvolvimento do frontend, deverá ser criado com o gulp uma task para minificar o css e javascript


----------

Para finalizar o processo, gere um pull-request para que possamos analisar.

Boa Sorte!!!

 