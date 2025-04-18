package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Trip;


public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip getTripById(Long id);
}
