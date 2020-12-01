package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.exception.ServiceException;

/**
 * Сервис для работы со структурой справочника. Добавлять, изменять, искать, удалять поля
 *
 * @author JAM
 */
public interface FieldService {

    Field saveField(Field field);

    Field findFieldByName(String nameGuide, String name) throws ServiceException;

    Field renameFieldByName(String nameGuide, String oldName, String newName) throws ServiceException;

}


