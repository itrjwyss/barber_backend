package meso.itrjwyss.barberia.data;

public class ListData {

    private Long id;
    private String label;

    public ListData() {
    }

    public ListData(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
