package jonaxPlex.api.domain.assentos;

import jakarta.persistence.*;
import jonaxPlex.api.domain.sala.Sala;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Assento")
@Table(name = "assentos")
@NoArgsConstructor
@Getter
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id")
    private Sala sala;

    public Assento(int numero, Sala sala){
        this.numero = numero;
        this.sala = sala;
        this.status = false;
    }
}
