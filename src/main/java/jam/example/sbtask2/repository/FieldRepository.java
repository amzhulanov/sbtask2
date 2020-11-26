package jam.example.sbtask2.repository;

import jam.example.sbtask2.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FieldRepository extends JpaRepository<Field,Long> {

    @Query("SELECT f FROM Field f WHERE f.guide.id=:guide_id and f.name=:name")
    Field findFieldByName(@Param("guide_id") Long guide_id,
                          @Param("name") String name );

}
