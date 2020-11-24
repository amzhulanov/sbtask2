package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Type;

/**
 * Сервис для работы с типами данных
 *
 * @author JAM
 */

public interface TypeService {

    Type addType(Type type);

    public Type findType(String name);

}
