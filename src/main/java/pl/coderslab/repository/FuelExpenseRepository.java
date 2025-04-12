package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.FuelExpense;

public interface FuelExpenseRepository extends JpaRepository<FuelExpense, Long> {
}
