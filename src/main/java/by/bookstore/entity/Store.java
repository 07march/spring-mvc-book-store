package by.bookstore.entity;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class Store implements Serializable {
    private int id;
    @Size(min = 2, max = 15, message = "enter 2 to 15 characters!")
    private String name;
    private Address address;
    private City city;

    public Store(@Size(min = 2, max = 15, message = "enter 2 to 15 characters!") String name) {
        this.name = name;
    }

    public Store() {
    }

    public Store(int id) {
        this.id = id;
    }

    public Store(int id, String name, Address address, City city) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public Store(String name, Address address, City city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(name, store.name) &&
                Objects.equals(address, store.address) &&
                Objects.equals(city, store.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, city);
    }
}
