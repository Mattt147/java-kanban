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
    void coreMethodsChek() {
        Task tsk = new Task("Переезд", "Собрать все вещи, покинуть старую квартиру");
        manager.createTask(tsk);
        tsk = new Task("Дз","Сделать до вечера два предмета");
        manager.createTask(tsk);
        Epic epic = new Epic("Проект","Сделать проект по прог");
        manager.createTask(epic);
        SubTask sbtsk = new SubTask(epic,"Отчет", "Сделать отчет по проекту");
        manager.createTask(sbtsk);
        sbtsk = new SubTask(epic,"Код", "Написать код по проекту");
        manager.createTask(sbtsk);
        Assertions.assertNotNull(manager.getEpics(),"Эпики не добавлись в список в менеджэре");
        Assertions.assertNotNull(manager.getTasks(),"Таски не добавлись в список в менеджэре");
        Assertions.assertNotNull(manager.getSubTasks(),"Субтаски не добавлись в список в менеджэре");
        Assertions.assertNotNull(manager.getTaskById(tsk.getId()),"Объект не выозвращается методом поиском по id");
    }
    //@Test
    //void conflictGeneratingIdWithSetId() { конфликкт заданного id с с генерируемым
    //В моем коде так как метод статистический для присвавивания id(также он приватный) то айди вообще никогда не задается
    // а только присваивается.
    //}
}
