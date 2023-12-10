package main;

import main.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {

    private static int currentId = 1;
    private static HashMap<Integer, Task> tasks = new HashMap<Integer, Task>();

    public static List<Task> getAllTasks() {
        ArrayList<Task> todoList = new ArrayList<Task>();
        todoList.addAll(tasks.values());
        return todoList;
    }

    public static void deleteAllTasks() {
        if (tasks.size() != 0) {
            tasks.clear();
        } else System.out.println("Already empty!!!");
    }

    public static int addTask(Task task) {
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static Task getTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            return tasks.get(taskId);
        }
        return null;
    }

    public static void deleteTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);
        }
    }

    public static Task getdescription(int id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id);
        }
        return null;
    }

    public static int updateTask(int taskId, Task task) {

        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);
        }

        task.setId(taskId);
        tasks.put(taskId, task);

        return taskId;

    }
}
