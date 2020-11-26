package jam.example.sbtask2.controller;

import jam.example.sbtask2.entity.Vallue;
import jam.example.sbtask2.service.GuideService;
import jam.example.sbtask2.service.VallueService;
import jam.example.sbtask2.utils.Converter;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST-контроллер для работы с данными справочников
 *
 * @author JAM
 */
@Controller
@RequestMapping("/data")
@Slf4j
public class GuideDataController {
    private Map<String, String> fieldsGuide;

    private final Converter converter;
    private final GuideService guideService;
    private VallueService vallueService;

    @Autowired
    public GuideDataController(Converter converter, GuideService guideService, VallueService vallueService) {
        this.converter = converter;
        this.guideService = guideService;
        this.vallueService = vallueService;
    }

    /**
     * Метод для добавления значений в справочник
     *
     * @param name Имя таблицы
     * @param json Текст запроса
     * @return Возвращает кол-во добавленых строк
     * @throws ParseException Исключение возникающее при парсинге json
     */
    @PutMapping("/{name}")
    public ResponseEntity<String> addVallue(@PathVariable String name, @RequestBody String json) throws ParseException {
        Map<String, String> newValue  = converter.convertJsonToMap(json);
        List<Vallue> vallueList=vallueService.addVallue(name,newValue);
        return new ResponseEntity<>(converter.convertListToJson(vallueList), HttpStatus.OK);
    }

//    /**
//     * Метод для изменений значений в справочнике
//     *
//     * @param name Имя таблицы
//     * @param json Текст запроса
//     * @return Возвращает кол-во измененных записей
//     * @throws ParseException Исключение
//     */
//    @PostMapping("/{name}")
//    public ResponseEntity<String> updateDataGuide(@PathVariable String name, @RequestBody String json) throws ParseException {
//        Integer result = guideService.updateRecords(converter.convertJsonToListMap(json), name);
//        return new ResponseEntity<>("Update " + result + " records", HttpStatus.OK);
//    }
//
//    /**
//     * Метод для поиска значений в справочнике. Если условия для поиска не указаны выгружается весь справочник
//     *
//     * @param name Имя справочника
//     * @param json Текст запроса (опционально)
//     * @return Список строк
//     */
//    @GetMapping("/{name}")
//    public ResponseEntity<String> find(@PathVariable String name, @RequestBody String json) {
//        fieldsGuide = converter.convertJsonToMap(json);
//        log.info(json);
//        return new ResponseEntity<>(converter.convertListToJson(guideService.find(fieldsGuide, name)), HttpStatus.OK);
//
//    }
//
//    /**
//     * Метод для удаления записей из справочника
//     *
//     * @param name имя справочника
//     * @param json список условий дял удаления
//     * @return кол-во удалённых записей
//     */
//    @DeleteMapping("/{name}")
//    public ResponseEntity<String> deleteGuide(@PathVariable String name, @RequestBody String json) {
//        fieldsGuide = converter.convertJsonToMap(json);
//        Integer result = guideService.deleteRecords(fieldsGuide, name);
//        return new ResponseEntity<>("Delete " + result + " records", HttpStatus.OK);
//    }

}
