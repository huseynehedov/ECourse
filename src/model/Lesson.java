package model;

public class Lesson extends CourseModel{
    private String name;
    private Integer time;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id='" + super.getId() + '\'' +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", price=" + price +
                '}';
    }
}
