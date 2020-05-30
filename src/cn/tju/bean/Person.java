package cn.tju.bean;


import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
    private String Name;
    private Integer age;
    private  String gender;
    private String email;

    private Car car;
    private List<Book> books;
    private Map<String, Object> maps;
    private Properties properties;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Person(){
        super();
        System.out.println("person创建了");

    }


    public Person(String name, Integer age, String gender, String email) {
        Name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        System.out.println("有参构造器");
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        System.out.println("setName...."+name);
        Name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", car=" + car +
                ", books=" + books +
                ", maps=" + maps +
                ", properties=" + properties +
                '}';
    }
}
