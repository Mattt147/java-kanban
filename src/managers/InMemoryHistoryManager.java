package managers;

import model.Epic;
import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryHistoryManager implements HistoryManager{
    private ArrayList<Task> tasksHistory;
    public InMemoryHistoryManager() {
        tasksHistory = new ArrayList<>();
    }
    @Override
    public ArrayList<Task> getHistory() {
        return tasksHistory;
    }
    @Override
    public void add(Task task) {
        if (tasksHistory.size() == 10 ) {
            tasksHistory.remove(0);
            tasksHistory.add(copyTask(task));
        }
        else {
            tasksHistory.add(copyTask(task));
        }
    }
    private Task copyTask(Task task) {
        if (task.getClass() == Task.class) {//копирование стандартного таска
            Task tsk = new Task(task.getName(), task.getDescription(), task.getStatus());
            tsk.setId(task.getId());
            return tsk;
        }
        else if (task.getClass() == Epic.class) {//копирование эпика
            Epic tsk = (Epic) task ;
            Epic epc = new Epic(tsk.getName(), tsk.getDescription());
            epc.setStatus(tsk.getStatus());
            HashMap<Integer, SubTask> map =  tsk.getSubTasks();
            HashMap<Integer, SubTask> epcMap = new HashMap<>();
            for (SubTask sbTsk : map.values()) {
                SubTask subTask = new SubTask(epc, sbTsk.getName(), sbTsk.getDescription(), sbTsk.getStatus());//копирование субтасков для словаря в эпике
                subTask.setId(sbTsk.getId());
                epcMap.put(subTask.getId(), subTask);
            }
            epc.setSubTasks(epcMap);
            return epc;
        }
        else {
            SubTask subTask = (SubTask) task;
            Epic epic = subTask.getEpic();//копирование эпика для его субтаска
            Epic epc = new Epic(epic.getName(), epic.getDescription());
            epc.setStatus(epic.getStatus());
            HashMap<Integer, SubTask> map =  epc.getSubTasks();
            HashMap<Integer, SubTask> epcMap = new HashMap<>();
            for (SubTask sbTsk : map.values()) {
                SubTask subiTask = new SubTask(epc, sbTsk.getName(), sbTsk.getDescription(), sbTsk.getStatus());
                subTask.setId(sbTsk.getId());
                epcMap.put(subTask.getId(), subTask);
            }
            SubTask subiTask = new SubTask(epc, subTask.getName(), subTask.getDescription(), subTask.getStatus());//копирование субтаска
            subiTask.setId(subiTask.getId());
            return subTask;
        }
    }
}
