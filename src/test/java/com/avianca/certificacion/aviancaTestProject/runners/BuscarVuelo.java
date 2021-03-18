package com.avianca.certificacion.aviancaTestProject.runners;

import com.avianca.certificacion.aviancaTestProject.Excel.RunnerPersonalizado;
import com.avianca.certificacion.aviancaTestProject.util.excel.BeforeSuite;
import com.avianca.certificacion.aviancaTestProject.util.excel.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
//@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/feature/buscar_vuelo.feature"},
        glue = {"com.avianca.certificacion.aviancaTestProject.stepDefinitions"},
        snippets = SnippetType.CAMELCASE
)
public class BuscarVuelo {

    private BuscarVuelo() {

    }

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/feature/buscar_vuelo.feature");
    }
}
