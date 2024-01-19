package Tests;

import managers.InMemoryTaskManager;
import managers.Managers;
import managers.TaskManager;
import model.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EpicTest {
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
        Epic epic = new Epic("Проект","Сделать проект по прог");
        manager.createTask(epic);
        manager.updateTask(epic.getId(), new Epic("Проект","Сделать базу данных"));
        Assertions.assertEquals(epic, manager.getTaskById(epic.getId()), "эпики с одинаковым индексом не совпадают");
    }
   // void epicCantBeSubTaskForHim() {
    // тут должен быть тест на проверку добваление эпика в самого себя как сабтаск. Так как у меня в коде добавление
    // сабтаска в эпик, к которому он принадлежит, происходит при создании сабтаска(и метод добавление сабтаска протектед)
    // этой ошибки впринципе не может быть
    // если это неправильно, и тест имеет место быть. Более подробно пояснить за эту ошибку.
    //}
}
