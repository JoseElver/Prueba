package app.exito.stepDefinitions;

import app.exito.driver.AppiumAndroidDriver;
import app.exito.questions.ValidarUsuario;
import app.exito.tasks.RegistroTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import io.cucumber.java.Before;

import java.io.IOException;

import static app.exito.userInterfaces.InicioSesionUI.LBL_NOMBRE_USUARIO;

public class RegistroStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario se encuentra en la app de Exito$")
    public void queElUsuarioSeEncuentraEnLaAppDeExito() throws IOException {
        OnStage.theActorCalled("user").can(BrowseTheWeb.with(AppiumAndroidDriver.initializeDriver()));
    }

    @Cuando("^el usuario se registra en la app del exito$")
    public void elUsuarioSeRegistraEnLaAppDelExito() {
        OnStage.theActor("actor").attemptsTo(RegistroTask.on());
    }

    @Entonces("^se valida que se haya registrado de manera correcta$")
    public void seValidaQueSeHayaRegistradoDeManeraCorrecta() {
        Ensure.that(Text.of(LBL_NOMBRE_USUARIO).equals(ValidarUsuario.on()));
    }

}
