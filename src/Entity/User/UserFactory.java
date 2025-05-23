package Entity.User;

import Entity.Admin.Admin;
import Entity.Customer;

public class UserFactory {

    /*/
    *   this methods creates the user with thier own role usages :
    *    User user = new User("ADMIN");
    *    user.etc...
    \*/
    public static User createUser(String type) {

        return switch (type) {
            case "Customer" -> new Customer();
            case "Admin" -> new Admin();
            default -> null;
        };
    }

}
