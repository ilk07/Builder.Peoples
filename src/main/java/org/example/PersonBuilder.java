package org.example;

public class PersonBuilder {
    private String name; //mandatory
    private String surname; //mandatory
    protected String address; //optional
    protected int age; //optional
    protected boolean hasAge; //mandatory

    //setters
    public PersonBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(final int age) {
        this.age = age;
        this.hasAge = true;
        if (age < 0) {
            this.hasAge = false;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean getHasAge() {
        return hasAge;
    }


    public Person build() {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be zero or greater");
        }
        if (name == null || name.length() == 0) {
            throw new IllegalStateException("Name can't be empty");
        }
        if (surname == null || surname.length() == 0) {
            throw new IllegalStateException("Surname can't be empty");
        }

        return new Person(this);
    }

}
