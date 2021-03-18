#language:es
Característica:
  YO COMO automatizador
  DESEO buscar un vuelo en la plataforma de vuelos de Avianca
  PARA verificar la funcionalidad del motor de busqueda

  Esquema del escenario: Buscar un vuelo en la pagina Avianca
    Dado que Christian esta en la pagina Avianca
    Cuando el intenta buscar un vuelo
      | vueloIda   | vueloRetorno   |
      | <vueloIda> | <vueloRetorno> |
    Entonces el encuentra la informacion correspondiente al vuelo
      | tituloAValidar   |
      | <tituloAValidar> |


    Ejemplos:
      | Id | vueloIda | vueloRetorno | tituloAValidar   |
##@externaldata@./src/test/resources/dataDriven/Datos.xlsx@Hoja1@1
      | 1  | BOG      | SCL          | Datos personales |

