package Entity.User;

public abstract class User {

    private int id;
    private String name;
    private int phoneNO;

    public abstract void getUserInfo();

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
    public int getPhoneNO() {
        return phoneNO;
    }
    public void setPhoneNO(int phoneNO) {
        this.phoneNO = phoneNO;
    }

}
