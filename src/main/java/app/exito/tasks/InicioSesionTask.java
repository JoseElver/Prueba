package app.exito.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static app.exito.userInterfaces.CerrarSesionUI.BTN_MI_CUENTA;
import static app.exito.userInterfaces.InicioSesionUI.*;
import static app.exito.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class InicioSesionTask implements Task {

    public static String nombreUsuario;

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (!BTN_INGRESAR.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    CerrarSesionTask.on()
            );
        }

        actor.attemptsTo(
                WaitUntil.the(BTN_INGRESAR, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_INGRESAR),
                WaitUntil.the(INP_CORREO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(INP_CORREO),
                Enter.theValue(CORREO).into(INP_CORREO),
                Click.on(INP_CLAVE),
                Enter.keyValues(CLAVE).into(INP_CLAVE),
                Click.on(BTN_INGRESAR),
                WaitUntil.the(BTN_MI_CUENTA, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_MI_CUENTA),
                WaitUntil.the(LBL_NOMBRE_USUARIO, isVisible()).forNoMoreThan(10).seconds()
        );
        nombreUsuario = LBL_NOMBRE_USUARIO.resolveFor(actor).getText();
        actor.remember("nombreUsuario", nombreUsuario);
        actor.attemptsTo(
                Click.on(BTN_INICIO)
        );
    }

    public static Performable on() {

        return Instrumented.instanceOf(InicioSesionTask.class).withProperties();
    }
}
