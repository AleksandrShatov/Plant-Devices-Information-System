package dto;

import java.util.Map;
import java.util.TreeMap;

public class Permissions {

    private final Map<String, Boolean> permissions = new TreeMap<>();

    public Permissions() {
        addPermissions();
    }

    private void addPermissions() {
        //
        permissions.put("CAN_CREATE_USER", false);
        permissions.put("CAN_UPDATE_USER", false);
        permissions.put("CAN_USE_USER", false);
        permissions.put("CAN_DELETE_USER", false);
        //
        permissions.put("CAN_CREATE_DEVICE", false);
        permissions.put("CAN_UPDATE_DEVICE", false);
        permissions.put("CAN_USE_DEVICE", false);
        permissions.put("CAN_DELETE_DEVICE", false);
        //
        permissions.put("CAN_CREATE_WORK", false);
        permissions.put("CAN_UPDATE_WORK", false);
        permissions.put("CAN_USE_WORK", false);
        permissions.put("CAN_DELETE_WORK", false);
        //
        permissions.put("CAN_CREATE_MAINTENANCE", false);
        permissions.put("CAN_UPDATE_MAINTENANCE", false);
        permissions.put("CAN_USE_MAINTENANCE", false);
        permissions.put("CAN_DELETE_MAINTENANCE", false);
        //
        permissions.put("CAN_CREATE_TYPE", false);
        permissions.put("CAN_UPDATE_TYPE", false);
        permissions.put("CAN_USE_TYPE", false);
        permissions.put("CAN_DELETE_TYPE", false);
        //
        permissions.put("CAN_CREATE_CATEGORY", false);
        permissions.put("CAN_UPDATE_CATEGORY", false);
        permissions.put("CAN_USE_CATEGORY", false);
        permissions.put("CAN_DELETE_CATEGORY", false);
        //
        permissions.put("CAN_CREATE_MANUFACTURER", false);
        permissions.put("CAN_UPDATE_MANUFACTURER", false);
        permissions.put("CAN_USE_MANUFACTURER", false);
        permissions.put("CAN_DELETE_MANUFACTURER", false);
        //
        permissions.put("CAN_CREATE_PLACE", false);
        permissions.put("CAN_UPDATE_PLACE", false);
        permissions.put("CAN_USE_PLACE", false);
        permissions.put("CAN_DELETE_PLACE", false);
        //
        permissions.put("CAN_CREATE_LOCATION_POSITION", false);
        permissions.put("CAN_UPDATE_LOCATION_POSITION", false);
        permissions.put("CAN_USE_LOCATION_POSITION", false);
        permissions.put("CAN_DELETE_LOCATION_POSITION", false);

    }

}
