package app.exito.questions;

import net.serenitybdd.screenplay.Question;
public class ValidarProducto {
    public static Question<String> on() {
        return actor -> actor.recall("validarProducto");
    }
}
