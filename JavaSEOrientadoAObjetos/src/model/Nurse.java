package model;

public class Nurse extends User{

    private String speciality;

    public Nurse(String name, String email) {
        super(name, email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    // Este metodo es obligatorio, porque la clase padre lo tiene como un metodo abstracto
    public void showDataUser(){
        System.out.println("Empleado Hostipal: Cruz roja");
        System.out.println("Departamento: Nutricion, Urgencias");
    }
}