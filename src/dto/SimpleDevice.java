package dto;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class SimpleDevice implements IDevice {
    private Integer id;
    private String name;
    private String type;
    private String category;
    private String manufacturer;
    private Map<String, File> documentations;

    public SimpleDevice(Integer id, String name, String type, String category, String manufacturer) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.category = category;
        this.manufacturer = manufacturer;
        documentations = new TreeMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase().trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Map<String, File> getDocumentations() {
        return documentations;
    }

    public File getDocumentByName(String name) {
        if(documentations.containsKey(name)) {
            return documentations.get(name);
        } else {
            return null;
        }
    }

    public boolean addDocument(String name, File document) {
        documentations.put(name, document);
        return true;
    }

    public void setDocumentations(Map<String, File> documentations) {
        this.documentations = documentations;
    }

    @Override
    public String toString() {
        return "SimpleDevice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", documentations=" + documentations.toString() +
                '}';
    }
}
