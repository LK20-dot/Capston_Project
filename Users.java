package Model;

public class Users {
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;

    public Users(int id, String name, String email, String password, String role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override

    public String toString(){
        return String.format("User[ID: %d, Name: %s, Email: %s, Role: %s]", id, name, email, role);
    }

    public static void main(String[] args) {
        Users u1 = new Users(1, "Lalit", "lalitk7410@gmail.com", "Pass123@", "customer");
        Users u2 = new Users(1, "Lalit", "lalit@gmail.com", "pass@123", "Admin");

        System.out.println(u1);
        System.out.println(u2);
    }
}
