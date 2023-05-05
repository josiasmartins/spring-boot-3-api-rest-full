# API RestFull with spring boot 3

## Spring Boot 3: desenvolva uma API Rest em Java

------

### POST
* nome: string -> nome do medico  **`obrigatoria`**
* email: string -> email do medico  **`obrigatoria`**
* crm: string -> ?? **`obrigatoria`** **`obs:permitido entre 4 à 6 números`**
* especialidade -> tipo de especialidade **`"CARDIOLOGIA" | "ORTOPEDIA" | "GINECOLOGIA" | "DERMATOLOGIA"`**  **`obrigatoria`**
* telefone: string -> telefone do medico **`obrigatoria`**
* endereco: Object { logradouro: string  **`obrigatoria`** , bairro: string **`obrigatoria`** , cep: string **`obrigatoria`** , cidade: string **`obrigatoria`** , uf: string **`obrigatoria`** ", complemento: string **`opcional`** , numero:  **`opcional`**  } 

#### Exemplos de payload (body)
{<br>
    "nome": "hillary", <br>
    "email": "hillary@voll.med",<br>
    "crm": "12221",<br>
    "especialidade": "CARDIOLOGIA",<br>
    "telefone": "61999998888",<br>
    "endereco": {<br>
        "logradouro": "rua 1",<br>
        "bairro": "bairro",<br>
        "cep": "12345678",<br>
        "cidade": "Brasilia",<br>
        "uf": "DF"<br>
    }<br>
}
----------------
### GET - coming soon

----

### PUT - coming soon

---

### DELETE - coming soon

----

## Demo

----

[]()

##  Toolls and Tecnology
 - Java 17
 - Spring boot 3
 - flyway
 - mysql driver 
 - Validator (spring)
 - spring data  (data jpa)
 - devTools (spring boot)
 - lombok
