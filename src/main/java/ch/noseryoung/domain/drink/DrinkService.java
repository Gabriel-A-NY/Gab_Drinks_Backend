package ch.noseryoung.domain.drink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Drink getById(int id) throws InstanceNotFoundException {
        return drinkRepository.findById(id)
                .orElseThrow(() -> new InstanceNotFoundException());
    }

    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    public void saveDrink(Drink existingDrink) {
        drinkRepository.save(existingDrink);
    }

    public void deleteDrink(int id) {
        if (!drinkRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        drinkRepository.deleteById(id);
    }

    public Drink addDrink(Drink newDrink) throws InstanceAlreadyExistsException {
        if (drinkRepository.existsById(newDrink.getId())) {
            throw new InstanceAlreadyExistsException();
        }
        return drinkRepository.save(newDrink);
    }

    public Drink updateById(int id, Drink drink) throws InstanceNotFoundException {
        if (!drinkRepository.existsById(id)) {
            throw new InstanceNotFoundException();
        }
        drink.setId(id);
        return drinkRepository.save(drink);
    }
}
