package cn.tju.bean;

public class Person {
    private String Name;
    private Integer age;
    private  String gender;
    private String email;

    public Person(){
        super();
        System.out.println("person创建了");

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
                '}';
    }
}
