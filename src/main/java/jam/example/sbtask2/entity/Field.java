package jam.example.sbtask2.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность Поля справочника. Содержит связку справочника, имени и типа поля
 */
@Entity
@Table(name = "field")
@Data
@NoArgsConstructor

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Field.class)
public class Field {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToMany(mappedBy = "field",
            fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE)

    private List<Vallue> vallueList;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "guide_id")
    @NonNull
    private Guide guide;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    @NonNull
    private Type type;

    @Column
    @NonNull
    private String name;

    public Field(@NonNull Guide guide, @NonNull String name, @NonNull Type type) {
        this.name = name;
        this.guide = guide;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }

}
