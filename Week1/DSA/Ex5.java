public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task(1, "Design UI", "Pending"));
        manager.addTask(new Task(2, "Implement Backend", "In Progress"));
        manager.addTask(new Task(3, "Write Tests", "Pending"));

        System.out.println("All Tasks:");
        manager.traverseTasks();

        System.out.println("Searching for Task ID 2:");
        Task found = manager.searchTask(2);
        System.out.println(found != null ? found : "Task not found");

        System.out.println("Deleting Task ID 2...");
        manager.deleteTask(2);

        System.out.println("All Tasks After Deletion:");
        manager.traverseTasks();
    }
}

class Node {
    Task data;
    Node next;

    public Node(Task data) {
        this.data = data;
        this.next = null;
    }
}

class TaskManager {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("Added: " + task.taskName);
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.data.taskId == taskId)
                return current.data;
            current = current.next;
        }
        return null;
    }

    public void deleteTask(int taskId) {
        if (head == null) return;

        if (head.data.taskId == taskId) {
            head = head.next;
            System.out.println("Deleted Task ID: " + taskId);
            return;
        }

        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.data.taskId == taskId) {
                prev.next = current.next;
                System.out.println("Deleted Task ID: " + taskId);
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("Task ID not found: " + taskId);
    }
}
class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String toString() {
        return "[Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status + "]";
    }
}
