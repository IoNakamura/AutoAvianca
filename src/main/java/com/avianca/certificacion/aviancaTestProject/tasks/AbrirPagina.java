package com.avianca.certificacion.aviancaTestProject.tasks;

import com.avianca.certificacion.aviancaTestProject.userInterface.UrlPaginaInicial;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;


public class AbrirPagina implements Task {

    private UrlPaginaInicial urlPaginaInicial;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Open.browserOn(urlPaginaInicial));
    }

    public static AbrirPagina enElNavegador(){
        return Tasks.instrumented(AbrirPagina.class);
    }
}
