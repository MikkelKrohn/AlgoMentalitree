public class TaskModel {
    String taskName;
    String taskShortDescription;
    String category;
    String helpText;
    String taskId;
    boolean completed = false;


    //constructor for use in get data from db
    public TaskModel(String taskName, String taskShortDescription, String category, String helpText, String taskId) {
        this.taskName = taskName;
        this.taskShortDescription = taskShortDescription;
        this.category = category;
        this.helpText = helpText;
        this.taskId = taskId;
        this.completed = false;
    }

    public TaskModel(){
    }


    public String getTaskName() {
        return taskName;
    }

    public String getTaskShortDescription() {
        return taskShortDescription;
    }

    public String getCategory() {
        return category;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getHelpText() {
        return helpText;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
