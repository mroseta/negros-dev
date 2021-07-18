package br.com.negros.dev.primeiraapirest.controller;

import br.com.negros.dev.primeiraapirest.domain.Conta;
import br.com.negros.dev.primeiraapirest.service.RoteadorContas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContaController {

    @Autowired
    RoteadorContas roteadorContas;

    @PostMapping("/contas")
    public ResponseEntity<?> criaContaCliente (
        @RequestHeader(value= "seu_header", required = true) String seuHeader,
        @RequestBody Conta conta){

        Conta c = roteadorContas.criar(conta, seuHeader);
        return new ResponseEntity<>(c, HttpStatus.CREATED);

    }

    @GetMapping("/contas/{id_conta}")
    public ResponseEntity<?> consultaContaCliente (
            @RequestHeader(value="seu_header", required = true) String seuHeader,
            @PathVariable (value = "id_conta")String idConta){

        Conta conta = roteadorContas.consultar(idConta, seuHeader);

        return new ResponseEntity<>(conta, HttpStatus.OK);

    }

    @PutMapping("/contas/{id_conta}")
    public ResponseEntity<?> alteraContaCliente (
            @RequestHeader(value="seu_header", required = true) String seuHeader,
            @PathVariable (value = "id_conta")String idConta,
            @RequestBody Conta contaRequest){

        Conta conta = roteadorContas.alterarDados(idConta, contaRequest, seuHeader);

        return new ResponseEntity<>(conta, HttpStatus.OK);

    }

    @DeleteMapping("/contas/{id_conta}")
    public ResponseEntity<?> deletarContaCliente(
            @RequestHeader(value="seu_header", required = true) String seuHeader,
            @PathVariable (value = "id_conta")String idConta){

        roteadorContas.deletar(idConta, seuHeader);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
