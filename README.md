# Engetec App
Desenvolvimento do novo aplicativo da Engetec para o estágio voluntário na Fatec Zona Leste

Node version: 18.15.0 </br>
Npm verion: 8.4.0 </br>
Angular version: 16.2.0

# Para rodar o FrontEnd:

## Caso não possua os requisitos, instale-os:

*  [NodeJS](https://nodejs.org/dist/v18.15.0/) </br>
*  Angular: Após instalar o Node, utilize o seguinte comando no cmd: `npm i -g @angular/cli@16.2.0`

## Depois de clonar o projeto:

Abra a pasta da aplicação angular (engetec-app/frontend/engetec-app) no cmd e utilize o seguinte comando: `npm i`

# Para rodar o BackEnd: 

JDK17 </br>
Criação do banco de dados (engetec) </br>
Criações das variáveis de ambiente mapeadas no 'application.properties':
*  `DB_USER` que representa o usuário do banco de dados
*  `DB_PASSWORD` que representa a senha do usuário do banco de dados
*  `DB_URL` que representa a url do banco do banco de dados e deve estar da seguinte maneira `jdbc:mysql://localhost:{PORT}/{DB_NAME}` (invés de '{PORT}' coloque o número da porta e invés de '{DB_NAME}' coloque o nome do banco de dados
