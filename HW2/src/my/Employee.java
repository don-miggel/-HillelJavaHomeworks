package my;

public class Employee {

    private String firstName;
    private String middleName;
    private String lastName;
    private String position;
    private String phone;
    private String email;
    private int age;

    Employee(String firstName, String middleName, String lastName, String position, String phone,
             String email, int age){

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        Employee petr = new Employee("Petro", "Petrovich", "Petrenko",
                "Senior Java Engineer", "+38(050)123-45-67","ppp@ukr.net", 28);
        System.out.println(petr);
        petr.setAge(35);
        System.out.println(petr);
        petr.setPhone("+38(067)000-11-22");
        System.out.println(petr);
        petr.setEmail("pppetrenko@online.ua");
        System.out.println(petr);
    }



}

