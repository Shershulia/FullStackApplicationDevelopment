package ntnu.stud.ivansh.RestAPIforCalculation.repositoryJpa;

import ntnu.stud.ivansh.RestAPIforCalculation.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CalculationRepository extends JpaRepository<Calculation,Integer> {
}
