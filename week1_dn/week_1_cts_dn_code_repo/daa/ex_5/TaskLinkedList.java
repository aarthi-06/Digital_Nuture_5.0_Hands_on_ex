package daa.ex_5;


public class TaskLinkedList {

    private Task head;

    public void addTask(int id, String name, String status) {

    Task newTask = new Task(id, name, status);

    if(head == null) {
        head = newTask;
        return;
    }

    Task temp = head;

    while(temp.next != null) {
        temp = temp.next;
    }

    temp.next = newTask;

    }


    public void traverseTasks() {

    Task temp = head;

    while(temp != null) {

        System.out.println(
            temp.taskId + " " +
            temp.taskName + " " +
            temp.status
        );

        temp = temp.next;
        }
    }


    public Task searchTask(int id) {

    Task temp = head;

    while(temp != null) {

        if(temp.taskId == id)
            return temp;

        temp = temp.next;
    }

    return null;
    }


    public void deleteTask(int id) {

    if(head == null)
        return;

    if(head.taskId == id) {
        head = head.next;
        return;
    }

    Task temp = head;

    while(temp.next != null &&
          temp.next.taskId != id) {

        temp = temp.next;
    }

    if(temp.next != null)
        temp.next = temp.next.next;

    }

}
