package jam.example.sbtask2.repository;

import jam.example.sbtask2.entity.Guide;
import jam.example.sbtask2.entity.Vallue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VallueRepository extends JpaRepository<Vallue, UUID> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Vallue v WHERE v.row =ANY ( SELECT vl.row FROM Vallue vl WHERE vl.field.guide.name=:nameGuide and vl.field.name=:nameField and vl.vallue=:val)")
    void deleteByVallue(@Param("nameGuide") String nameGuide,
                        @Param("nameField") String nameField,
                        @Param("val") String val);

    @Transactional
    @Modifying
    @Query("UPDATE Vallue v SET v.vallue=:newVal WHERE EXISTS (SELECT vl FROM Vallue vl WHERE v.field.guide.name=:nameGuide and v.field.name=:nameField and v.vallue=:oldVal)")
    void editByValue(@Param("nameGuide") String nameGuide,
                     @Param("nameField") String nameField,
                     @Param("oldVal") String oldVal,
                     @Param("newVal") String newVal);


    @Query("SELECT v FROM Vallue v WHERE v.row =ANY ( SELECT vl.row FROM Vallue vl WHERE vl.field.guide.name=:nameGuide and vl.field.name=:nameField and vl.vallue=:val)")
    List<Vallue> findAllByVallue(@Param("nameGuide") String nameGuide,
                                 @Param("nameField") String nameField,
                                 @Param("val") String val);

    @Query("SELECT vl FROM Vallue vl WHERE EXISTS (SELECT v FROM Vallue v WHERE v.field.guide.name=:nameGuide and v.field.name=:nameField and v.vallue=:val) and vl.field.name=:nameField2 and vl.vallue=:val2")
    List<Vallue> findAllByVallues(@Param("nameGuide") String nameGuide,
                                  @Param("nameField") String nameField,
                                  @Param("val") String val,
                                  @Param("nameField2") String nameField2,
                                  @Param("val2") String val2
    );

    @Query("SELECT MAX(v.row) FROM Vallue v WHERE v.field.guide.name=:nameGuide")
    Optional<Long> findMaxRowByGuide(@Param("nameGuide") String nameGuide);

}
