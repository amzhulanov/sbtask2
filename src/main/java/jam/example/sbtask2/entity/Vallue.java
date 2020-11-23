package jam.example.sbtask2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Сущность для хранения данных. Содержит код поля и сами данные
 */
@Entity
@Table(name="vallue")
@Data
@NoArgsConstructor
public class Vallue {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    protected Long id;

    @Column
    private String vallue;

    @ManyToOne(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name="field_id")
    private Field field;

    public Vallue(Field field, String vallue) {
        this.field=field;
        this.vallue=vallue;
    }
}
