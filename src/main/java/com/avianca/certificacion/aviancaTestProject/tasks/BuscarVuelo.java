package com.avianca.certificacion.aviancaTestProject.tasks;

import com.avianca.certificacion.aviancaTestProject.model.DatosBasicos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.avianca.certificacion.aviancaTestProject.userInterface.PaginaInicial.*;

public class BuscarVuelo implements Task {

    List<DatosBasicos> datos;

    public BuscarVuelo(List<DatosBasicos> datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
/*
                Click.on(INPUT_VLO_DESDE),
                Enter.theValue("BOG").into(INPUT_VLO_DESDE),
                Click.on(LIST_VLO_DESDE),
                Click.on(INPUT_VLO_HACIA),
                Enter.theValue("SCL").into(INPUT_VLO_HACIA),
                Click.on(LIST_VLO_HASTA),
                Click.on(BTN_FECHA),
                Click.on(BTN_FECHA_IDA),
                Click.on(BTN_FECHA_RETORNO),
                Click.on(BTN_BUSCAR_VUELOS));
*/
                WaitUntil.the(INPUT_VLO_DESDE,  WebElementStateMatchers.isVisible()),
                Click.on(INPUT_VLO_DESDE),
                Enter.theValue(datos.get(0).getVueloIda()).into(INPUT_VLO_DESDE),
                Click.on(LIST_VLO_DESDE),
                Click.on(INPUT_VLO_HACIA),
                Enter.theValue(datos.get(0).getVueloRetorno()).into(INPUT_VLO_HACIA),
                Click.on(LIST_VLO_HASTA),
                Click.on(BTN_FECHA),
                Click.on(BTN_FECHA_IDA),
                Click.on(BTN_FECHA_RETORNO),
                Click.on(BTN_BUSCAR_VUELOS));
    }
/*
    public static BuscarVuelo enLaPaginaDeAvianca(){
        return Tasks.instrumented(BuscarVuelo.class);
    }
*/
public static BuscarVuelo enLaPaginaDeAvianca(List<DatosBasicos> datos){
        return Tasks.instrumented(BuscarVuelo.class,datos);
    }
}
