package jonaxPlex.api.domain.sessao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    boolean existsByDataAndHoraAndSalaId(LocalDate data, LocalTime hora, Long sala_id);

    List<Sessao> findByFilmeId(Long idFilme);

}
