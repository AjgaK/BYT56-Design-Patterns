package BlogSystem_Memento_ObjectPool;
import java.util.Scanner;

public class BlogSystem {
    private static BlogPostPool blogPostPool = new BlogPostPool();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------------------");
            System.out.println("Enter a title to create or edit a post, type 0 to leave.");
            String title = scanner.nextLine();
            if (title.equals("0")) break;

            BlogPost post = blogPostPool.getBlogPost(title);

            System.out.println("\nCurrent Content: " + post.getContent());
            System.out.println("\nEnter new content (type 'undo' to revert changes, 'redo' to reapply): ");
            String content = scanner.nextLine();

            switch (content) {
                case "undo":
                    post.undo();
                    break;
                case "redo":
                    post.redo();
                    break;
                default:
                    post.setContent(content);
                    break;
            }

            System.out.println("\nUpdated Content: " + post.getContent());
        }
        scanner.close();
    }
}

