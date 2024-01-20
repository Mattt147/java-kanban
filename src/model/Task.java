package model;

public class Task {
    protected int id;
    protected String name;
    protected Status status;
    protected String description;
    private static int count = 0;


    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = Status.NEW;
        this.id = generateId();
    }
    public Task(String name, String description, Status status) { //конструктор для обновления данных
        this.name = name;
        this.description = description;
        this.status = status;
        this.id = generateId();
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

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }
    private static   Integer generateId() { return ++count; }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
