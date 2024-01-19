package Tests;

import managers.InMemoryTaskManager;
import managers.Managers;
import managers.TaskManager;
import model.Epic;
import model.Status;
import model.SubTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubTaskTest {
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
    void equalsEpicById() {
        Epic epic = new Epic("Проект", "Сделать проект по прог");
        manager.createTask(epic);
        SubTask sbtsk = new SubTask(epic, "Алгоритм", "ПОстроить алгоритма решения задачи");
        manager.createTask(sbtsk);
        manager.updateTask(sbtsk.getId(), new SubTask(epic, "Алгоритм", "ПОстроить алгоритма решения задачи", Status.IN_PROGRESS));
        Assertions.assertEquals(sbtsk, manager.getTaskById(sbtsk.getId()), "Сбутаски с одинаковым id не один и тот же обЪект");
    }

   // void subTaskCantBeHimEoic() { проверка на то что сабтаск не может стать своим эпиком
    //Здесь же этот тест не имеет ссмысла ведь, в моей программе при создании сабтаска(в его конструкторе указывается эпик к которому он относится)
    // если это неправильно, и тест имеет место быть. Более подробно пояснить за эту ошибку.
    //}
}

