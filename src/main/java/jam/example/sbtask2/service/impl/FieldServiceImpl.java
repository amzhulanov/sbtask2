package jam.example.sbtask2.service.impl;

import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.repository.FieldRepository;
import jam.example.sbtask2.service.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FieldServiceImpl implements FieldService {

    private final FieldRepository fieldRepository;

    public FieldServiceImpl(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public Field addField(Field field) {
        return fieldRepository.save(field);
    }

    public Field findFieldByName(String nameGuide, String name) {
        log.info("findFieldByName.guide= " + nameGuide);
        return fieldRepository.findFieldByName(nameGuide, name);
    }

    public Field renameFieldByName(String nameGuide, String oldName, String newName) {
        Field field = fieldRepository.findFieldByName(nameGuide, oldName);
        field.setName(newName);
        return fieldRepository.save(field);
    }

    public void deleteAllFields() {
        fieldRepository.deleteAll();
    }

    public void deleteFieldByName(String nameGuide, String name) {
        fieldRepository.deleteByName(nameGuide, name);
    }

}

