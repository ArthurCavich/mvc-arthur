package avaliacao.arthur.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proprietario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proprietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proprietario")
    private Long id;
    private String nome;
    private String telefone;

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Apartamento> apartamentos = new ArrayList<>();

    public void adicionarApartamento(Apartamento apartamento) {
        apartamentos.add(apartamento);
        apartamento.setProprietario(this);
    }

    /**
     * Método auxiliar para remover um apartamento da lista.
     * Mantém sincronização bidirecional do relacionamento.
     */
    public void removerApartamento(Apartamento apartamento) {
        apartamentos.remove(apartamento);
        apartamento.setProprietario(null);
    }
}
