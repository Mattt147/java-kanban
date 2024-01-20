package managers;

import model.Task;

import java.util.List;

interface HistoryManager {
    List<Task> getHistory();
    void add(Task task);
}
