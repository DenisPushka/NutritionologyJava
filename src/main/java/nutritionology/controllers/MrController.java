package nutritionology.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import nutritionology.models.dictionaries.BiologicalElement;
import nutritionology.models.dictionaries.MR;
import nutritionology.models.dictionaries.MRItem;
import nutritionology.models.dictionaries.MS;
import nutritionology.services.interfaces.MRServiceInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mr")
public class MrController {
    private MRServiceInterface mrServiceInterface;

    public MrController(MRServiceInterface mrServiceInterface) {
        this.mrServiceInterface = mrServiceInterface;
    }

    // region MS

    /**
     * Получение всех СИ.
     *
     * @return Массив СИ.
     */
    @GetMapping("/getAllMses")
    public MS[] getAllMses() {
        return mrServiceInterface.getMSes();
    }

    /**
     * Добавление массива СИ.
     *
     * @param mses Добавляемые объекты.
     * @return Массив СИ.
     */
    @PostMapping("/addMses")
    public MS[] addMSes(@RequestBody MS[] mses) {
        return mrServiceInterface.addArrayMs(mses);
    }

    /**
     * Добавление СИ.
     *
     * @param ms Добавляемый объект.
     * @return Массив СИ.
     */
    @PostMapping("/addMs")
    public MS[] addMs(@RequestBody MS ms) {
        return mrServiceInterface.addMs(ms);
    }

    // endregion

    // region Biological element

    /**
     * Получение всех биологических элементов.
     *
     * @return Массив биологических элементов.
     */
    @GetMapping("/getAllBiologicalElement")
    public BiologicalElement[] getAllBEl() {
        return mrServiceInterface.getBiologicallyElements();
    }

    @PostMapping("/bioladd")
    public BiologicalElement[] add(){
        return mrServiceInterface.getBiologicallyElements();
    }

    // endregion

    // region MR Item

    /**
     * Получение элементов МР.
     *
     * @return Массив элементов МР.
     */
    @GetMapping("/getAllMrItems")
    public ResponseEntity<MRItem[]> getAllMrItems() {
        var mr = mrServiceInterface.getAllMrItems();
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(mr);
    }

    /**
     * Добавление элемента МР.
     *
     * @param mrItem Добавляемый объект.
     * @return Массив элементов МР.
     */
    @PostMapping("/addMrItem")
    public MRItem[] addMrItem(@RequestBody MRItem mrItem) {
        return mrServiceInterface.addMrItem(mrItem);
    }

    /**
     * Добавление массива элементов МР.
     *
     * @param mrItems Добавляемые объекты.
     * @return Массив элементов МР.
     */
    @PostMapping("/addMrItems")
    public MRItem[] addArrayMrItems(@RequestBody MRItem[] mrItems) {
        return mrServiceInterface.addArrayMrItems(mrItems);
    }

    /**
     * Изменение элемента МР.
     *
     * @param mrItem Новоизменный объект.
     * @return Массив элементов МР.
     */
    @PutMapping("/changeMRItem")
    public MRItem[] updateMRItem(@RequestBody MRItem mrItem) {
        return mrServiceInterface.updateMrItem(mrItem);
    }


    // endregion

    // region MR

    /**
     * Получение массива МР.
     *
     * @return Массив МР.
     */
    @GetMapping("/getAllMR")
    public MR[] getAllMr() {
        return mrServiceInterface.getAllMr();
    }

    /**
     * Добавление МР.
     *
     * @param mr Добавляемый объект.
     * @return Массив МР.
     */
    @PostMapping("/addMr")
    public MR[] addMr(@RequestBody MR mr) {
        return mrServiceInterface.addMr(mr);
    }

    /**
     * Добавление массива МР.
     *
     * @param mrs Добавляемые объекты.
     * @return Массив МР.
     */
    @PostMapping("/addArrayMr")
    public MR[] addArrayMr(@RequestBody MR[] mrs) {
        return mrServiceInterface.addMrs(mrs);
    }

    /**
     * Изменение МР.
     *
     * @param mr Новоизмененный объект.
     * @return Массив МР.
     */
    @PutMapping("/updateMr")
    public MR[] updateMr(@RequestBody MR mr) {
        return mrServiceInterface.updateMr(mr);
    }

    // endregion
}
