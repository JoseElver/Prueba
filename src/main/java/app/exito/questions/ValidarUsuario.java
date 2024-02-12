package app.exito.questions;

import net.serenitybdd.screenplay.Question;
public class ValidarUsuario {
    public static Question<String> on() {
        return actor -> actor.recall("nombreUsuario");
    }
}
