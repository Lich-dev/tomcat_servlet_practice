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
        if(/*user.email.contains("@") && user.email.contains(".") &&*/
                user.password.length()>5
                && user.age>18){
            registeredUsers.add(user);
            return true;
        }else{
            return false;
        }
    }
}
