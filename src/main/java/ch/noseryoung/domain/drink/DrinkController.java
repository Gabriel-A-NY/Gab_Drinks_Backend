package ch.noseryoung.domain.drink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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

    @CrossOrigin(origins = "http://localhost:5175")
    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('GET')")
    public List<Drink> showAll() {
        return drinkService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5175")
    @GetMapping("/{product_id}")
    @PreAuthorize("hasAnyAuthority('GET')")
    public ResponseEntity<Drink> getById(@PathVariable("product_id") int id) throws InstanceNotFoundException {
        return ResponseEntity.ok().body(drinkService.getById(id));
    }

    @CrossOrigin(origins = "http://localhost:5175")
    @PreAuthorize("hasAnyAuthority('POST')")
    @PostMapping("/add")
    public ResponseEntity<Drink> createDrink(@RequestBody Drink newDrink) throws InstanceAlreadyExistsException {
        return ResponseEntity.status(201).body(drinkService.addDrink(newDrink));
    }

    @CrossOrigin(origins = "http://localhost:5175")
    @PreAuthorize("hasAnyAuthority('PUT')")
    @PutMapping(value = "/{product_id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable("product_id") int productId, @RequestBody Drink drink) throws InstanceNotFoundException, InstanceAlreadyExistsException {
        return ResponseEntity.status(200).body(drinkService.updateById(productId, drink));
    }

    @CrossOrigin(origins = "http://localhost:5175")
    @PreAuthorize("hasAnyAuthority('DELETE')")
    @DeleteMapping("{product_id}")
    public String deleteDrink(@PathVariable("product_id") int productId) throws InstanceNotFoundException {
        drinkService.deleteDrink(productId);
        return "deleted drink id: " + productId;
    }

    @CrossOrigin(origins = "http://localhost:5175")
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("err " + e.getMessage());
    }
}
