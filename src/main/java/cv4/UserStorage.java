package cv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserStorage {
    private static List<User> registeredUsers = new ArrayList<>();
    public static boolean registerUser(User user){
        for (User registeredUser : registeredUsers) {
            if (Objects.equals(registeredUser.email, user.email)) {
                return false;
            }
        }
        registeredUsers.add(user);
        return true;
    }
    public static User loginUser(String email, String password){
        for (User registeredUser : registeredUsers) {
            if (Objects.equals(registeredUser.email, email)) {
                if (Objects.equals(registeredUser.password,password)){
                    return registeredUser;
                }else{
                    return null;
                }
            }
        }
        return null;
    }
    public static User getUser(String email){
        for (User registeredUser : registeredUsers) {
            if (Objects.equals(registeredUser.email, email)) {
                return registeredUser;
            }
        }
        return null;
    }
    /*private static boolean userExists(String email){
        for (User registeredUser : registeredUsers) {
            if (Objects.equals(registeredUser.email, email)) {
                return true;
            }
        }
        return false;
    }*///kinda useless
}
