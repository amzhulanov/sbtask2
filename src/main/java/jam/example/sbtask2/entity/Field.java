package jam.example.sbtask2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность Поля справочника. Содержит код справочника, код и тип поля
 */
@Entity
@Table(name = "field")
@Data
@NoArgsConstructor
public class Field {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToMany(mappedBy = "field",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Vallue> vallueList;

    @ManyToOne()//cascade = {CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "guide_id")
    private Guide guide;

    @ManyToOne()
    @JoinColumn(name = "type_id")
    private Type type;

    @Column
    private String name;

    public Field(Guide guide, String name, Type type) {
        this.name = name;
        this.guide = guide;
        this.type = type;
    }
}
