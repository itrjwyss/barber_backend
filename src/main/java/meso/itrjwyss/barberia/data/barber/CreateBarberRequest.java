package meso.itrjwyss.barberia.data.barber;

public class CreateBarberRequest {

    private String name;

    public boolean isValid() {
        return (name != null && !name.isEmpty());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
