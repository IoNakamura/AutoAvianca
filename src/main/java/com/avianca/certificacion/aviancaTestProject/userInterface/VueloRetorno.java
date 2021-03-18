package com.avianca.certificacion.aviancaTestProject.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VueloRetorno {

    public static final Target BTN_REGRESO_DESPLIEGA =
            Target.the("Ingresar el vlo de hacia").located(By.xpath("/html/body/app-root/main/div/avail-page/div/div/avail-cont/avail-pres/avail-list-pres/expander-elem/div/div[1]/div/div/div[2]/div[1]/button"));

    public static final Target BTN_DETALLES_VUELO =
            Target.the("Ingresar el vlo de hacia").located(By.xpath("/html/body/app-root/main/div/avail-page/div/div/avail-cont/avail-pres/avail-list-pres/expander-elem/div[1]/div[1]/div/div/div[1]/div[2]/div[3]/a"));

    public static final Target LABEL_TITULO_POP_UP =
            Target.the("Titulo pop-up").located(By.xpath("//*[@id=\"mat-dialog-0\"]/flight-details-lightbox-cont/flight-details-lightbox-pres/div/h2"));

    public static final Target BTN_CERRAR_POP_UP =
            Target.the("Boton cerrar del pop-up").located(By.xpath("//button[@class=\"btn-primary ok-button\"]"));

    public static final Target BTN_CONTINUAR_REGRESO =
            Target.the("Boton continuar selecciona tu vuelo de regreso").located(By.id("continue-btn-footer-static"));

    public static final Target LABEL_DATOS_PERSONALES =
            Target.the("Titulo de la segunda pantalla de avianca que es datos personales").located(By.xpath("/html/body/app-root/main/div/travelers-page/div/travelers-cont/travelers-pres/expander-elem/div[1]/div[1]/div/h1"));

}
