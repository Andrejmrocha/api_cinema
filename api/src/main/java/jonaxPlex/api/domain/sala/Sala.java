package jonaxPlex.api.domain.sala;

import jakarta.persistence.*;
import jonaxPlex.api.domain.assentos.Assento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Sala")
@Table(name = "salas")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int capacidade;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private List<Assento> assentos;

    public Sala(int capacidade){
        this.capacidade = capacidade;
        this.assentos = new ArrayList<>();

        for(int i = 1; i <= this.capacidade; i++){
            Assento assento = new Assento(i, this);
            this.assentos.add(assento);
        }
    }


}
