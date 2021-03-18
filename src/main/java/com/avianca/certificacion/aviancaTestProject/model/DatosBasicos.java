package com.avianca.certificacion.aviancaTestProject.model;

public class DatosBasicos {

    private String vueloIda;
    private String vueloRetorno;
    private String tituloAValidar;

    public DatosBasicos(String vueloIda, String vueloRetorno, String tituloPopUp, String tituloAValidar) {
        this.vueloIda = vueloIda;
        this.vueloRetorno = vueloRetorno;
        this.tituloAValidar = tituloAValidar;
    }

    public String getVueloIda() {
        return vueloIda;
    }

    public void setVueloIda(String vueloIda) {
        this.vueloIda = vueloIda;
    }

    public String getVueloRetorno() {
        return vueloRetorno;
    }

    public void setVueloRetorno(String vueloRetorno) {
        this.vueloRetorno = vueloRetorno;
    }

    public String getTituloAValidar() {
        return tituloAValidar;
    }

    public void setTituloAValidar(String tituloAValidar) {
        this.tituloAValidar = tituloAValidar;
    }
}
