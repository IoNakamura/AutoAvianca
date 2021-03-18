package com.avianca.certificacion.aviancaTestProject.stepDefinitions;

import com.avianca.certificacion.aviancaTestProject.model.DatosBasicos;
import com.avianca.certificacion.aviancaTestProject.questions.VerificarDatosPersonales;
import com.avianca.certificacion.aviancaTestProject.tasks.AbrirPagina;
import com.avianca.certificacion.aviancaTestProject.tasks.BuscarVuelo;
import com.avianca.certificacion.aviancaTestProject.tasks.SeleccionarPopUp;
import com.avianca.certificacion.aviancaTestProject.tasks.SeleccionarVueloIda;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

public class BuscarVueloStepDefinition {

    @Before
    public void ConfiguracionInicial(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Christian");
    }

    @Dado("^que Christian esta en la pagina Avianca$")
    public void queChristianEstaEnLaPaginaAvianca() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.enElNavegador());
    }


    @Cuando("^el intenta buscar un vuelo$")
    public void elIntentaBuscarUnVuelo(List<DatosBasicos> datosBasicosList) {
        theActorInTheSpotlight().attemptsTo(BuscarVuelo.enLaPaginaDeAvianca(datosBasicosList));
        theActorInTheSpotlight().attemptsTo(SeleccionarVueloIda.deLaRutaSeleccionada());
        theActorInTheSpotlight().attemptsTo(SeleccionarPopUp.deLaRutaSeleccionada());
    }

    @Entonces("^el encuentra la informacion correspondiente al vuelo$")
    public void elEncuentraLaInformacionCorrespondienteAlVuelo(List<DatosBasicos> datosBasicosList) {
        theActorInTheSpotlight().should(seeThat(VerificarDatosPersonales.deLaDescripcionDelVuelo(datosBasicosList)));
    }


}
