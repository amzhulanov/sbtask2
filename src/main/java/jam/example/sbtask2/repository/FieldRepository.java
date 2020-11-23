package jam.example.sbtask2.repository;

import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field,Long> {



    @Query("DELETE FROM Field f where  f.guide=:guide and f.name=:name")
    void deleteByName(@Param("guide") Guide guide,
                      @Param("name") String name );

    @Query("SELECT f FROM Field f WHERE f.guide=:guide and f.name=:name")
    Field findFieldByName(@Param("guide") Guide guide,
                          @Param("name") String name );


}
