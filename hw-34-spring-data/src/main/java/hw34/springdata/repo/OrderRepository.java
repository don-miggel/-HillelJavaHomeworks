package hw34.springdata.repo;

import hw34.springdata.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Set<Order> findByCostLessThan(Double cost);
    Set<Order> findByCostGreaterThan(Double cost);
    Set<Order> findByDate(LocalDate date);
    Set<Order> findByCostBetween(Double startCost, Double endCost);
    Set<Order> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
