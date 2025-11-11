package avaliacao.arthur.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "apartamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartamento")
    private Long id;
    private Integer numeroPorta;
    private Integer quantidadeQuartos;
    private String tipoOcupacao;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "proprietario_id", nullable = false, foreignKey = @ForeignKey(name = "fk_apartamento_proprietario"))
    private Proprietario proprietario;

    public Apartamento(Integer numeroPorta, Integer quantidadeQuartos,
            String tipoOcupacao, Proprietario proprietario) {
        this.numeroPorta = numeroPorta;
        this.quantidadeQuartos = quantidadeQuartos;
        this.tipoOcupacao = tipoOcupacao;
        this.proprietario = proprietario;
    }

}
