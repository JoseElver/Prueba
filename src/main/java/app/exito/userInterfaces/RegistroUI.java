package app.exito.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static app.exito.utils.Constantes.*;
public class RegistroUI {
    public static final Target BTN_REGISTRARSE = Target.the("REGISTRARSE").located(By.id("com.exito.appcompania:id/AppCompatButton_registrarse"));
    public static final Target INP_NOMBRE = Target.the("NOMBRE").locatedBy("(//*[@class='android.widget.EditText'])[1]");
    public static final Target INP_APELLIDO = Target.the("APELLIDO").locatedBy("(//*[@class='android.widget.EditText'])[2]");
    public static final Target INP_NUMERO_DOCUMENTO = Target.the("NUMERO DOCUMENTO").locatedBy("(//*[@class='android.widget.EditText'])[3]");
    public static final Target INP_ANIO = Target.the("AÑO").locatedBy("//*[@id='text_input_end_icon' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Año']]]]");
    public static final Target SELECT_ANIO = Target.the("AÑO").locatedBy("//*[@text='"+ANIO+"']");
    public static final Target INP_MES = Target.the("MES").locatedBy("//*[@id='text_input_end_icon' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Mes']]]]");
    public static final Target SELECT_MES = Target.the("MES").locatedBy("//*[@text='"+MES+"']");
    public static final Target INP_DIA = Target.the("DIA").locatedBy("//*[@id='text_input_end_icon' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Dia']]]]");
    public static final Target SELECT_DIA = Target.the("DIA").locatedBy("//*[@text='"+DIA+"']");
    public static final Target INP_CELULAR = Target.the("CELULAR").located(By.id("com.exito.appcompania:id/TextInputEditText_tel"));
    public static final Target INP_CORREO = Target.the("CORREO").locatedBy("(//*[@class='android.widget.EditText'])[5]");
    public static final Target BTN_CONFIRMAR = Target.the("CONFIRMAR").located(By.id("com.exito.appcompania:id/AppCompatButton_registrar"));
    public static final Target LBL_FECHA_NACIMIENTO = Target.the("REGISTRO").located(By.id("appCompatTextView2"));
    public static final Target LBL_CODIGO_CONFIRMACION = Target.the("TEXTO CODIGO DE CONFIRMACION").located(By.id("AppCompatTextView_bienvenido"));
    public static final Target INP_CODIGO_VERIFICACION = Target.the("CODIGO VERIFICACION").located(By.xpath("//*[@id='PinView_code_otp']"));
    public static final Target INP_CLAVE= Target.the("CLAVE").located(By.xpath("(//*[@class='android.widget.EditText'])[2]"));
    public static final Target INP_CONFIRMAR_CLAVE= Target.the("CLAVE").located(By.xpath("(//*[@class='android.widget.EditText'])[3]"));
    public static final Target LBL_CODIGO_VERIFICACION = Target.the("TEXTO CODIGO VERIFICACION").located(By.xpath("//*[@id='AppCompatTextView_bienvenido']"));
    public static final Target BTN_CREAR = Target.the("CREAR").located(By.xpath("//*[@id='AppCompatButton_continuar']"));

}
