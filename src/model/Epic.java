package task.pack;


import java.util.ArrayList;
public class Epic extends Task {
    private ArrayList<SubTask> subTasks;
    public Epic (String name, String description) {
        super(name, description);
        subTasks = new ArrayList<>();
    }
    void addSubTasks(SubTask tsk) {
        subTasks.add(tsk);
    }

    public ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }
    void checkStatus() {
        int counterNew =0 ;
        int counterDone = 0;
        for (SubTask tsk : subTasks ) {
            if ( tsk.getStatus() == Status.NEW ) {
                counterNew++;
                if (counterDone!=0) {
                    super.status = Status.IN_PROGRESS;
                    return;
                }
            }
            if (tsk.getStatus() == Status.DONE ){
                counterDone++;
                if (counterNew!=0) {
                    super.status= Status.IN_PROGRESS;
                    return;
                }
            }
            if (tsk.getStatus() == Status.IN_PROGRESS) {
                super.status = Status.IN_PROGRESS;
                return;
            }
        }
        if (counterDone != 0) {
            super.status= Status.DONE;
        }
    }


}