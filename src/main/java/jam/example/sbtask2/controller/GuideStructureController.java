package jam.example.sbtask2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.entity.Guide;
import jam.example.sbtask2.entity.Type;
import jam.example.sbtask2.exception.ServiceException;
import jam.example.sbtask2.service.FieldService;
import jam.example.sbtask2.service.GuideService;
import jam.example.sbtask2.service.TypeService;
import jam.example.sbtask2.utils.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * REST-контроллер для работы со структурой справочников
 *
 * @author JAM
 */
@Controller
@RequestMapping("/db")
@Slf4j
public class GuideStructureController {
    private Map<String, String> fieldsGuide;
    private String result;

    private final Converter converter;
    private final GuideService guideService;
    private final TypeService typeService;
    private final FieldService fieldService;


    public GuideStructureController(Converter converter, GuideService guideService, TypeService typeService, FieldService fieldService) {
        this.converter = converter;
        this.guideService = guideService;
        this.typeService = typeService;
        this.fieldService = fieldService;
    }

    /**
     * Метод для создания нового типа данных
     *
     * @param json {"name":"String"}
     * @throws JsonProcessingException
     */
    //todo сделать обработку ситуации, если тип уже существует
    @PutMapping("/createType")
    public ResponseEntity<String> createType(@RequestBody String json) throws JsonProcessingException {
        Type type = converter.convertJsonToEntity(json, Type.class);
        result = converter.convertEntityToJson(typeService.addType(type));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Метод для создания справочника
     *
     * @param json {"name":"person"}
     */
    //todo сделать обработку ситуации, если справочник уже существует
    @PutMapping("/createGuide")
    public ResponseEntity<String> createGuide(@RequestBody String json) throws JsonProcessingException {
        Guide guide = converter.convertJsonToEntity(json, Guide.class);
        result = converter.convertEntityToJson(guideService.addGuide(guide));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Метод для добавления полей в структуру справочника
     *
     * @param json {"guide":{"id":1,"fieldList":null,"name":"person"},"type":{"id":1,"fieldList":null,"name":"String"},"name":"firstname"}
     */
    @PutMapping("/createField")
    //todo сделать обработку ситуации, если поле уже существует
    public ResponseEntity<String> addField(@RequestBody String json) throws JsonProcessingException {
        Field field = converter.convertJsonToEntity(json, Field.class);
        result = converter.convertEntityToJson(fieldService.saveField(field));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Метод для изменения типа или наименования полей справочника
     *
     * @param json {"nameGuide":"person","oldName":"lastname","newName":"nickname"}
     * @return Возвращает статус выполнения
     */
    @PostMapping("/renameField")
    public ResponseEntity<String> renameField(@RequestBody String json) throws JsonProcessingException, ServiceException {
//        try {
//            fieldsGuide = converter.convertJsonToMap(json);
//            Field field = fieldService.renameFieldByName(fieldsGuide.get("nameGuide"), fieldsGuide.get("oldName"), fieldsGuide.get("newName"));
//            result = converter.convertEntityToJson(fieldService.saveField(field));
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        }
//        catch (ServiceException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }


        fieldsGuide = converter.convertJsonToMap(json);
        Field field=fieldService.renameFieldByName(fieldsGuide.get("nameGuide"),fieldsGuide.get("oldName"),fieldsGuide.get("newName"));
        if (field!=null){
            result=converter.convertEntityToJson(fieldService.saveField(field));
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Field not found. From controller", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Метод для удаления справочника
     *
     * @param json {"nameGuide":"person"}
     * @return Возвращает статус удаления справочника
     */
    @DeleteMapping("/dropGuide")
    public ResponseEntity<String> dropGuide(@RequestBody String json) {
        fieldsGuide = converter.convertJsonToMap(json);
        guideService.deleteGuide(fieldsGuide.get("guide"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
