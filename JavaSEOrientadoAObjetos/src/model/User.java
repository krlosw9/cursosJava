package model;

// Una clase abstracta no puede ser instanciada
// Esta clase solo es utilizada para ser Heredada y no instanciada
// Las clases padre nunca pueden ser instanciadas, por eso las clases padres son Abstractas
public abstract class User {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 0) {
            this.phoneNumber = phoneNumber;
        }else{
            System.out.println("El numero de telefono debe ser de 8 caracteres");
        }
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + 
        address + ", phoneNumber="+ phoneNumber + "]";
    }

    
}