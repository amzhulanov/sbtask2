package jam.example.sbtask2.repository;

import jam.example.sbtask2.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GuideRepository extends JpaRepository<Guide, UUID>{

    Optional<Guide> findGuideByName(String name);

}

