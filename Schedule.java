import java.util.*;
class Schedule {
    static final String[] DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    static final String[] TIME_SLOTS = {"08:00 - 10:00", "10:00 - 12:00", "14:00 - 16:00", "16:00 - 18:00"};
    
    Map<String, List<String>> filiereSchedules;
    Set<String> occupiedSlots;
    Set<String> filiereTimeSlots;
    
    public Schedule() {
        filiereSchedules = new HashMap<>();
        occupiedSlots = new HashSet<>();
        filiereTimeSlots = new HashSet<>();
    }
    
    public void generateSchedule(List<Filiere> filieres, List<Salle> salles) {
        Random rand = new Random();
        
        for (Filiere filiere : filieres) {
            filiereSchedules.put(filiere.name, new ArrayList<>());
            
            for (Module module : filiere.modules) {
                boolean scheduled = false;
                
                for (String day : DAYS) {
                    for (String time : TIME_SLOTS) {
                        String teacherSlot = day + " " + time + " " + module.teacher.name;
                        String roomSlot = day + " " + time + " " + salles.get(rand.nextInt(salles.size())).name;
                        String filiereSlot = day + " " + time + " " + filiere.name;
                        
                        if (!occupiedSlots.contains(teacherSlot) && !occupiedSlots.contains(roomSlot) && !filiereTimeSlots.contains(filiereSlot)) {
                            Salle salle = salles.get(rand.nextInt(salles.size()));
                            String entry = day + " " + time + " | " + module.name + " | " + module.teacher.name + " | " + salle.name;
                            filiereSchedules.get(filiere.name).add(entry);
                            occupiedSlots.add(teacherSlot);
                            occupiedSlots.add(roomSlot);
                            filiereTimeSlots.add(filiereSlot);
                            scheduled = true;
                            break;
                        }
                    }
                    if (scheduled) break;
                }
            }
        }
    }
    
    public void printSchedule() {
        System.out.println("Generated Timetable:");
        for (String filiere : filiereSchedules.keySet()) {
            System.out.println("\nFiliere: " + filiere);
            for (String entry : filiereSchedules.get(filiere)) {
                System.out.println(entry);
            }
        }
    }
}