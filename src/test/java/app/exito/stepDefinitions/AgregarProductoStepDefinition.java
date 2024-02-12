package app.exito.stepDefinitions;

import app.exito.questions.ValidarProducto;
import app.exito.tasks.AgregarProductoTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import io.cucumber.java.Before;

import static app.exito.userInterfaces.AgregarProductoUI.TXT_VALIDAR_PRODUCTO;

public class AgregarProductoStepDefinition {

    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("^busca un producto y lo agrega al carrito$")
    public void buscaUnProductoYLoAgregaAlCarrito() {
        OnStage.theActor("actor").attemptsTo(AgregarProductoTask.on());
    }

    @Entonces("^valida que el producto se haya agregado correctamente$")
    public void validaQueElProductoSeHayaAgregadoCorrectamente(){
        Ensure.that(Text.of(TXT_VALIDAR_PRODUCTO).equals(ValidarProducto.on()));

    }
}
