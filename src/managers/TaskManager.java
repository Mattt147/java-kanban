package managers;

import model.Epic;
import model.Task;

import java.util.ArrayList;

public interface TaskManager {
    String getListTasks();

    Task getTaskById(int id);

    void createTask(Task obj);

    void delAllTasks();

    void updateTask(int id, Task task);

    void delTaskById(int id);

    String getListSbTask(Epic epic);
}
