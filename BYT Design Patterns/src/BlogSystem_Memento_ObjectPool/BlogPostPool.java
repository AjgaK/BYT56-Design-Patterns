package BlogSystem_Memento_ObjectPool;
import java.util.HashMap;
import java.util.Map;

public class BlogPostPool {
    private Map<String, BlogPost> pool = new HashMap<>();

    public BlogPost getBlogPost(String title) {
        if (!pool.containsKey(title)) {
            pool.put(title, new BlogPost());
        }
        return pool.get(title);
    }
}


