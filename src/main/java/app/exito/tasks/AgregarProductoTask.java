package app.exito.tasks;

import app.exito.utils.Esperas;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static app.exito.userInterfaces.AgregarProductoUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
public class AgregarProductoTask implements Task {
    public static String validarProducto;

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(BTN_TELEVISORES, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_TELEVISORES),
                    WaitUntil.the(INP_RECOGE, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(INP_RECOGE),
                    Click.on(INP_CIUDAD),
                    WaitUntil.the(SELECT_CIUDAD, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(SELECT_CIUDAD),
                    Click.on(INP_NOMBRE_ALMACEN),
                    Click.on(SELECT_NOMBRE_ALMACEN),
                    WaitUntil.the(BTN_CONTINUAR, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_CONTINUAR)
            );
            Esperas.esperarPor(3);
            actor.attemptsTo(
                    WaitUntil.the(BTN_CONTINUAR, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_CONTINUAR),
                    WaitUntil.the(BTN_AGREGAR_PRODUCTO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_AGREGAR_PRODUCTO),
                    WaitUntil.the(BTN_AGREGAR_AL_CARRITO, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_AGREGAR_AL_CARRITO),
                    WaitUntil.the(ICN_CARRITO, isVisible()).forNoMoreThan(10).seconds()
            );
            validarProducto = TXT_VALIDAR_PRODUCTO.resolveFor(actor).getText();
            actor.remember("validarProducto", validarProducto);
            actor.attemptsTo(
                    Click.on(ICN_CARRITO),
                    WaitUntil.the(TXT_CARRITO, isVisible()).forNoMoreThan(30).seconds()
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static Performable on() {
        return Instrumented.instanceOf(AgregarProductoTask.class).withProperties();
    }
}
