package jam.example.sbtask2.service.impl;

import jam.example.sbtask2.entity.Vallue;
import jam.example.sbtask2.exception.ServiceException;
import jam.example.sbtask2.repository.VallueRepository;
import jam.example.sbtask2.service.FieldService;
import jam.example.sbtask2.service.VallueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ValueServiceImpl implements VallueService {

    private final VallueRepository vallueRepository;
    private final FieldService fieldService;

    @Autowired
    public ValueServiceImpl(VallueRepository vallueRepository, FieldService fieldService) {
        this.vallueRepository = vallueRepository;
        this.fieldService = fieldService;
    }

    /**
     * Метод сохраняет запись в БД
     * @param nameGuide имя справочника
     * @param vallueMap Список полей и значений
     * @return Список добавленных Vallue
     */
    public List<Vallue> addVallue(String nameGuide, Map<String, String> vallueMap) {
        Long nextRow = vallueRepository.findMaxRowByGuide(nameGuide).orElse(0L) + 1;
        List<Vallue> vallueList = new ArrayList<>();
        vallueMap.forEach((fld, val) -> {
            try {
                vallueList.add(new Vallue(fieldService.findFieldByName(nameGuide, fld), val, nextRow));
            } catch (ServiceException e) {
                e.printStackTrace();
            }

        });
        return vallueRepository.saveAll(vallueList);
    }

    /**
     * Метод удаляет строку по значению в поле
     *
     * @param nameGuide имя справочника
     * @param nameField имя поля
     * @param val   значение для фильтра
     */
    public void deleteVallue(String nameGuide, String nameField, String val) {
        vallueRepository.deleteByVallue(nameGuide,nameField, val);
    }

    /**
     * Метод меняет значение поля
     *
     * @param nameGuide имя справочника
     * @param nameField имя поля
     * @param newVal    новое значение
     * @param oldVal    старое значени
     */
    public void editVallue(String nameGuide, String nameField, String newVal, String oldVal) {
        vallueRepository.editByValue(nameGuide, nameField, newVal, oldVal);
    }

    /**
     * Метод возвращает список Vallue по значению в указанном поле
     *
     * @param field поле, содержит ссылку на справочник
     * @param val   значение для фильтра
     * @return список Vallue
     */
    public List<Vallue> findAllByVallue(String nameGuide, String field, String val) {
        return vallueRepository.findAllByVallue(nameGuide, field, val);
    }

    /**
     * Метод возвращает список Vallue по значению в указанном поле
     *
     * @param nameGuide  имя справочника
     * @param nameField  имя поля
     * @param nameField2 имя поля
     * @param val        значение поля nameField
     * @param val2       значение поля nameField2
     * @return Список Vallue
     */
    public List<Vallue> findAllByVallues(String nameGuide, String nameField, String nameField2, String val, String val2) {
        return vallueRepository.findAllByVallues(nameGuide, nameField, val, nameField2, val2);
    }

}
