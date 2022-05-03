import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    protected final String surname;
    protected String city;
    protected OptionalInt age = OptionalInt.empty();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, OptionalInt age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        if (city != null) {
            if (!city.isBlank()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public boolean happyBirthday() {
        if (this.hasAge()) {
            age = OptionalInt.of(age.getAsInt() + 1);
            return true;
        }
        return false;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(this.surname);
        return childBuilder;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Имя: " + name + ", Фамилия: " + surname);
        if (this.hasAge()) {
            str.append(", Возраст: " + age.getAsInt());
        }
        if (this.hasAddress()) {
            str.append(", Город проживания: " + city);
        }
        return str.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }


}
