import managers.TaskManager;
import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        TaskManager tskMan = new TaskManager();
        Task tsk = new Task("Переезд", "Собрать все вещи, покинуть старую квартиру");
        tskMan.createTask(tsk);
        tsk = new Task("Дз","Сделать до вечера два предмета");
        tskMan.createTask(tsk);
        Epic epic = new Epic("Проект","Сделать проект по прог");
        tskMan.createTask(epic);
        SubTask sbtsk = new SubTask(epic,"Отчет", "Сделать отчет по проекту");
        tskMan.createTask(sbtsk);
        sbtsk = new SubTask(epic,"Код", "Написать код по проекту");
        tskMan.createTask(sbtsk);
        epic = new Epic("Подготовка к вечеринке","Подготовиться к вечерней вечеринке");
        tskMan.createTask(epic);
        sbtsk = new SubTask(epic, "Закупка","Купить снеков и напитков");
        tskMan.createTask(sbtsk);
        System.out.println(tskMan.getListTasks());
        tsk = new Task("Переезд", "Собрать все вещи, покинуть старую квартиру", Status.DONE);
        tskMan.updateTask(1, tsk);
        tsk = tskMan.getTaskById(1);
        System.out.println(tsk.toString());
        tsk = new Task("Дз","Сделать до вечера два предмета",Status.IN_PROGRESS);
        tskMan.updateTask(2, tsk);
        tsk = tskMan.getTaskById(2);
        System.out.println(tsk.toString());
        epic = (Epic)tskMan.getTaskById(3);
        sbtsk = new SubTask(epic,"Отчет", "Сделать отчет по проекту", Status.IN_PROGRESS);
        tskMan.updateTask(4,sbtsk);
        System.out.println(tskMan.getTaskById(4).toString());
        sbtsk = new SubTask(epic,"Код", "Написать код по проекту", Status.DONE);
        tskMan.updateTask(5,sbtsk);
        System.out.println(tskMan.getTaskById(5).toString());
        System.out.println(epic.toString());
        tskMan.delTaskById(5);
        System.out.println(tskMan.getListTasks());
        System.out.println(epic.toString());
        tskMan.delTaskById(4);
        tskMan.delTaskById(1);
        System.out.println(epic.toString()  );
        System.out.println(tskMan.getListTasks());




    }
}
