import java.util.*;

public class TimetableGenerator {
    public static void main(String[] args) {
        List<Teacher> teachers = Arrays.asList(new Teacher("Alice"), new Teacher("Bob"), new Teacher("Charlie"), new Teacher("John"), new Teacher("Mary"));
        List<Salle> salles = Arrays.asList(new Salle("Room 101"), new Salle("Room 102"), new Salle("Room 103"), new Salle("Room 104"), new Salle("Room 105"), new Salle("Room 106"), new Salle("Room 107"), new Salle("Room 108"), new Salle("Room 109"), new Salle("Room 110"));
        
        List<Filiere> filieres = Arrays.asList(new Filiere("Cybersecurity"), new Filiere("Mecanics"), new Filiere("Data & AI"));
        
        Module maths = new Module("Maths", teachers.get(0));
        Module pythonJava = new Module("Python & Java", teachers.get(1));
        Module databases = new Module("Databases", teachers.get(2));
        Module management = new Module("Management", teachers.get(3));
        Module tec = new Module("TEC", teachers.get(4));
        Module matlab = new Module("Matlab", teachers.get(0));
        Module os = new Module("Operating Systems", teachers.get(1));
        
        filieres.get(0).addModule(maths);
        filieres.get(0).addModule(pythonJava);
        filieres.get(0).addModule(databases);
        filieres.get(0).addModule(management);
        filieres.get(0).addModule(tec);
        filieres.get(0).addModule(matlab);
        filieres.get(0).addModule(os);
        
        Module algoC = new Module("Algorithms & C", teachers.get(2));
        Module machineLearning = new Module("Machine Learning", teachers.get(3));
        Module webDev = new Module("Web Development", teachers.get(4));
        
        filieres.get(2).addModule(maths);
        filieres.get(2).addModule(algoC);
        filieres.get(2).addModule(tec);
        filieres.get(2).addModule(management);
        filieres.get(2).addModule(machineLearning);
        filieres.get(2).addModule(matlab);
        filieres.get(2).addModule(webDev);
        
        filieres.get(1).addModule(new Module("Physics", teachers.get(0)));
        filieres.get(1).addModule(new Module("Mechanics", teachers.get(1)));
        filieres.get(1).addModule(new Module("Materials Science", teachers.get(2)));
        filieres.get(1).addModule(new Module("Thermodynamics", teachers.get(3)));
        filieres.get(1).addModule(new Module("Fluid Mechanics", teachers.get(4)));
        filieres.get(1).addModule(new Module("Control Systems", teachers.get(0)));
        filieres.get(1).addModule(new Module("Manufacturing Processes", teachers.get(1)));
        
        Schedule schedule = new Schedule();
        schedule.generateSchedule(filieres, salles);
        schedule.printSchedule();
    }
}
