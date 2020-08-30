package by.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int id;

    @Size(min = 2, message = "enter more then 2 characters!")
    private String name;

    public Address(@Size(min = 2, message = "enter more then 2 characters!") String name) {
        this.name = name;
    }
}
