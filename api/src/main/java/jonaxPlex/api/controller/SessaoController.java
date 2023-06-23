package jonaxPlex.api.controller;



import jakarta.validation.Valid;
import jonaxPlex.api.domain.filme.Filme;
import jonaxPlex.api.domain.sala.Sala;
import jonaxPlex.api.domain.sessao.DadosCadastrarSessao;
import jonaxPlex.api.domain.sessao.Sessao;
import jonaxPlex.api.domain.sessao.SessaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sessoes")
public class SessaoController {

    @Autowired
    private SessaoRepository repository;

    @Autowired
    private FilmeController filmeController;

    @Autowired
    private SalaController salaController;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastrarSessao dados){
        Filme filme = filmeController.buscarPorId(dados.id_filme());
        Sala sala = salaController.buscarPorId(dados.id_sala());
        if(!repository.existsByDataAndHoraAndSalaId(dados.data(), dados.hora(), sala.getId())){
            repository.save(new Sessao(dados.data(), dados.hora(), filme, sala));
            return ResponseEntity.ok("Cadastrada");
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe uma sessão nessa data e hora");
        }

    }

}
