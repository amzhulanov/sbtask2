package jam.example.sbtask2.repository;

import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.entity.Vallue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VallueRepository extends JpaRepository<Vallue, UUID> {

    @Query("DELETE FROM Vallue v WHERE v.field=:field and v.vallue=:val")
    void deleteByVallue(@Param("field") Field field,
                        @Param("val") String val);


    @Query("UPDATE Vallue SET vallue=:newVal WHERE field=:field and vallue=:oldVal")
    void editByValue(@Param("field") Field field,
                     @Param("oldVal") String oldVal,
                     @Param("newVal") String newVal);


    @Query("SELECT v FROM Vallue v WHERE v.field=:field and v.vallue=:val")
    List<String> findAllByVallue(@Param("field") Field field,
                                 @Param("val") String val);

//    @Query(value = "SELECT res FROM (SELECT v.field.name FROM Vallue v WHERE v.field.guide.name=:nameGuide and v.field.name=:nameField and v.vallue=:val) res WHERE res.field.name=:nameField2  and res.vallue=:val2",
//            nativeQuery = true)
@Query("SELECT v2 FROM Vallue v2 WHERE EXISTS (SELECT v FROM Vallue v WHERE v.field.guide.name=:nameGuide and v.field.name=:nameField and v.vallue=:val) and v2.field.name=:nameField2  and v2.vallue=:val2")
    List<Vallue> findAllByVallues(@Param("nameGuide") String nameGuide,
                                  @Param("nameField") Field nameField,
                                  @Param("val") String val,
                                  @Param("nameField2") Field nameField2,
                                  @Param("val2") String val2);


}
