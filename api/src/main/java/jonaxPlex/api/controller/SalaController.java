package jonaxPlex.api.controller;

import jonaxPlex.api.domain.sala.DadosCadastrarSala;
import jonaxPlex.api.domain.sala.DadosListagemSala;
import jonaxPlex.api.domain.sala.Sala;
import jonaxPlex.api.domain.sala.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("salas")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SalaController {

    @Autowired
    private SalaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastrarSala dados){
        Sala sala = new Sala(dados.capacidade());
        repository.save(sala);

    }

    @GetMapping
    public Page<DadosListagemSala> listarSalas(@PageableDefault(size = 10)Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemSala::new);
    }

    @GetMapping("/{id}")
    public Optional<Sala> detalharSala(@PathVariable Long id){
        return repository.findById(id);
    }

    public Sala buscarPorId(Long id){
        return repository.getReferenceById(id);
    }


}
