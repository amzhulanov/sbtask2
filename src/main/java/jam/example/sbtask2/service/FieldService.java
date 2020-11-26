package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Field;

/**
 * Сервис для работы со структурой справочника. Добавлять, изменять, искать, удалять поля
 *
 * @author JAM
 */
public interface FieldService {

    Field addField(Field field);

    Field findFieldByName(String nameGuide, String name);

    Field renameFieldByName(String nameGuide, String oldName, String newName);

}


