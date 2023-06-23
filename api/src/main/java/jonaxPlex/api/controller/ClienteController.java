package jonaxPlex.api.controller;

import jakarta.validation.Valid;
import jonaxPlex.api.domain.cliente.Cliente;
import jonaxPlex.api.domain.cliente.ClienteRepository;
import jonaxPlex.api.domain.cliente.DadosCadastrarCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastrarCliente dados){
        repository.save(new Cliente(dados.nome(), dados.idade(), dados.email(), dados.telefone()));
    }
}
