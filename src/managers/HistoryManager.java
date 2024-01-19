package managers;

import model.Task;

import java.util.ArrayList;

interface HistoryManager {
    ArrayList<Task> getHistory();
    void add(Task task);
}
