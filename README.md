# Descrição
- Projetinho realizado para a última tarefa de laboratório de orientação a objetos em java que constitui na utilização do padrão MVC (Model-View-Controller) 
com uma interface (GUI) com java swing da qual manuseará um CRUD de criação de produtos que poderão ser salvos no banco de dados relacional PostgreSQL.

# Como rodar o projeto
- Para vizualizar a funcionalidade do sisteminha, apenas rode o main.

# Dependências
- Instalar o JDBC e importá-lo na pasta Libraries
![jdbc download](https://i.imgur.com/zN6AWRX.png)

![jdbc download](https://i.imgur.com/fiRjBTb.png)

- [JDBC Download](https://jdbc.postgresql.org/download.html)

- Vá no banco de dados e crie um DataBase com nome de alunos (coloquei a senha do meu postgreSql como 123), 
abra a aba de Schemas > public > Tables, em tables clique com o botão direito do mouse e selecione para criar
uma nova tabela, insira o nome da tabela como "products" em seguida vá na aba Columns e crie 4 itens com as 
seguintes configurações:

Name          DataType            Length/Precision  Scale   Not NULL?   Primary key?  Default
id            character varying                             true        true
nome          character varying                             true        false
valor         character varying                             true        false
quantidade    character varying                             true        false
