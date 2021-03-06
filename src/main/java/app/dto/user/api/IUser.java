package app.dto.user.api;

public interface IUser {
    Integer getId();
    String getLogin();
    String getName();
    UserRole getRole();
    boolean checkPermission(String permission);

}
