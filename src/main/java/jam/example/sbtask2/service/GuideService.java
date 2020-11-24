package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Guide;

/**
 * Сервис для работы со справочником. Добавлять, искать, переименовывать, удалять.
 *
 * @author JAM
 */
public interface GuideService {

    Guide addGuide(String name);

    void deleteGuide(String name);

    Guide findGuideByName(String name);

    void renameGuide(String oldName, String newName);
}
