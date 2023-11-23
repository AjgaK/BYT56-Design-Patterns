package BlogSystem_Memento_ObjectPool;
import java.util.Stack;

public class BlogPost {
    private String content = "Null.";
    private Stack<BlogPostMemento> history = new Stack<>();
    private Stack<BlogPostMemento> redoHistory = new Stack<>();
    public void setContent(String content) {
        save();
        this.content = content;
        redoHistory.clear();
    }

    public String getContent() {
        return content;
    }

    private void save() {
        history.push(new BlogPostMemento(content));
    }

    public void undo() {
        if (!history.isEmpty()) {
            saveToRedoHistory();
            content = history.pop().getContent();
        }
    }

    private void saveToRedoHistory() {
        redoHistory.push(new BlogPostMemento(content));
    }
    public void redo() {
        if (!redoHistory.isEmpty()) {
            save();
            content = redoHistory.pop().getContent();
        }
    }
}

