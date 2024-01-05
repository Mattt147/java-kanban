package managera;

import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;
public class TaskManager {
    private HashMap<Integer, Task> tasks ;
    private HashMap<Integer, Epic> epics ;
    private HashMap<Integer, SubTask> subTasks ;
    public TaskManager() {
        tasks = new HashMap<>();
        epics = new HashMap<>();
        subTasks = new HashMap<>();

    }
    public String getListTasks() {
        String result = "";
        for (Task tsk : tasks.values()) {
            result  =result + tsk.getName() + "\n" ;
        }
        for (Epic epic : epics.values()) {
            ArrayList<SubTask> sbTsk = epic.getSubTasks();
            result += epic.getName() +" " + sbTsk.toString();
            result +="\n";
        }
        return result;
    }
    public Task getTaskById(int id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id);
        }
        if (epics.containsKey(id)) {
            return epics.get(id);
        }
        if (subTasks.containsKey(id)) {
            return subTasks.get(id);
        }
        return null;
    }
    public void createTask(Task obj) {
        if(obj.getClass() == Task.class) {
            Task tsk = (Task) obj ;
            tasks.put(tsk.getId(), tsk);

        }
        if (obj.getClass()== Epic.class) {
            Epic epc = (Epic) obj ;
            epics.put(epc.getId(), epc);
        }
        if (obj.getClass() == SubTask.class) {
            SubTask sbTsk = (SubTask) obj;
            Epic epic = sbTsk.getEpic();
            checkStatus(epic);
            subTasks.put(sbTsk.getId(), sbTsk);
        }
    }
    public void delAllTasks() {
        tasks.clear();
        epics.clear();
        subTasks.clear();

    }
    public void updateTask(int id, Task task) {
        if (epics.containsKey(id)) {
            Epic epic = epics.get(id) ;
            epic.setDescription( task.getDescription());
            epic.setName( task.getName());
        }
        if (tasks.containsKey(id)) {
            Task tsk = tasks.get(id);
            tsk.setDescription( task.getDescription());
            tsk.setName( task.getName());
            tsk.setStatus( task.getStatus());
        }
        if (subTasks.containsKey(id)) {
            SubTask sbTsk = subTasks.get(id);
            sbTsk.setDescription( task.getDescription());
            sbTsk.setName( task.getName());
            sbTsk.setStatus( task.getStatus());
            Epic epic = sbTsk.getEpic();
            checkStatus(epic);
        }
    }
    public void delTaskById(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        }
        if (epics.containsKey(id)) {
            epics.remove(id);
        }
        if (subTasks.containsKey(id)) {
            subTasks.remove(id);
        }
    }
    public String getListSbTask (Epic epic) {
        String result ;
        ArrayList<SubTask> sbTasks = epic.getSubTasks();
        result = sbTasks.toString();
        return result;
    }
    private void checkStatus(Epic epic) {
        int counterNew =0 ;
        int counterDone = 0;
        ArrayList<SubTask> sbTasks= epic.getSubTasks();
        for (SubTask tsk : sbTasks ) {
            if ( tsk.getStatus() == Status.NEW ) {
                counterNew++;
                if (counterDone!=0) {
                    epic.setStatus( Status.IN_PROGRESS);
                    return;
                }
            }
            if (tsk.getStatus() == Status.DONE ){
                counterDone++;
                if (counterNew!=0) {
                    epic.setStatus( Status.IN_PROGRESS);
                    return;
                }
            }
            if (tsk.getStatus() == Status.IN_PROGRESS) {
                epic.setStatus( Status.IN_PROGRESS);
                return;
            }
        }
        if (counterDone != 0) {
            epic.setStatus( Status.DONE);
        }
    }


}