package jam.example.sbtask2.service.impl;

import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.repository.FieldRepository;
import jam.example.sbtask2.service.FieldService;
import jam.example.sbtask2.service.GuideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс с реализацией сервиса работы со структурой справочника
 *
 * @author JAM
 */
@Service
@Slf4j
public class FieldServiceImpl implements FieldService {

    private final FieldRepository fieldRepository;
    private final GuideService guideService;

    public FieldServiceImpl(FieldRepository fieldRepository, GuideService guideService) {
        this.fieldRepository = fieldRepository;
        this.guideService = guideService;
    }

    /**
     * Метод для добавления одного поля в справочник
     * @param field Сущность поля
     * @return Возвращает сохранённое значение
     */
    public Field saveField(Field field) {
        return fieldRepository.save(field);
    }

    /**
     * Метод для добавления списка полей в справочник
     * @param fieldList Список сущностей типа Field
     * @return Возвращает сохранённые значения
     */
    public List<Field> saveFields(List<Field> fieldList){
        return fieldRepository.saveAll(fieldList);
    }

    /**
     * Поиск Field по имени
     * @param nameGuide наименование справочника
     * @param name имя искомого поля
     * @return найденное значение Fiild
     */
    public Field findFieldByName(String nameGuide, String name) {
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

