package task.pack;

import task.pack.Task;

import java.util.ArrayList;
public class Epic extends Task {
    private ArrayList<SubTask> subTasks;
    public Epic (String name, String description) {
        super(name, description, Progress.NEW);
        subTasks = new ArrayList<>();
    }
    void addSubTasks(SubTask tsk) {
        subTasks.add(tsk);
    }

    public ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }
    void checkProg() {
        int counterNew =0 ;
        int counterDone = 0;
        for (SubTask tsk : subTasks ) {
            if ( tsk.getProg() == Progress.NEW ) {
                counterNew++;
                if (counterDone!=0) {
                    super.prog = Progress.IN_PROGRESS;
                    return;
                }
            }
            if (tsk.getProg() == Progress.DONE ){
                counterDone++;
                if (counterNew!=0) {
                    super.prog= Progress.IN_PROGRESS;
                    return;
                }
            }
            if (tsk.getProg() == Progress.IN_PROGRESS) {
                super.prog =Progress.IN_PROGRESS;
                return;
            }
        }
        if (counterDone != 0) {
            super.prog= Progress.DONE;
        }
    }


}