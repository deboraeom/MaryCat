"# MaryCat"
 
<p> Esse é um api para gestão da catequese, as tecnologias utilizadas são Java SpringBoot e banco de dados Mysql </p><br>
<p> It's a catechism management api. Java, SpringBoot and Mysql are the technologys used<p><br>

<p> Nele é possível/It's possible control:</p><br>

<p> 1.0 Paróquia/Parish </p><br>

 <ul>  <li>.Os campos de paróquia são/The parish fields are:<br>
      Long id, String name,String cnpj.</li><br>

   <li>Para criar/Create:      
      http://localhost:8080/parishes
      É necessário enviar um Json com os campos name e email preenchidos. On body, is necessary to be send a Json with fields name and email </li>

  <li> Para consultar/ Find:      
      http://localhost:8080/parishes/{id}</li>
  
 <li>   Para consultar todas/ Find all:
      http://localhost:8080/parishes

 <li> Para consultar por nome ou cnpj/ Find by name or cnpj:
      http://localhost:8080/parishes/findList?search="the search"</li>

  <li> Para Atualizar/ Update:<br>
       http://localhost:8080/parishes<br>
        É necessário enviar um Json com todos os campos preenchidos. On body, is necessary to be send a Json with all field.</li><br>

  <li> Para deletar/ to delete<br>
       http://localhost:8080/parishes/{id}</li><br>

</ul>

<p> 2.0 Igreja/Church </p><br>
 <ul>
  <li>Os campos de Igreja são/The Igreja fields are:<br>
     Long id, String name,String email,String phone_number, type type, Parish parishes_id, ChurchAddress address.<br>
   Os campos de  Endereço do Usuário são/The UserAddress fields are:<br>
      Long id,String addressesNumber,String street,String neighborhood, String city, String uf.</li><br>

  <li>Para criar/Create: <br>     
      http://localhost:8080/churches/<br>
      É necessário enviar um Json com os campos name, email, phone_number, type and parishes_id  preenchidos, e se for eviado o endereço, exceto id, todos os campos tem que ser enviados. On body, is necessary to be send a Json with fields name, email, phone_number, type and parishes_id.
                                                                                                                                                                                            If UserAdress is send, without id from ChurchAddress, all fields are necessary. </li><br>

  <li>Para consultar/ Find:  <br>    
     http://localhost:8080/churches/{id}</li><br>
  
  <li>Para consultar todas/ Find all:<br>
     http://localhost:8080/churches/</li><br>

<li> Para consultar por nome ou cnpj/ Find by name or cnpj:<br>
      http://localhost:8080/churches/findList?search="the search"</li><br>

 <li>Para Atualizar/ Update:<br>

       http://localhost:8080/churches<br>
        É necessário enviar um Json com os campos id, name, email, phone_number, type and parishes_id  preenchidos. On body, is necessary to be send a Json with fields id, name, email, phone_number, type and parishes_id. </li><br>

  <li> Para deletar/ to delete<br>
       http://localhost:8080/churches/{id}</li><br>
</ul>
<p> 3.0 Usuário/User </p><br>
 <ul>
  <li>Os campos de Usuário são/The User fields are:<br>
     Long id, String name,String password, String cellphoneNumber, String email, String password, String phoneNumber, String cellPhone, UserAddress address.<br>
   Os campos de  Endereço do Usuário são/The UserAddress fields are:<br>
     Long id,String addressesNumber,String street,String neighborhood, String city, String uf.</li><br>


  <li>Para criar/Create:<br>      
      http://localhost:8080/users/<br>
      É necessário enviar um Json com os campos name, email,password  preenchidos e se for eviado o endereço, exceto id, todos os campos tem que ser enviados. On body, is necessary to be send a Json with fields name, email, password. 
                                                                                                                                                                If UserAdress is send, without id from UserAddress, all fields are necessary.</li><br>
  <li>Para consultar/ Find:  <br>    
     http://localhost:8080/users/{id}</li><br>
  
 <li>  Para consultar todas/ Find all:<br>
     http://localhost:8080/users/</li><br>

<li> Para consultar por nome ou cnpj/ Find by name or email or birthdays between dates:<br>
      http://localhost:8080/users/findList?email="email"&name="name"&andress="andress"&beginDate="beginDate"&endDate="endDate"</li><br>

 <li>  Para Atualizar/ Update:<br>
       http://localhost:8080/users/<br>
       É necessário enviar um Json com os campos id, name, email,password  preenchidos. On body, is necessary to be send a Json with fields id,name, email,password.</li><br>

  <li>  Para deletar/ to delete<br>
       http://localhost:8080/users/{id}</li><br>
</ul><br>
<p> 4.0 ChurchHasUser </p><br>
Em andamento<br>


<p> 5.0 Cathechist </p><br>
<p> 6.0 Catechumen </p><br>
<p> 7.0 Class </p><br>
<p> 8.0 MissedClass  </p><br>
<p> 9.0 AuditCatechumensAction </p><br>

