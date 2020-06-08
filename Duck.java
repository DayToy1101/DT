package model;

public class Duck {
    private String name;
    private Integer age;

    public Duck(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Duck() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
