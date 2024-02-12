package app.exito.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static app.exito.utils.Constantes.*;

public class AgregarProductoUI {
    public static final Target BTN_TELEVISORES = Target.the("TELEVISORES").located(By.xpath("//*[@id='imageView_hall' and (./preceding-sibling::* | ./following-sibling::*)[@text='Televisores']]"));
    public static final Target INP_RECOGE = Target.the("RECOGE").located(By.xpath("//*[@id='constraitLayout_buy_and_collect']"));
    public static final Target INP_CIUDAD = Target.the("CIUDAD").located(By.xpath("//*[@text='Seleccione ciudad']"));
    public static final Target SELECT_CIUDAD = Target.the("CIUDAD").located(By.xpath("//*[@text='"+CIUDAD+"']"));
    public static final Target INP_NOMBRE_ALMACEN = Target.the("DIRECCION").located(By.xpath("//*[@text='Seleccione almacén']"));
    public static final Target SELECT_NOMBRE_ALMACEN = Target.the("DEPARTAMENTO").located(By.xpath("//*[@text='"+ALMACEN+"']"));
    public static final Target BTN_CONTINUAR = Target.the("AGREGAR").located(By.xpath("//*[@id='appCompatButton_continue']"));
    public static final Target BTN_AGREGAR_PRODUCTO = Target.the("AGREGAR").located(By.xpath("//*[@id='appCompatImageView_item']"));
    public static final Target BTN_AGREGAR_AL_CARRITO = Target.the("AGREGAR AL CARRITO").located(By.xpath("//*[@id='add_to_cart_food_button']"));
    public static final Target TXT_VALIDAR_PRODUCTO = Target.the("VALIDAR PRODUCTO").located(By.id("appCompatTextView_product_title"));
    public static final Target ICN_CARRITO = Target.the("ICONO CARRITO").located(By.id("appCompatImageView_shopping_cart"));
    public static final Target TXT_CARRITO = Target.the("CARRITO").located(By.id("appCompatTextView_shopping_cart_title"));
}
