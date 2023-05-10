package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.consulta.cancelamento.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);

}
