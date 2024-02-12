package app.exito.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
public class InicioSesionUI {


    public static final Target BTN_INGRESAR = Target.the("INGRESAR").located(By.xpath("//*[@id='AppCompatButton_ingresar']"));
    public static final Target INP_CORREO = Target.the("CORREO").located(By.xpath("//*[@class='android.widget.EditText']"));
    public static final Target INP_CLAVE= Target.the("CLAVE").located(By.xpath("(//*[@class='android.widget.EditText'])[2]"));
    public static final Target LBL_NOMBRE_USUARIO = Target.the("NOMBRE DEL USUARIO").located(By.xpath("//*[@id='AppCompatTextView_hola']"));
    public static final Target BTN_INICIO = Target.the("INICIO").located(By.xpath("(//*[@id='navigation_bar_item_small_label_view'])[1]"));
}
