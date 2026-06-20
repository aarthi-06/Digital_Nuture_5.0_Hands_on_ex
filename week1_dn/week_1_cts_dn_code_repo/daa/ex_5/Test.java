package daa.ex_5;

public class Test {



    public static void main(String[] args) {

        TaskLinkedList list = new TaskLinkedList();

        list.addTask(1, "Design", "Pending");
        list.addTask(2, "Coding", "In Progress");
        list.addTask(3, "Testing", "Pending");

        list.traverseTasks();

        System.out.println();

        list.deleteTask(2);

        list.traverseTasks();
    }
}


