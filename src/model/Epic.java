package model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

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

    public void setSubTasks(HashMap<Integer, SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(subTasks, epic.subTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subTasks);
    }
}