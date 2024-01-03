package task.pack;

public class SubTask extends task.pack.Task {
    private task.pack.Epic epic ;
    public SubTask (task.pack.Epic epic, String name, String description, Progress prog) {
        super(name, description, prog);
        this.epic = epic ;
        this.epic.addSubTasks(this);
        epic.checkProg();

    }
    public task.pack.Epic getEpic(){
        return epic;
    }



}

