import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private String city;
    private OptionalInt age = OptionalInt.empty();

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 125) {
            throw new IllegalArgumentException("Введен недопустимый возраст.");
        } else {
            this.age = OptionalInt.of(age);
            return this;
        }
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name == null || name.isBlank() || surname == null || surname.isBlank()) {
            throw new IllegalStateException("Не все обязательные поля заполнены.");
        }
        Person person = new Person(name, surname, age, city);
        return person;
    }
}
