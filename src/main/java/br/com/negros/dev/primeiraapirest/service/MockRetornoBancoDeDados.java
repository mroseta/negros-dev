package br.com.negros.dev.primeiraapirest.service;

import br.com.negros.dev.primeiraapirest.domain.Cliente;
import br.com.negros.dev.primeiraapirest.domain.Conta;
import org.springframework.stereotype.Service;

@Service
public class MockRetornoBancoDeDados {

    public Conta criar(Conta conta) {

        if(conta != null){
            Conta c = new Conta();
            c.setIdConta("1007");
            return c;
        }

        return null;
    }

    public Conta consultar(String idConta) {


        Conta conta = populaConta();

        if (idConta.equals(conta.getIdConta())){
            return conta;
    }
        return null;
    }

    public Conta alterar(String idConta, Conta contaRequest) {

        Conta c = new Conta();

        c.setIdConta(idConta);
        c.setAgencia(contaRequest.getAgencia());
        c.setNumeroConta(contaRequest.getNumeroConta());
        c.setDigito(contaRequest.getDigito());
        c.setCliente(contaRequest.getCliente());


        return c;

    }

    public void deletar(String idConta) {
    }

    private Conta populaConta() {

        Conta c = new Conta();
        Cliente cliente = new Cliente();

        cliente.setNome("Matheus");
        cliente.setCpf("999.999.999-99");
        cliente.setEmail("matheus@matheus.com.br");

        c.setIdConta("1007");
        c.setAgencia("1234");
        c.setNumeroConta("9876543");
        c.setDigito("2");
        c.setCliente(cliente);

        return c;

    }



}
