package nimblix.in.HealthCareHub.response;

public class DepartmentResponse {

    private Long id;
    private String departmentName;
    private String description;

    public DepartmentResponse(Long id, String departmentName, String description) {
        this.id = id;
        this.departmentName = departmentName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDescription() {
        return description;
    }
}