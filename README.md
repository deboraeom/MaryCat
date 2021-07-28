"# MaryCat"
 
<p> Esse é um api para gestão da catequese, as tecnologias utilizadas são Java SpringBoot e banco de dados Mysql </p>
<p> It's a catechism management api. Java, SpringBoot and Mysql are the technologys used<p>

<p> Nele é possível/It's possible control:</p>

<p> 1.0 Paróquia/Parish </p>

  .Os campos de paróquia são/The parish fields are:
     .Long id, String name,String cnpj.

  .Para criar/Create:      
     . http://localhost:8080/parishes
     . É necessário enviar um Json com os campos name e email preenchidos. On body, is necessary to be send a Json with fields name and email 

  . Para consultar/ Find:      
     .http://localhost:8080/parishes/{id}
  
  . Para consultar todas/ Find all:
      http://localhost:8080/parishes

. Para consultar por nome ou cnpj/ Find by name or cnpj:
      http://localhost:8080/parishes/findList?search="the search"

  . Para Atualizar/ Update:

       .http://localhost:8080/parishes
       . É necessário enviar um Json com todos os campos preenchidos. On body, is necessary to be send a Json with all field.

  . Para deletar/ to delete
       .http://localhost:8080/parishes/{id}

<p> 2.0 Igreja/Church </p>

  .Os campos de Igreja são/The Igreja fields are:
     .Long id, String name,String email,String phone_number, type type, Parish parishes_id, ChurchAddress address.
  .Os campos de  Endereço do Usuário são/The UserAddress fields are:
      .Long id,String addressesNumber,String street,String neighborhood, String city, String uf.

  .Para criar/Create:      
     . http://localhost:8080/churches/
     . É necessário enviar um Json com os campos name, email, phone_number, type and parishes_id  preenchidos, e se for eviado o endereço, exceto id, todos os campos tem que ser enviados. On body, is necessary to be send a Json with fields name, email, phone_number, type and parishes_id.
                                                                                                                                                                                            If UserAdress is send, without id from ChurchAddress, all fields are necessary. 

  . Para consultar/ Find:      
     .http://localhost:8080/churches/{id}
  
  . Para consultar todas/ Find all:
     http://localhost:8080/churches/

. Para consultar por nome ou cnpj/ Find by name or cnpj:
      http://localhost:8080/churches/findList?search="the search"

 . Para Atualizar/ Update:

       .http://localhost:8080/churches
       .  É necessário enviar um Json com os campos id, name, email, phone_number, type and parishes_id  preenchidos. On body, is necessary to be send a Json with fields id, name, email, phone_number, type and parishes_id. 

  . Para deletar/ to delete
       .http://localhost:8080/churches/{id}

<p> 3.0 Usuário/User </p>

  .Os campos de Usuário são/The User fields are:
     .Long id, String name,String password, String cellphoneNumber, String email, String password, String phoneNumber, String cellPhone, UserAddress address.
  .Os campos de  Endereço do Usuário são/The UserAddress fields are:
     .Long id,String addressesNumber,String street,String neighborhood, String city, String uf.


  .Para criar/Create:      
     . http://localhost:8080/users/
     . É necessário enviar um Json com os campos name, email,password  preenchidos e se for eviado o endereço, exceto id, todos os campos tem que ser enviados. On body, is necessary to be send a Json with fields name, email, password. 
                                                                                                                                                                If UserAdress is send, without id from UserAddress, all fields are necessary.
  . Para consultar/ Find:      
     .http://localhost:8080/users/{id}
  
  . Para consultar todas/ Find all:
     http://localhost:8080/users/

. Para consultar por nome ou cnpj/ Find by name or email or birthdays between dates:
      http://localhost:8080/users/findList?email="email"&name="name"&andress="andress"&beginDate="beginDate"&endDate="endDate"

 . Para Atualizar/ Update:

       .http://localhost:8080/users/
       .  É necessário enviar um Json com os campos id, name, email,password  preenchidos. On body, is necessary to be send a Json with fields id,name, email,password.

  . Para deletar/ to delete
       .http://localhost:8080/users/{id}

<p> 4.0 ChurchHasUser </p>
Em andamento


<p> 5.0 Cathechist </p>
<p> 6.0 Catechumen </p>
<p> 7.0 Class </p>
<p> 8.0 MissedClass  </p>
<p> 9.0 AuditCatechumensAction </p>

