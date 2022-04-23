package vn.techmaster.grud_job_list.model;

public enum Location {
    HANOI("Hanoi"), 
    HAIPHONG("Hai Phong"), 
    DANANG("Da Nang"), 
    HCM("Ho chi Minh");

    private String value;

    private Location(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
