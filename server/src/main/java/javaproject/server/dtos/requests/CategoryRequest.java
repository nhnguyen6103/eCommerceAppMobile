package javaproject.server.dtos.requests;



public class CategoryRequest {
    private String name;
    private String description;

    public CategoryRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryRequest() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
