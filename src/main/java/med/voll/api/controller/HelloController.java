package med.voll.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // diz para o spring que a classe é um RestController
@RequestMapping("/hello") // diz o qual o mapeamento das rotas (requisi)
public class HelloController {

    @GetMapping
    public String olaMundo() {
        return "hello worlds";
    }

}
