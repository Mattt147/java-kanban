package managers;

import model.Epic;
import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TaskManager {
    String getListTasks();

    Task getTaskById(int id);

    void createTask(Task obj);

    void delAllTasks();

    void updateTask(int id, Task task);

    void delTaskById(int id);

    String getListSbTask(Epic epic);

    public List<Task> getHistory();

    public HashMap<Integer, Task> getTasks();

    public HashMap<Integer, Epic> getEpics();

    public HashMap<Integer, SubTask> getSubTasks() ;
}
