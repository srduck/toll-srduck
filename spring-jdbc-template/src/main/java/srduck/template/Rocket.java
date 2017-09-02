package srduck.template;

public class Rocket {

    private int id;
    private String model;

    public Rocket(){}

    public Rocket(int id, String model) {
        this.id = id;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "id=" + id +
                ", model='" + model + '\'' +
                '}';
    }
}
