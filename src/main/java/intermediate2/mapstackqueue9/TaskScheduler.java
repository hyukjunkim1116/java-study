package intermediate2.mapstackqueue9;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class TaskScheduler {
    private Queue<Task> tasks = new ArrayDeque<>();

    public void addTask(Task task) {
        tasks.offer(task);
    }

    public int getRemainingTasks() {
        return tasks.size();
    }

    public void processNextTask() {
        Task poll = tasks.poll();
        Objects.requireNonNull(poll).execute();
    }
}
