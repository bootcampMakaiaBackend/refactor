public class Comparendo {

    private int limiteInferiorCarro = 65;
    private int limiteInferiorIntermedioCarro = 66;
    private int limiteSuperiorCarro = 85;
    private int limiteInferiorCamion = 75;
    private int limiteInferiorIntermedioCamion = 76;
    private int limiteSuperiorCamion = 95;
    private int limiteInferiorMula = 95;
    private int limiteInferiorIntermedioMula = 96;
    private int limiteSuperiorMula = 110;

    public Comparendo(int limiteInferiorCarro,
                      int limiteInferiorIntermedioCarro,
                      int limiteSuperiorCarro,
                      int limiteInferiorCamion,
                      int limiteInferiorIntermedioCamion,
                      int limiteSuperiorCamion,
                      int limiteInferiorMula,
                      int limiteInferiorIntermedioMula,
                      int limiteSuperiorMula) {

        this.limiteInferiorCarro = limiteInferiorCarro;
        this.limiteInferiorIntermedioCarro = limiteInferiorIntermedioCarro;
        this.limiteSuperiorCarro = limiteSuperiorCarro;
        this.limiteInferiorCamion = limiteInferiorCamion;
        this.limiteInferiorIntermedioCamion = limiteInferiorIntermedioCamion;
        this.limiteSuperiorCamion = limiteSuperiorCamion;
        this.limiteInferiorMula = limiteInferiorMula;
        this.limiteInferiorIntermedioMula = limiteInferiorIntermedioMula;
        this.limiteSuperiorMula = limiteSuperiorMula;
    }

    public Comparendo(int limiteInferiorCarro) {
        this.limiteInferiorCarro = limiteInferiorCarro;
    }

    public Comparendo() {
    }


    public void construirFotoMulta(int velocidad, String tipoVehiculo) {
        int cpa = calcularComparendo(velocidad, tipoVehiculo);
        String txt = enviarCorreoFotomulta(tipoVehiculo);
        if(cpa == -1){
            System.out.println("no hay calculo para el tipo de vehiculo" + tipoVehiculo + "corre: " + txt);
        }else {
            System.out.println("----el tipo de comparendo es: " + cpa + " ----cuerpo del correo" + txt);
        }

    }

    public int calcularComparendo(int ve, String tp) {

        if(tp == "CARRO") {
            if(ve<=limiteInferiorCarro) {
                return 0;
            }else if (ve >=limiteInferiorIntermedioCarro && ve<=limiteSuperiorCarro) {
                return 1;
            }
            return 2;
        }

        if(tp == "CAMION") {
            if(ve<=limiteInferiorCamion) {
                return 0;
            }else if (ve >=limiteInferiorIntermedioCamion && ve<=limiteSuperiorCamion) {
                return 1;
            }
            return 2;
        }

        if(tp == "MULA") {
            if(ve<=limiteInferiorMula) {
                return 0;
            }else if (ve >=limiteInferiorIntermedioMula && ve<=limiteSuperiorMula) {
                return 1;
            }
            return 2;
        }

        return -1;
    }


    public String enviarCorreoFotomulta(String tipoVehiculo) {

        if(tipoVehiculo == "CAMION") {
            String cuerpoMensaje = "//enviando correo para el tipo camion.";
            String asunto = "//asunto: comparendo camion";
            return   asunto + cuerpoMensaje;
        }else if(tipoVehiculo == "CARRO") {
            String cuerpoMensaje = "//enviando correo para el tipo carro.";
            String asunto = "//asunto: comparendo carro";
            return   asunto + cuerpoMensaje;
        }else if(tipoVehiculo == "MULA") {
            String cuerpoMensaje = "//enviando correo para el tipo mula.";
            String asunto = "//asunto: comparendo mula";
            return   asunto + cuerpoMensaje;
        } else {
            return "enviando correo con vehiculo desconocido";
        }
    }

}
