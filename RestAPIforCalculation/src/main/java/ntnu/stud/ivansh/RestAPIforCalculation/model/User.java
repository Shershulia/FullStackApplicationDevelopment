package ntnu.stud.ivansh.RestAPIforCalculation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    private String password;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Calculation> calculations;

    public User() {

    }

    public User(int id, String name, String password, List<Calculation> calculations) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.calculations = calculations;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String  getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Calculation> getCalculations() {
        return calculations;
    }

    public void setCalculations(List<Calculation> calculations) {
        this.calculations = calculations;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
