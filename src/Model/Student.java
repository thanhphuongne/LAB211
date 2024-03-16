/*
Mỗi đối tượng sinh viên có các thuộc tính sau
id, name, age, address và gpa
yc: tạo ra menu với các chức năng:
- add student
- delete by id
- edit name, age, address by id
- show student
- exit

*/
package Model;

import java.util.Objects;

public class Student {
    //thiet lap thuoc tính
    private String id;
    private String name;
    private int age;
    private String address;
    private double gpa;

    public Student() {
    }

    public Student(String id, String name, int age, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public Student(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


    @Override
    public boolean equals(Object student) {
        Student s =(Student) student;
        return s.getId().equals(this.id);
    }

    @Override
    public String toString() {
        return  id + "|" + name + "|" + age + "|" + address + "|" + gpa ;
    }
    
    public int compareTo(Student s)
    {
        return this.getName().compareTo(s.getId());
    }
    
}
