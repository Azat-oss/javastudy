package ru.trop.lesson_5;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Person {

    private final int code;
    private final UUID id;
    private String name;
    private String city;
    private Fine fine;
    private List<String> fineDetails;

    public Person(String name, String city, Fine fine) {
        this.code = IdGenerator.getInstance().getNextId();
        this.id = UUID.randomUUID();
        this.name = name;
        this.city = city;
        this.fine = fine;
        this.fineDetails = new ArrayList<>();
    }

    public int getCode() { return code; }
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getCity() { return city; }
    public Fine getFineType() { return fine; }
    public List<String> getFineDetails() { return fineDetails; }


    public void setName(String name) { this.name = name; }
    public void setCity(String city) { this.city = city; }
    public void setFineType(Fine fine) { this.fine = fine; }

    public void addFine(String description) {
        this.fineDetails.add(description);
    }

    public boolean removeFine(String description) {
        return this.fineDetails.remove(description);
    }


    @Override
    public String toString() {
        return "Person {" +
                "Код=" + code +
                ", ID=" + id +
                ", Имя='" + name + '\'' +
                ", Город='" + city + '\'' +
                ", Тип штрафа=" + fine +
                ", Штрафы=" + fineDetails +
                '}';
    }
}
