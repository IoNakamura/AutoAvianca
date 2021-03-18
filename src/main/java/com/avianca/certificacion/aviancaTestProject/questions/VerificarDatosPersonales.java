package com.avianca.certificacion.aviancaTestProject.questions;

import static com.avianca.certificacion.aviancaTestProject.userInterface.PaginaInicial.INPUT_VLO_DESDE;
import static com.avianca.certificacion.aviancaTestProject.userInterface.VueloRetorno.LABEL_DATOS_PERSONALES;
import static com.avianca.certificacion.aviancaTestProject.userInterface.VueloRetorno.LABEL_TITULO_POP_UP;

import com.avianca.certificacion.aviancaTestProject.model.DatosBasicos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

public class VerificarDatosPersonales implements Question<Boolean> {

    private List<DatosBasicos> datosBasicosList;

    public VerificarDatosPersonales(List<DatosBasicos> datosBasicosList) {
        this.datosBasicosList = datosBasicosList;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Visibility.of(LABEL_DATOS_PERSONALES).viewedBy(actor);
        String txtTituloDatosPersonales = LABEL_DATOS_PERSONALES.resolveFor(actor).getText();
        return txtTituloDatosPersonales.contains(datosBasicosList.get(0).getTituloAValidar());

    }

    public static VerificarDatosPersonales deLaDescripcionDelVuelo(List<DatosBasicos> datosBasicosList){
        return new VerificarDatosPersonales(datosBasicosList);
    }
}
