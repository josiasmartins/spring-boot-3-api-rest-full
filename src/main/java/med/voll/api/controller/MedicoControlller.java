package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoControlller {

    @PostMapping
    // @RequestBody: pega o corpo da requisição
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        System.out.println(dados.nome());
    }

}
