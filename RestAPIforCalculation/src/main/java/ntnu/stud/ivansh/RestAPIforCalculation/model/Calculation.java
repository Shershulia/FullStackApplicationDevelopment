package ntnu.stud.ivansh.RestAPIforCalculation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Calculation(int id, String firstComponent, String secondComponent, String operation, String result, User user) {
        this.id = id;
        this.firstComponent = firstComponent;
        this.secondComponent = secondComponent;
        this.operation = operation;
        this.result = result;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
