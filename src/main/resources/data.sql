select * from author;
select * from book;

INSERT INTO book(id,isbn,quantity,rating,title) values
((UUID_TO_BIN(UUID())), '9788373272736','10',4,'Ballady i romanse'),
((UUID_TO_BIN(UUID())), '9788365272736','5',1,'Bastion'),
((UUID_TO_BIN(UUID())), '9788373272211','2',2,'Carrie'),
((UUID_TO_BIN(UUID())), '9788373272894','8',3,'Pan Tadeusz'),
((UUID_TO_BIN(UUID())), '9788373272788','3',5,'Dziady');

INSERT INTO author(id, name,date_of_birth,rating,description) values
((UUID_TO_BIN(UUID())), 'Adam Mickiewicz','1798-12-24',3.9,'Adam Mickiewicz uważany jest za jednago z największy poetów. Swoje działa tworzył podczas zaborów.'),
((UUID_TO_BIN(UUID())), 'Remigiusz Mróz','1987-01-15',4.0,'Polski pisarz, autor powieści kryminalnych oraz cyklu publicystycznego „Kurs pisania”.'),
((UUID_TO_BIN(UUID())), 'J.K. Rowling','1965-07-31',4.5,'Autorka kultowej serii opowaidań przygodach Harryego Pottera'),
((UUID_TO_BIN(UUID())), 'Stephen Edwin King ','1947-09-21',4.2,'Amerykański pisarz specjalizujący się w literaturze grozy. '),
((UUID_TO_BIN(UUID())), 'Elżbieta Adamska','1968-05-11',5,'Autorka najlepszej książki na świecie');



# INSERT INTO users(id,email,username)value
#     ((UUID_TO_BIN(UUID())),'ala@ma.kota', 'alamakota','Tomasz');



# INSERT INTO users(id,email,username) values
#     ((UUID_TO_BIN(UUID())),'ala@ma.kota','Tomasz');

INSERT INTO users(id, email, password,  username) value
((UUID_TO_BIN(UUID())),'ala@ma.kta','alamakota','Bomasz');

INSERT INTO user_roles(user_id, role_id) values

INSERT INTO user_roles(user_id, role_id)value
    ((select id from users where username ='Tomasz'),(select id from roles where name ='ADMIN'));