package main;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {

    //// Подгружаем в контроллер репозиторий
    @Autowired /// Чтобы репозиторий автоматически создавался и был доступен
    private TaskRepository taskRepository; /// Это импорт нашего репозитория

    /// Чтобы подгрузить нужный параметр, нужно прописать его явно таким вот образом
    @Value("${someParameter.value}")
    private Integer someParameter;

    @RequestMapping("/")
    public String index(Model model) {
        /// В качестве параметра передаем класс 'Model'
        /// это специальный класс в нем можно хранить переменные которые
        /// нужно передать в шаблон и напечатать в index.html

        /// Получаем все списки дел из репозитория и кладем в ArrayList
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }

        model.addAttribute("tasks", tasks);
        model.addAttribute("tasksCount", tasks.size());
        model.addAttribute("someParameter", someParameter);

        return "index";

    }
}
