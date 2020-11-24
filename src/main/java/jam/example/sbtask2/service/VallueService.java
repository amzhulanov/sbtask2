package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Vallue;
import java.util.List;
import java.util.Map;

/**
 * Сервис для работы с данными справочников. Добавлять, искать, удалять, переименовывать.
 *
 * @author JAM
 */
public interface VallueService {

    List<Vallue> addVallue(String nameGuide, Map<String, String> vallueList);

    void deleteVallue(String nameGuide, String nameField, String val);

    void editVallue(String nameGuide, String nameField, String newVal, String oldVal);

    List<Vallue> findAllByVallue(String nameGuide, String field, String val);

    List<Vallue> findAllByVallues(String nameGuide, String nameField, String nameField2, String val, String val2);

}