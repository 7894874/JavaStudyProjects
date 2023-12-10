package main;

import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoListController {

    @Autowired /// Чтобы репозиторий автоматически создавался и был доступен
    private TaskRepository taskRepository; /// Это импорт нашего репозитория

    @GetMapping("/todolist/")
    public List<Task> list() {

        // return Storage.getAllTasks();
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;

    }

    @PostMapping("/todolist/")
    public int add(Task task) {
        Task newTask = taskRepository.save(task);

        return newTask.getId();

    }

    @GetMapping("/todolist/{id}")
    public ResponseEntity get(@PathVariable int id) {

        //        Task task = Storage.getTask(id);
        //        if (task == null) {
        //            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        //        }
        //        return new ResponseEntity(task, HttpStatus.OK);

        Optional<Task> optionalTask = taskRepository.findById(id);

        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity(optionalTask.get(), HttpStatus.OK);

    }

    @GetMapping("/todolist/description/{id}")
    public ResponseEntity get2(@PathVariable int id) {
//        Task task = Storage.getTask(id);
//        String description = task.getDescription();
//        if (task == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//        return new ResponseEntity(description, HttpStatus.OK);

        Optional<Task> optionalTask = taskRepository.findById(id);
        String description = optionalTask.get().getDescription();
        if (optionalTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(description, HttpStatus.OK);
    }

    @DeleteMapping("/todolist/remove/{id}")
    public ResponseEntity deleteTask(@PathVariable int id) {

        Optional<Task> optionalTask = taskRepository.findById(id);
        taskRepository.deleteById(id);

        if (optionalTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalTask, HttpStatus.OK);
    }

    @DeleteMapping("/todolist/removeAll/")
    public ResponseEntity deleteAllTasks() {

//        List<Task> currentTaskList = Storage.getAllTasks();
//
//        if (currentTaskList.size() != 0) {
//            Storage.deleteAllTasks();
//            return new ResponseEntity("The list was cleared successful!", HttpStatus.OK);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The list is already empty!!!");

        if (taskRepository.count() > 0) {
            taskRepository.deleteAll();
            return new ResponseEntity("The list was cleared successful!", HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The list is already empty!!!");

    }

    @PutMapping("/todolist/put/{id}")
    public ResponseEntity updateTask(@PathVariable int id, Task task) {

//        Storage.updateTask(id, task);
//        try {
//            return new ResponseEntity(task, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }

        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            taskRepository.deleteById(id);
        }

        try {
            Task newTask = taskRepository.save(task);
            return new ResponseEntity(newTask, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
