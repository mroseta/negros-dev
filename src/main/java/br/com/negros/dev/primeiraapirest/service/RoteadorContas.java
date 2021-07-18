package br.com.negros.dev.primeiraapirest.service;

import br.com.negros.dev.primeiraapirest.domain.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoteadorContas {

    @Autowired
    MockRetornoBancoDeDados mock;

    public Conta criar(Conta conta, String seuHeader) {

        //implementação de cadastro no banco de dados
        Conta c = mock.criar(conta);

        return c;
    }

    public Conta consultar(String idConta, String seuHeader) {

        //implementação de consulta no banco de dados
        return mock.consultar(idConta);

    }

    public Conta alterarDados(String idConta, Conta contaRequest, String seuHeader) {

        //implementação de consulta no banco de dados
        return mock.alterar(idConta, contaRequest);

    }

    public void deletar(String idConta, String seuHeader) {

        //implementação de delete no banco de dados
        mock.deletar(idConta);

    }
}
