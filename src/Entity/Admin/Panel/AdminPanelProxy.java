package Entity.Admin.Panel;

public class AdminPanelProxy implements AdminPanel {
    private boolean hasPermission;
    private RealAdminPanel realPanel;

    public AdminPanelProxy(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    @Override
    public void access() {
        if (hasPermission) {
            if (realPanel == null) {
                realPanel = new RealAdminPanel();
            }
            realPanel.access();
        } else {
            System.out.println("Access Denied: You don't have permission to access Admin Panel.");
        }
    }
}
