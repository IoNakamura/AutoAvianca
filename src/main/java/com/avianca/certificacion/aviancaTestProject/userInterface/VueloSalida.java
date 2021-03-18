package com.avianca.certificacion.aviancaTestProject.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VueloSalida {

    public static final Target BTN_IDA_DESPLIEGA =
            Target.the("Ingresar el vlo de hacia").located(By.xpath("/html/body/app-root/main/div/avail-page/div/div/avail-cont/avail-pres/avail-list-pres/expander-elem/div[1]/div[1]/div/div/div[2]/div[1]/button"));

    public static final Target BTN_CONTINUAR_IDA =
            Target.the("").located(By.id("continue-btn-footer-static"));
}
