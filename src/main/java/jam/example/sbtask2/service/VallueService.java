package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.entity.Vallue;
import jam.example.sbtask2.repository.VallueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VallueService {
    private final VallueRepository vallueRepository;

    public VallueService(VallueRepository vallueRepository) {
        this.vallueRepository = vallueRepository;
    }

    public Vallue addVallue(Vallue vallue){
        return vallueRepository.save(vallue);
    }

    public void deleteVallue (Field field, String val){
        vallueRepository.deleteByVallue(field,val);
    }

    public void editVallue (Field field, String newVal,String oldVal){
        vallueRepository.editByValue(field,newVal,oldVal);
    }

    public List<String> findAllByVallue(Field field, String val){
        return vallueRepository.findAllByVallue(field,val);
    }

    public List<Vallue> findAllByVallues(String nameGuide,Field field, Field field2, String val, String val2){
        return vallueRepository.findAllByVallues(nameGuide,field,val,field2,val2);
    }
}
