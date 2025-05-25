package Notifactions;

public class LogNotifier implements Observer {
    @Override
    public void update(String message) {
        System.out.println("[LOG] " + message);
    }
}