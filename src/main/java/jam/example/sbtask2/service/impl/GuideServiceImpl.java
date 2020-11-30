package jam.example.sbtask2.service.impl;

import jam.example.sbtask2.entity.Guide;
import jam.example.sbtask2.repository.GuideRepository;
import jam.example.sbtask2.service.GuideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Класс реализаций методов сервиса по работе со справочником
 *
 * @author JAM
 */
@Service
@Slf4j
public class GuideServiceImpl implements GuideService {
    private final GuideRepository guideRepository;

    public GuideServiceImpl(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    /**
     * Создание нового справочника
     * @param guide Сущность справочника
     * @return Возвращет созданную сущность
     */
    public Guide addGuide(Guide guide) {
        Guide savedGuide = guideRepository.findGuideByName(guide.getName()).orElse(null);
        if (savedGuide == null) {
            return guideRepository.save(guide);
        }
        return guide;
    }

    /**
     * Удаляет справочник
     * @param name имя справочника
     */
    public void deleteGuide(String name) {
        guideRepository.findGuideByName(name).ifPresent(guideRepository::delete);
    }

    /**
     * Поиск справочника по имени
     * @param name имя справочника
     * @return Найденная сущность
     */
    public Guide findGuideByName(String name) {
        return guideRepository.findGuideByName(name).orElse(null);
    }

    /**
     * Переименование справочника
     * @param oldName старое имя
     * @param newName новое имя
     */
    public void renameGuide(String oldName, String newName) {
        Objects.requireNonNull(guideRepository.findGuideByName(oldName).orElse(null)).setName(newName);
    }
}
