package Database;

public class DBTest {
    public static void main(String[] args) {
        try {
            if (DB.getConnection() != null) {
                System.out.println("Database Connected Successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
