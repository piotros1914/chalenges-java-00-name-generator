package piotrowski.patryk.namegenerator.entity;

import piotrowski.patryk.namegenerator.entity.enums.Country;
import javax.persistence.*;

@Entity()
@Table(name = "lastname")
public class Lastname {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String lastname;

    @Enumerated(EnumType.STRING)
    private Country country;

    public Lastname(){

    }

    public Lastname(String lastname) {
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Lastname{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", country=" + country +
                '}';
    }
}