package jonaxPlex.api.controller;

import jonaxPlex.api.domain.assentos.Assento;
import jonaxPlex.api.domain.assentos.AssentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AssentoController {
    @Autowired
    private AssentoRepository assentoRepository;

    @Transactional
    public void gerarAssentos(Assento assento){
        assentoRepository.save(assento);
    }
}
