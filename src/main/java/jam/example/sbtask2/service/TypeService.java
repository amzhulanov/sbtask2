package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Type;
import jam.example.sbtask2.repository.TypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с типами данных
 *
 * @author JAM
 */
@Service
@Slf4j
public class TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    /**
     * Метод для добавления нового типа данных
     * @param name имя типа
     * @return возвращает добавленный Type
     */
    public Type addType(String name){
        log.info("saved new Data type = "+name);
        //if (findType(name).)
        return typeRepository.save(new Type(name));
    }

    public Type findType(String name){
        return typeRepository.findByName(name);
    }

}
