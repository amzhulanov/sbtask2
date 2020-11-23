package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.repository.FieldRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы со структурой справочника. Добавлять, изменять, искать, удалять поля
 *
 * @author JAM
 */
@Service
@Slf4j
public class FieldService {
    private final FieldRepository fieldRepository;

    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public Field addField(Field field) {
        return fieldRepository.save(field);
    }

    public Field findFieldByName(String nameGuide, String name){
        log.info("findFieldByName.guide= "+nameGuide);
        return fieldRepository.findFieldByName(nameGuide,name);
    }

    public Field renameFieldByName(String nameGuide, String oldName,String newName){
        Field field = fieldRepository.findFieldByName(nameGuide, oldName);
        field.setName(newName);
        return fieldRepository.save(field);
    }

    public void deleteAllFields(){
        fieldRepository.deleteAll();
    }
    public void deleteFieldByName(String nameGuide, String name){
        fieldRepository.deleteByName(nameGuide,name);
    }
}


