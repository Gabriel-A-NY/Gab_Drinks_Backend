package ch.noseryoung.domain.drink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface DrinkRepository extends JpaRepository<Drink, Integer> {
}
