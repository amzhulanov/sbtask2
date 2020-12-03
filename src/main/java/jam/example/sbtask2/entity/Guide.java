package jam.example.sbtask2.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность Справочник
 *
 */
@Entity
@Table(name = "guide")
@Data
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
scope=Guide.class)
public class Guide {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    protected Long id;

    @OneToMany(mappedBy = "guide",cascade = CascadeType.REMOVE)

    private List<Field> fieldList;

    @Column(unique = true)
    private String name;

    public Guide(String name) {this.name = name;}

}

