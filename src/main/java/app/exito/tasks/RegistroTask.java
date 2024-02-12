package app.exito.tasks;

import app.exito.driver.AppiumAndroidDriver;
import app.exito.interactions.ObtenerCodigoVerificacion;
import app.exito.utils.Esperas;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static app.exito.interactions.ObtenerCodigoVerificacion.codigoVerificacion;
import static app.exito.userInterfaces.CerrarSesionUI.BTN_MI_CUENTA;
import static app.exito.userInterfaces.InicioSesionUI.BTN_INICIO;
import static app.exito.userInterfaces.InicioSesionUI.LBL_NOMBRE_USUARIO;
import static app.exito.userInterfaces.RegistroUI.*;
import static app.exito.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistroTask implements Task {
    public static String nombreUsuario;

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            if (!BTN_REGISTRARSE.resolveFor(actor).isVisible()) {
                actor.attemptsTo(CerrarSesionTask.on());
            }
            actor.attemptsTo(
                    WaitUntil.the(BTN_REGISTRARSE, isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_REGISTRARSE),
                    WaitUntil.the(INP_NOMBRE, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(INP_NOMBRE),
                    Enter.theValue(NOMBRES).into(INP_NOMBRE),
                    Click.on(INP_APELLIDO),
                    Enter.keyValues(APELLIDOS).into(INP_APELLIDO),
                    Click.on(INP_NUMERO_DOCUMENTO),
                    Enter.theValue(NUMERO_DOCUMENTO).into(INP_NUMERO_DOCUMENTO),
                    Click.on(INP_ANIO),
                    Click.on(SELECT_ANIO),
                    Click.on(INP_MES),
                    Click.on(SELECT_MES),
                    Click.on(INP_DIA),
                    Click.on(SELECT_DIA),
                    Click.on(INP_CELULAR),
                    Enter.theValue(CELULAR).into(INP_CELULAR),
                    Click.on(LBL_FECHA_NACIMIENTO),
                    Click.on(INP_CORREO),
                    Enter.keyValues(CORREO).into(INP_CORREO),
                    Click.on(LBL_FECHA_NACIMIENTO)
            );

            TouchAction check = new TouchAction((PerformsTouchActions) AppiumAndroidDriver.driver);

            int x = 90;
            int y = 1750;
            check.tap(PointOption.point(x, y)).perform();

            x = 90;
            y = 1867;
            check.tap(PointOption.point(x, y)).perform();

            actor.attemptsTo(
                    Click.on(BTN_CONFIRMAR)
            );
            Esperas.esperarPor(4);

            actor.attemptsTo(
                    ObtenerCodigoVerificacion.on()
            );

            Esperas.esperarPor(2);

            actor.attemptsTo(
                    Enter.keyValues(codigoVerificacion).into(INP_CODIGO_VERIFICACION),
                    Enter.keyValues(CLAVE).into(INP_CLAVE),
                    Enter.keyValues(CLAVE).into(INP_CONFIRMAR_CLAVE),
                    Click.on(INP_CONFIRMAR_CLAVE),
                    Click.on(LBL_CODIGO_VERIFICACION),
                    Click.on(BTN_CREAR),
                    WaitUntil.the(BTN_MI_CUENTA, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_MI_CUENTA),
                    WaitUntil.the(LBL_NOMBRE_USUARIO, isVisible()).forNoMoreThan(10).seconds()
            );
            nombreUsuario = LBL_NOMBRE_USUARIO.resolveFor(actor).getText();
            actor.remember("nombreUsuario", nombreUsuario);
            actor.attemptsTo(
                    Click.on(BTN_INICIO)
            );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Performable on() {

        return Instrumented.instanceOf(RegistroTask.class).withProperties();
    }
}
