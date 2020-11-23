package jam.example.sbtask2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Тип данных
 *
 */
@Entity
@Table(name = "type",uniqueConstraints= @UniqueConstraint(columnNames={"id", "name"}))
@Data
@NoArgsConstructor
public class Type {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToMany(mappedBy = "type",cascade = CascadeType.REMOVE)
    private List<Field> fieldList;

    @Column
    private String name;

    public Type(String name) {
        this.name = name;
    }

}

