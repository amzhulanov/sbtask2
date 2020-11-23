package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.entity.Guide;
import jam.example.sbtask2.repository.FieldRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FieldService {
    private final FieldRepository fieldRepository;
    private Field field;

    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public Field addField(Field field) {
        return fieldRepository.save(field);
    }

    public Field findFieldByName(Guide guide, String name){
        log.info("findFieldByName.guide= "+guide.getName());
        Field field=fieldRepository.findFieldByName(guide,name);
        log.info("findFieldByName.field= "+field.getName());
        return field;
    }

    public Field renameFieldByName(Guide guide, String oldName,String newName){

        field= fieldRepository.findFieldByName(guide,oldName);
        field.setName(newName);
        return fieldRepository.save(field);
    }

    public void deleteAllField(){
        fieldRepository.deleteAll();
    }
    public void deleteFieldByName(Guide guide, String name){
        fieldRepository.deleteByName(guide,name);
    }
}


