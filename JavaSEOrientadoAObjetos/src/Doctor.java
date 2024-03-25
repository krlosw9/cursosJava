public class Doctor {
    private static int id = 0;
    private String name;
    private String speciality;

    Doctor (){
        System.out.println("Construyendo el objeto doctor");
        id++;
    }

    Doctor(String name){
        System.out.println("El nombre del doctor asignado es: "+name);
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}
