// import static ui.UIMenu.*;

import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        //showMenu();

        Doctor myDoctor = new Doctor("Anahi Salgado", "ana@mail.com","Pediatria");
        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "1pm");

        for (Doctor.AvailableAppointment aA: myDoctor.getAvailableAppointments()) {
            System.out.println(aA.getDate() + " " + aA.getTime());
        }

        Patient myPatient = new Patient("Paciente1", "paciente1@gmail.com");
        System.out.println(myDoctor);
        System.out.println(myPatient);
    }
}
