package jonaxPlex.api.domain.sessao;

import jakarta.persistence.*;
import jonaxPlex.api.domain.filme.Filme;
import jonaxPlex.api.domain.sala.Sala;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "Sessao")
@Table(name = "sessoes")
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private LocalTime hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id")
    private Sala sala;

    public Sessao(LocalDate data, LocalTime hora, Filme filme, Sala sala){
        this.data = data;
        this.hora = hora;
        this.filme = filme;
        this.sala = sala;
    }

}
