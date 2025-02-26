import java.util.*;

class Teacher {
    String name;
    List<Module> modules;

    public Teacher(String name) {
        this.name = name;
        this.modules = new ArrayList<>();
    }

    public void addModule(Module module) {
        modules.add(module);
    }
}