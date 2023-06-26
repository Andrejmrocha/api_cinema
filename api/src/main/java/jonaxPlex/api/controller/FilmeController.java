package jonaxPlex.api.controller;

import jakarta.validation.Valid;
import jonaxPlex.api.domain.filme.*;
import jonaxPlex.api.domain.sessao.DadosListagemSessao;
import jonaxPlex.api.domain.sessao.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @Autowired
    private SessaoRepository sessaoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastrarFilme dados, UriComponentsBuilder uriBuilder){
        var filme = new Filme(dados);
        repository.save(filme);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(filme.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalharFilme(filme));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizarFilme dados){
        var filme = repository.getReferenceById(dados.id());
        filme.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalharFilme(filme));

    }

    @GetMapping
    public Page<DadosListagemFilme> listarFilmes(@PageableDefault(size = 10, sort = {"ano"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemFilme::new);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var filme = repository.getReferenceById(id);
        filme.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var filme = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalharFilme(filme));
    }

    public Filme buscarPorId(Long id){
        return repository.getReferenceById(id);
    }

    @GetMapping("{idFilme}/sessoes")
    public List<DadosListagemSessao> buscarSessoes(@PathVariable Long idFilme) {

        return sessaoRepository.findByFilmeId(idFilme).stream().map(DadosListagemSessao::new).toList();
    }
}
