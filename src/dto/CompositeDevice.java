package dto;

import java.util.ArrayList;
import java.util.List;

public class CompositeDevice extends SimpleDevice {

    private List<IDevice> components;

    public CompositeDevice(Integer id, String name, String type, String category, String manufacturer) {
        super(id, name, type, category, manufacturer);
        components = new ArrayList<>();
    }

    public List<IDevice> getComponents() {
        return components;
    }

    public void setComponents(List<IDevice> components) {
        this.components = components;
    }

    public void addComponent(IUser user, IDevice component) { // TODO
        components.add(component);
    }

    public boolean deleteComponent(IUser user, IDevice component) {
        boolean result = false;
        // TODO check Permissions for user
        if (components.contains(component)) {
            components.remove(component);
            result = true;
        } else {
            System.out.println("Такого компонента не существует!");
        }
        return result;
    }
}
