package Repaso.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Twitter {
    private List<Usuario> usuarios;

    public Twitter() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public boolean newUser(String aCoolName) {
        if (this.screenNameIsUnique(aCoolName)) {
            this.usuarios.add(new Usuario(aCoolName));
            return true;
        } else {
            System.out.println("screenName not unique");
            return false;
        }
    }

    private boolean screenNameIsUnique(String aName) {
        for (Usuario u : this.usuarios) {
            if (u.getScreenName == aName) {
                return false;
            }
        }
        return true;
    }
}
