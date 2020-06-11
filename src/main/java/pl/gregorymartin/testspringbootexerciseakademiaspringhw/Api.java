package pl.gregorymartin.testspringbootexerciseakademiaspringhw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Api {
    private List<Person> people;

    public Api() {
        this.people = new ArrayList<>();
        people.add(new Person("Jan", "Nowak",Gender.Male));
        people.add(new Person("Stefan", "Spust",Gender.Male));
        people.add(new Person("Karol", "Dzikus",Gender.Male));
        people.add(new Person("Joanna", "Niebywała",Gender.Female));
        people.add(new Person("Katarzyna", "Dała",Gender.Female));
        people.add(new Person("Anna", "Niedała",Gender.Female));
        people.add(new Person("Mariola", "Przytyła",Gender.Female));
    }

    @GetMapping("/people/{limit}")
    public List<Person> getPeople(@PathVariable int limit){
        return people.subList(0,limit);
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
