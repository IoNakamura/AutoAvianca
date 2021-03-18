package com.avianca.certificacion.aviancaTestProject.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.avianca.certificacion.aviancaTestProject.userInterface.PaginaInicial.INPUT_VLO_DESDE;
import static com.avianca.certificacion.aviancaTestProject.userInterface.VueloRetorno.*;

public class SeleccionarPopUp implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_REGRESO_DESPLIEGA),
                Click.on(BTN_DETALLES_VUELO),
                WaitUntil.the(BTN_DETALLES_VUELO,  WebElementStateMatchers.isVisible()),
                Click.on(BTN_CERRAR_POP_UP),
                Click.on(BTN_CONTINUAR_REGRESO),
                WaitUntil.the(LABEL_DATOS_PERSONALES,  WebElementStateMatchers.isVisible()));

    }

    public static SeleccionarPopUp deLaRutaSeleccionada(){
        return Tasks.instrumented(SeleccionarPopUp.class);
    }
}
