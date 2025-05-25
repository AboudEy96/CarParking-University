package Notifactions;

public class AdminNotifier implements Observer {
    @Override
    public void update(String message) {
        System.out.println("[ADMIN] Notification: " + message);
    }
}