package org.example;

import java.util.OptionalInt;

public class Person {
    protected String name;
    protected String surname;
    protected String address;
    protected int age;
    protected boolean hasAge;

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.surname = personBuilder.getSurname();
        this.age = personBuilder.getAge();
        this.address = personBuilder.getAddress();
        this.hasAge = personBuilder.getHasAge();
    }

    public Person(String name, String surname) {
        Person person = new PersonBuilder()
                .setName(name)
                .setSurname(surname)
                .build();
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAddress(this.address);
    }

    public Person(String name, String surname, int age) {
        Person person = new PersonBuilder()
                .setName(name)
                .setSurname(surname)
                .setAge(age)
                .build();
    }

    /*has adress, has age*/
    public boolean hasAge() {
        return this.hasAge;
    }

    public boolean hasAddress() {
        if (address != null) {
            return true;
        }
        return false;
    }

    /*getters*/
    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    /* setters*/
    public void setAddress(String address) {
        this.address = address;
    }

    /*add edge in Birthday*/
    public void happyBirthday() {
        if (hasAge) {
            this.age += 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
                .append(name)
                .append(" ")
                .append(surname)
                .append(" (");

        if (hasAge) {
            builder.append(age + " ");
        }
        if (hasAddress()) {
            builder.append(address);
        }
        builder.append(")");
        return builder.toString();
    }

//    @Override
//    public int hashCode() { /*...*/ }


}
