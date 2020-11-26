package jam.example.sbtask2.service.impl;

import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.repository.FieldRepository;
import jam.example.sbtask2.service.FieldService;
import jam.example.sbtask2.service.GuideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FieldServiceImpl implements FieldService {

    private final FieldRepository fieldRepository;
    private final GuideService guideService;

    public FieldServiceImpl(FieldRepository fieldRepository, GuideService guideService) {
        this.fieldRepository = fieldRepository;
        this.guideService = guideService;
    }

    public Field addField(Field field) {
        return fieldRepository.save(field);
    }

    public Field findFieldByName(String nameGuide, String name) {
        log.info("findFieldByName.guide= " + nameGuide);
        Long guideId=guideService.findGuideByName(nameGuide).getId();
        return fieldRepository.findFieldByName(guideId, name);
    }

    //todo изменить возврат null на проброс понятного исключения
    public Field renameFieldByName(String nameGuide, String oldName, String newName) {
        Long guideId=guideService.findGuideByName(nameGuide).getId();
        if (guideId!=null) {
            Field field = fieldRepository.findFieldByName(guideId, oldName);
            if (field != null) {
                field.setName(newName);
                return fieldRepository.save(field);
            }
        }else{
            return null;
        }
        return null;
    }

}

