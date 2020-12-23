package dto;

public class User implements IUser{

    private Integer id;
    private String login;
    private String password;
    private String name;
    private UserRole role;
    private Permissions permissions;

    public User(Integer id, String login, String password, String name, UserRole role, Permissions permissions) {
        this.id = id;
        this.login = login;
        this. password = password;
        this.name = name;
        this.role = role;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public boolean checkPermission(String permission) {

        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", permissions=" + permissions +
                '}';
    }
}
