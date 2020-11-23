package jam.example.sbtask2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность для хранения данных. Содержит код поля, номер записи и сами данные
 *
 * @author JAM
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

    @Column
    private Long row;

    public Vallue(Field field, String vallue,Long row) {
        this.field=field;
        this.vallue=vallue;
        this.row=row;
    }
}
