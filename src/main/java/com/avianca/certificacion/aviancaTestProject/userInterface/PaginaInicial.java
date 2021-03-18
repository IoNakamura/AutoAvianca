package com.avianca.certificacion.aviancaTestProject.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicial extends PageObject {

    public static final Target INPUT_VLO_DESDE =
            Target.the("Ingrear el vuelo de desde").located(By.xpath("(//input[@data-msg=\"Selecciona un origen\"])[4]"));

    public static final Target LIST_VLO_DESDE =
            Target.the("Clic en la lista del viaje desde").located(By.xpath("//ul//li[@data-terminal='BOG']"));

    public static final Target INPUT_VLO_HACIA =
            Target.the("Ingresar el vlo de hacia").located(By.xpath("(//input[@data-msg=\"Selecciona un destino\"])[4]"));

    public static final Target LIST_VLO_HASTA =
            Target.the("Clic en la lista del viaje hasta").located(By.xpath("//ul//li[@data-terminal='SCL']"));

    public static final Target BTN_FECHA =
            Target.the("Boton fecha").located(By.xpath("(//*[@aria-label=\"Selecciona las fechas de viaje\"])[3]"));

    public static final Target BTN_FECHA_IDA =
            Target.the("Boton fecha").located(By.xpath("(//td[@data-date=\"2021-04-07\"])[1]"));

    public static final Target BTN_FECHA_RETORNO =
            Target.the("Ingresar el vlo de hacia").located(By.xpath("(//td[@data-date=\"2021-04-21\"])[1]"));

    public static final Target BTN_BUSCAR_VUELOS =
            Target.the("Ingresar el vlo de hacia").located(By.xpath("(//button[@class=\"btn primary btn-codepromo pull-btn\"])[1]"));


}
