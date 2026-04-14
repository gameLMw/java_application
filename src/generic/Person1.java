package generic;

import java.util.Objects;

public class Person1 implements Comparable<Person1> {
    public String name;

    public int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person1() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person = (Person1) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //按照名字进行排序
    @Override
    public int compareTo(Person1 o) {
        return this.name.compareTo(o.name);
    }
}