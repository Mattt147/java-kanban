package Tests;

import com.sun.source.tree.ImportTree;
import managers.InMemoryTaskManager;
import managers.Managers;
import managers.TaskManager;
import model.Status;
import model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TaskTest {
    Managers managers ;
    TaskManager tskManager ;
    InMemoryTaskManager manager  ;

    @BeforeEach
    void kuk() {
        managers = new Managers();
        tskManager = managers.getDefault();
        manager  = (InMemoryTaskManager) tskManager;

    }
    @Test
    void equalsTaskById() {
        Task tsk = new Task("Переезд", "Собрать все вещи, покинуть старую квартиру");
        manager.createTask(tsk);

        manager.updateTask(tsk.getId(), new Task("Переезд", "Собрать все вещи, покинуть старую квартиру", Status.DONE));
        Assertions.assertEquals(tsk,manager.getTaskById(tsk.getId()),"Объекты с одинаковым id, не являются одним и тем же обЪектом");
    }




}
