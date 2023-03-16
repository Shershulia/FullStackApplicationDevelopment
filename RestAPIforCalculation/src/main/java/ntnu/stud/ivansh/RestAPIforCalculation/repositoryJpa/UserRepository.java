package ntnu.stud.ivansh.RestAPIforCalculation.repositoryJpa;

import ntnu.stud.ivansh.RestAPIforCalculation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String author);
}
