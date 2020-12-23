package dto;

import java.io.File;
import java.util.Map;

public interface IDevice {
    Integer getId();
    String getName();
    String getType();
    String getCategory();
    String getManufacturer();
    File getDocumentByName(String name);
    Map<String, File> getDocumentations();
}
