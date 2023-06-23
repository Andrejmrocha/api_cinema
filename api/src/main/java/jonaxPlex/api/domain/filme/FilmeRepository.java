package jonaxPlex.api.domain.filme;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    Page<Filme> findAllByAtivoTrue(Pageable paginacao);
}
