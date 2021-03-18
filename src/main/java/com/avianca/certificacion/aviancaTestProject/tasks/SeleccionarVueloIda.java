package com.avianca.certificacion.aviancaTestProject.tasks;

import static com.avianca.certificacion.aviancaTestProject.userInterface.VueloSalida.BTN_CONTINUAR_IDA;
import static com.avianca.certificacion.aviancaTestProject.userInterface.VueloSalida.BTN_IDA_DESPLIEGA;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


public class SeleccionarVueloIda implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_IDA_DESPLIEGA),
                Click.on(BTN_CONTINUAR_IDA));
    }

    public static SeleccionarVueloIda deLaRutaSeleccionada(){
        return Tasks.instrumented(SeleccionarVueloIda.class);
    }
}
