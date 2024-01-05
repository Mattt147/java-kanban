package task.pack;

public class Task {
    private int id;
    protected String name;
    protected Status status;
    protected String description;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = Status.NEW;
        id = this.hashCode();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
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
        if (name.equals(tsk.getName()) && status.equals(tsk.getStatus()) && description.equals(tsk.getDescription()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if (name != null || description == null || status == null) return 0;
        hash += name.hashCode();
        hash = hash * 31 + description.hashCode();
        hash = hash * 31 + status.hashCode();
        return hash;
    }

}
