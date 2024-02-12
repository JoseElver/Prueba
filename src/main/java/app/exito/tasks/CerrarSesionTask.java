package app.exito.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static app.exito.userInterfaces.CerrarSesionUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarSesionTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

            actor.attemptsTo(
                    WaitUntil.the(BTN_MI_CUENTA, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_MI_CUENTA),
                      Click.on(BTN_CERRAR_SESION),
                    Click.on(BTN_ACEPTAR)
            );
    }

    public static Performable on() {
        return Instrumented.instanceOf(CerrarSesionTask.class).withProperties();
    }
}
