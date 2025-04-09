package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.CarExpense;

public interface CarExpenseRepository extends JpaRepository<CarExpense, Long> {
}
