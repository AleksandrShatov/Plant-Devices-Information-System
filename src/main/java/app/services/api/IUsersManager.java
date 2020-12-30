package app.services.api;

import app.dto.user.Permissions;
import app.dto.user.api.IUser;
import app.dto.user.api.UserRole;

import java.util.List;

public interface IUsersManager {
    List<IUser> getByLogin(String login);
    List<IUser> getByName(String name);
    List<IUser> getByRole(UserRole role);
    List<IUser> getByPermissions(Permissions permissions);

// boolean changeUserLogin(IUser, IUser, String);
// boolean changeUserPassword(IUser, IUser, String);
// boolean changeUserName(IUser, IUser, String);
// boolean changeUserRole(IUser, IUser, RoleEnum);
// void changeUserPermissions(IUser, IUser, Permissions);

}
