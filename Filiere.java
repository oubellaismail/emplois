import java.util.*;

class Filiere {
    String name;
    List<Module> modules;

    public Filiere(String name) {
        this.name = name;
        this.modules = new ArrayList<>();
    }

    public void addModule(Module module) {
        modules.add(module);
    }
}

