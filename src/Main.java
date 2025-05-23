import Entity.User.User;
import Entity.User.UserFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        User user = UserFactory.createUser("Customer");
        user.setName("test");
        user.getUserType();

    }
}