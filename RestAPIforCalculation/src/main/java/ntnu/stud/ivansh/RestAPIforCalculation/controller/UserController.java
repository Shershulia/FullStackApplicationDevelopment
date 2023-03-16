package ntnu.stud.ivansh.RestAPIforCalculation.controller;

import jakarta.validation.Valid;
import ntnu.stud.ivansh.RestAPIforCalculation.model.Calculation;
import ntnu.stud.ivansh.RestAPIforCalculation.model.User;
import ntnu.stud.ivansh.RestAPIforCalculation.repositoryJpa.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        return repository.findAll();
    }
    @GetMapping(path = "/users/{id}")
    public User getUserUsingId(@PathVariable int id){
        return repository.findById(id).get();
    }

    @GetMapping(path = "/users/{name}/calculations")
    public List<Calculation> getCalculationsOfCertainUser(@PathVariable String name){
        return repository.findByName(name).getCalculations();
    }
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        if(repository.findByName(user.getName())==null) {
            User saved = repository.save(user);
            //return 201 for success
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(saved.getId()).toUri();
            return ResponseEntity.created(location).build();
        }else return null;
    }

}
