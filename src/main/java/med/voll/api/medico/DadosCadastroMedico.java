package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

// usou o padrao DTO (Data Transfer Object) - somente uma classe que contém somente os campos que desejamos ou devolver
public record DadosCadastroMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
