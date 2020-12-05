package jam.example.sbtask2.service.impl;

import jam.example.sbtask2.entity.Type;
import jam.example.sbtask2.repository.TypeRepository;
import jam.example.sbtask2.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    /**
     * Добавляет новый тип данных
     *
     * @param type новый тип данных
     * @return возвращает добавленный Type
     */
    public Type addType(Type type) {
        Type typeOld=typeRepository.findByName(type.getName()).orElse(null);
        if (typeOld==null){
            return typeRepository.save(type);
        }
        return typeOld;
    }

    public Type findType(String name) {

        return typeRepository.findByName(name).orElse(null);
    }
}
