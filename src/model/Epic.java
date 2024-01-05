package model;


import java.util.ArrayList;
import java.util.HashMap;

public class Epic extends Task {
    private HashMap<Integer, SubTask> subTasks;
    public Epic (String name, String description) {
        super(name, description);
        subTasks = new HashMap<>();
    }
    void addSubTasks(SubTask tsk) {
        subTasks.put(tsk.getId(), tsk);
    }

    public HashMap<Integer,SubTask> getSubTasks() {
        return subTasks;
    }

    @Override
    public String toString() {
        String reslt = "Epic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                "subTasks=[ "
                ;
        for (SubTask sbtsk: subTasks.values()) {
            reslt += sbtsk.getName() + " ";
        }
        reslt += "] }";
        return reslt;

    }
}