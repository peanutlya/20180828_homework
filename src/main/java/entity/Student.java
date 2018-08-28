package entity;

import javax.servlet.annotation.WebListener;

@WebListener()
public class Student{
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String address;

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return username +
                "," + password +
                "," + age +
                "," + address ;
    }

    public Student(String username, String password, Integer age, String address) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.address = address;
    }

    public Student() {

    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
