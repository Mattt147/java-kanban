package model;

public class SubTask extends Task {
    private Epic epic ;
    public SubTask (Epic epic, String name, String description) {
        super(name, description);
        this.epic = epic ;
        this.epic.addSubTasks(this);
    }
    public SubTask(Epic epic, String name, String description, Status status) { //конструктор для обновления данных
        super(name,description,status);
        this.epic = epic;
    }
    public Epic getEpic(){
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "epic=" + epic.getName() +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }

}

