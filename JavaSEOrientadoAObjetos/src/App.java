// import static ui.UIMenu.*;

import java.util.Date;

import model.Doctor;
import model.Patient;

public class App {
    public static void main(String[] args) throws Exception {
        //showMenu();

        Doctor myDoctor = new Doctor("Anahi Salgado", "ana@mail.com","Pediatria");
        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "1pm");
        System.out.println(myDoctor);

        Patient myPatient = new Patient("Paciente1", "paciente1@gmail.com");
        System.out.println(myPatient);
    }
}
