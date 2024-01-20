package Tests;

import model.Epic;
import model.SubTask;
import model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import managers.InMemoryTaskManager;

public class InMemoryTaskManagerTest {
    InMemoryTaskManager manager ;
    @BeforeEach
    void kuk() {
        manager = new InMemoryTaskManager();
    }
    @Test
    void createTask() {
        Task tsk = new Task("Переезд", "Собрать все вещи, покинуть старую квартиру");
        manager.createTask(tsk);
        Assertions.assertEquals(1,manager.getTasks().size(),"Таски не добавлись в список в менеджэре");
        manager.delAllTasks();
        Epic epic = new Epic("Проект","Сделать проект по прог");
        manager.createTask(epic);
        Assertions.assertEquals(0,manager.getTasks().size(),"Эпики вложилсь с ловарь тасков");
    }
    @Test
    void createEpic() {
        Epic tsk = new Epic("Переезд", "Собрать все вещи, покинуть старую квартиру");
        manager.createTask(tsk);
        Assertions.assertEquals(1,manager.getEpics().size(),"епик не добавлс в список в менеджэре");
        manager.delAllTasks();
        SubTask sbtsk= new SubTask(tsk,"Проект","Сделать проект по прог");
        manager.createTask(sbtsk);
        Assertions.assertEquals(0,manager.getEpics().size(),"субтаски вложилсь в словарь эпиков");
    }
    @Test
    void createSubTask() {
        Epic tsk = new Epic("Переезд", "Собрать все вещи, покинуть старую квартиру");
        manager.createTask(tsk);
        SubTask sbtsk= new SubTask(tsk,"Проект","Сделать проект по прог");
        manager.createTask(sbtsk);
        Assertions.assertEquals(1,manager.getSubTasks().size(),"субтаск не попал в словарь субтасков ");
        Task task = new Task("Дз","Сделать до вечера два предмета");
        manager.delAllTasks();
        manager.createTask(task);
        Assertions.assertEquals(0,manager.getSubTasks().size(),"таск  попал в словарь субтасков ");
    }
    @Test
    void getByIdTask() {
        Task tsk = new Task("Переезд", "Собрать все вещи, покинуть старую квартиру");
        manager.createTask(tsk);
        Assertions.assertNotNull(manager.getTaskById(tsk.getId()), "Задача не вернулсаь по id");
        Assertions.assertNull(manager.getTaskById(tsk.getId()+1),"задача с несуществующим id вернулась ");
    }
    @Test
    void getByIdEpic() {
        Epic epic = new Epic("Переезд", "Собрать все вещи, покинуть старую квартиру");
        manager.createTask(epic);
        Assertions.assertNotNull(manager.getTaskById(epic.getId()), "epic не вернулсаь по id");
        Assertions.assertNull(manager.getTaskById(epic.getId()+1),"epicс несуществующим id вернулась ");
    }
    @Test
    void getByIdSubTask() {
        Epic epic = new Epic("Переезд", "Собрать все вещи, покинуть старую квартиру");
        manager.createTask(epic);
        SubTask tsk = new SubTask(epic, "УБорка", "Убраться перед отъездом");
        manager.createTask(tsk);
        Assertions.assertNotNull(manager.getTaskById(tsk.getId()), "subTask не вернулсаь по id");
        Assertions.assertNull(manager.getTaskById(tsk.getId()+1),"subTask с несуществующим id вернулась ");
    }
}
