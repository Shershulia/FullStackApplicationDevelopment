package ntnu.stud.ivansh.RestAPIforCalculation.controller;

import jakarta.validation.Valid;
import ntnu.stud.ivansh.RestAPIforCalculation.model.Calculation;
import ntnu.stud.ivansh.RestAPIforCalculation.repositoryJpa.CalculationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class CalculatorController {
    private CalculationRepository repository;

    public CalculatorController(CalculationRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/calculations")
    public List<Calculation> getAllCalculations(){
        return repository.findAll();
    }
    @GetMapping(path = "/calculations/{id}")
    public Calculation getCalculationUsingId(@PathVariable int id){
        return repository.findById(id).get();
    }
    @PostMapping(path = "/calculations")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Object> addCalculation(@Valid @RequestBody Calculation calculation){
        Calculation saved = repository.save(calculation);
        //return 201 for success
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
