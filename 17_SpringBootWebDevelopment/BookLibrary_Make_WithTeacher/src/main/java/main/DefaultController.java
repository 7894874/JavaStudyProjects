package main;

import main.model.Book;
import main.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {

    /// Подгружаем в контроллере репозиторий (базу данных)
    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public String index(Model model)
    /// В качестве параметра передаем класс 'Model' в качестве параметра указываем
    /// специальный класс в нем можно хранить переменные которые нужно передать в шаблон и напечатать в index.html
    {
        /// Получаем все книги из репозитория и кладем в ArrayList
        Iterable<Book> bookIterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : bookIterable) {
            books.add(book);
        }

        model.addAttribute("books", books);
        model.addAttribute("booksCount", books.size());

        return "index";
    }
}
