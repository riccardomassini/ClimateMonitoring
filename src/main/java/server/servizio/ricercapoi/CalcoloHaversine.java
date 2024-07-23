package server.servizio.ricercapoi;

import static java.lang.Math.*;

class CalcoloHaversine {
    private static final double RAGGIO_PIANETA_TERRA_KM = 6371;

    public static double haversine(double latitudine1, double longitudine1, double latitudine2, double longitudine2) {
        double distanzaLatitudine = toRadians(latitudine2 - latitudine1);
        double distanzaLongitudine = toRadians(longitudine2 - longitudine1);
        double a = sin(distanzaLatitudine / 2) * sin(distanzaLatitudine / 2) + cos(toRadians(latitudine1)) * cos(toRadians(latitudine2)) * sin(distanzaLongitudine / 2) * sin(distanzaLongitudine / 2);

        double c = 2 * atan2(Math.sqrt(a), sqrt(1 - a));

        return RAGGIO_PIANETA_TERRA_KM * c;
    }
}
