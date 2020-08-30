package by.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {
    private int id;
    private List<Book> books = new ArrayList<>();
    private int total = 0;

    public void add(Book book) {
        books.add(book);
        total = total + book.getPrice().intValue();
    }

    public void delete(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                total = total - books.get(i).getPrice().intValue();
                books.remove(i);
                break;
            }
        }
    }

    public void clear() {
        total = 0;
        books.clear();
    }

    public boolean isEmpty() {
        int size = books.size();
        return size == 0;
    }
}
