package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Guide;
import jam.example.sbtask2.repository.GuideRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Сервис для работы со справочником. Добавлять, искать, переименовывать, удалять.
 *
 * @author JAM
 */
@Service
public class GuideService {

    private final GuideRepository guideRepository;

    public GuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    public Guide addGuide (String name){
        Guide guide=guideRepository.findGuideByName(name).orElse(null);
        if (guide==null){
            return guideRepository.save(new Guide(name));
        }
        return guide;
    }

    public void deleteGuide(String name){
        guideRepository.findGuideByName(name).ifPresent(guideRepository::delete);
    }

    public Guide findGuideByName(String name){
        return guideRepository.findGuideByName(name).orElse(null);
    }

    public void renameGuide(String oldName,String newName){
        Objects.requireNonNull(guideRepository.findGuideByName(oldName).orElse(null)).setName(newName);
    }
}
