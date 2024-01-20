package Tests;

import managers.InMemoryTaskManager;
import model.Status;
import model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HistoryManagerTest {
    InMemoryTaskManager manager = new InMemoryTaskManager();
    @Test
    void oldSavedObjectNotEqualWithUpdateObject() {
        Task tsk = new Task("Переезд", "Собрать все вещи, покинуть старую квартиру");
        manager.createTask(tsk);
        Task task  = manager.getTaskById(1);//добавляем в спсисок истории
        List<Task> histor = manager.getHistory();
        manager.updateTask(1, new Task("Переезд", "Собрать все вещи, покинуть старую квартиру", Status.IN_PROGRESS));
        Assertions.assertNotEquals(histor.get(0),manager.getTaskById(1),"Объект в списке истории обновляется в реальном времени");


    }
}
