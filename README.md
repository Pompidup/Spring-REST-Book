N'oubliez pas de changer la connection a la BDD application.properties et de créer la BDD dans Mysql :
CREATE DATABASE books;
USE books;
CREATE TABLE  book ( id int(6) unsigned auto_increment primary key, title varchar(200) not null, author varchar(200) not null, description varchar(5000) not null );

    Créer une BDD MySQL et initialiser un projet Spring communiquant avec celle-ci
    Créer une entité Book ayant pour attributs title, author et description
    Créer un BookRepository permettant de réaliser les 4 opérations CRUD + une opération de recherche par mot-clé contenu dans le titre ou la description
    Mettre en place un controller répondant aux critères REST
    Tester l'application dans Postman
    Envoyer le projet vers son dépôt distant et partager le lien en solution.

