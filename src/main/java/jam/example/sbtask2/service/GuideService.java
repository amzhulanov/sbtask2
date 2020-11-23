package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Guide;
import jam.example.sbtask2.repository.GuideRepository;
import org.springframework.stereotype.Service;

@Service
public class GuideService {

    private final GuideRepository guideRepository;

    public GuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    public Guide addGuide (String name){
        return guideRepository.save(new Guide(name));

    }

    public Guide findGuideByName(String name){
        return guideRepository.findGuideByName(name);
    }

    public void renameGuide(String oldName,String newName){
        guideRepository.findGuideByName(oldName).setName(newName);
    }
}
