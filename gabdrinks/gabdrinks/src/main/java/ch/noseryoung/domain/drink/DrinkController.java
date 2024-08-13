package ch.noseryoung.domain.drink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
public class DrinkController {
    private final DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/all")
    public List<Drink> showAll() {
        return drinkService.findAll();
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<Drink> getById(@PathVariable("product_id") int id) throws InstanceNotFoundException {
        return ResponseEntity.ok().body(drinkService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Drink> createDrink(@RequestBody Drink newDrink) throws InstanceAlreadyExistsException {
        return ResponseEntity.status(201).body(drinkService.addDrink(newDrink));
    }

    @PutMapping(value = "/{product_id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable("product_id") int productId, @RequestBody Drink drink) throws InstanceNotFoundException, InstanceAlreadyExistsException {
        return ResponseEntity.status(200).body(drinkService.updateById(productId, drink));
    }

    public String deleteDrink(@PathVariable("product_id") int productId) throws InstanceNotFoundException {
        drinkService.deleteDrink(productId);
        return "deleted drink id: " + productId;
    }
}
