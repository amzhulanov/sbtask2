package jam.example.sbtask2.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

/**
 * Сущность для хранения данных. Содержит код поля(ID), номер записи(row) и сами данные(vallue)
 *
 * @author JAM
 */
@Entity
@Table(name="vallue")
@Data
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope=Vallue.class)
public class Vallue {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    protected Long id;

    @Column
    @NonNull
    private String vallue;

    @ManyToOne(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name="field_id")
    @NonNull
    private Field field;

    @Column
    @NonNull
    private Long row;

    public Vallue(@NonNull Field field, @NonNull String vallue, @NonNull Long row) {
        this.field=field;
        this.vallue=vallue;
        this.row=row;
    }

}
