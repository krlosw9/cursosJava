// import static ui.UIMenu.*;

import java.util.Date;

import model.Doctor;
import model.ISchedulable;
import model.Patient;
import model.User;

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

        User anonymousUser = new User("Usuario anonimo", "anonimo@mail.com") {
            @Override
            public void showDataUser(){
                System.out.println("Usuario temporal");
                System.out.println("Dura muy poco y es solo un hack para: ");
                System.out.println("Poder crear una instancia de una clase abstracta");
            }
        };
        anonymousUser.showDataUser();

        ISchedulable iSchedulable = new ISchedulable(){
            @Override
            public void schedule(Date date, String time){
                //Esta tambien en una clase anonima, usada para crear una instancia de una interface
            }
        };
        iSchedulable.schedule(null, null);
    }
}
