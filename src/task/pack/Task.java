package task.pack;

public class Task {
    private int id;
    protected String name;
    protected Progress prog;
    protected String description;

    public Task(String name, String description, Progress prog) {
        this.name = name;
        this.description = description;
        this.prog = prog;
        id = this.hashCode();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Progress getProg() {
        return prog;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        if (obj == null) return false;
        Task tsk = (Task) obj;
        if (name.equals(tsk.getName()) && prog.equals(tsk.getProg()) && description.equals(tsk.getDescription()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if (name != null || description == null || prog == null) return 0;
        hash += name.hashCode();
        hash = hash * 31 + description.hashCode();
        hash = hash * 31 + prog.hashCode();
        return hash;
    }

}
