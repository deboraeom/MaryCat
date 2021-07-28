  
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

  



