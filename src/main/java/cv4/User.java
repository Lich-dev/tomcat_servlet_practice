package cv4;

public class User {
    String name;
    String lastname;
    int age;
    String email;
    String password;
    public User(String name, String lastname, String age, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.age = Integer.parseInt(age);
        this.email = email;
        this.password = password;
    }
    public User(String name, String lastname, int age, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public String getFullName(){
        return name+" "+lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
