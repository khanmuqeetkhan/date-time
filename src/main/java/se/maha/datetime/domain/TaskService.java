package se.maha.datetime.domain;

//@Service
public class TaskService {

    private final DateTimeService time;

    public TaskService(DateTimeService time) {
        this.time = time;
    }

    public Task createTask() {
        return new Task(time.now());
    }

}