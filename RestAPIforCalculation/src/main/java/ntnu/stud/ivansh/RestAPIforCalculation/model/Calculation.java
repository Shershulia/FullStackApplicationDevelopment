package ntnu.stud.ivansh.RestAPIforCalculation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@Entity
public class Calculation {
    @Id
    @GeneratedValue
    private int id=0;
    private String firstComponent;
    private String secondComponent;
    @Size( max = 1)
    private String operation;
    private String result;

    public Calculation(String firstComponent, String secondComponent, String operation, String result) {
        this.firstComponent = firstComponent;
        this.secondComponent = secondComponent;
        this.operation = operation;
        this.result = result;
    }

    public Calculation() {

    }

    public String getFirstComponent() {
        return firstComponent;
    }

    public void setFirstComponent(String firstComponent) {
        this.firstComponent = firstComponent;
    }

    public String getSecondComponent() {
        return secondComponent;
    }

    public void setSecondComponent(String secondComponent) {
        this.secondComponent = secondComponent;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
