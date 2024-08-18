/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.servizio.ricercapoi;

import static java.lang.Math.*;

/**
 * La classe {@code CalcoloHaversine} fornisce un metodo per calcolare la distanza
 * tra due punti sulla superficie terrestre utilizzando la formula dell'Haversine.
 * <p>
 * La formula dell'Haversine è usata per determinare la distanza del grande cerchio
 * (la distanza più corta tra due punti) tra due punti sulla superficie di una sfera,
 * dato il loro latitudine e longitudine.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
class CalcoloHaversine {

    /**
     * Il raggio della Terra in chilometri. Questo valore è utilizzato per convertire
     * la distanza angolare calcolata dalla formula dell'Haversine in una distanza lineare.
     */
    private static final double RAGGIO_PIANETA_TERRA_KM = 6371;

    /**
     * Calcola la distanza tra due punti sulla superficie terrestre utilizzando
     * la formula dell'Haversine.
     * <p>
     * La distanza è calcolata in chilometri.
     * </p>
     *
     * @param latitudine1 la latitudine del primo punto, in gradi
     * @param longitudine1 la longitudine del primo punto, in gradi
     * @param latitudine2 la latitudine del secondo punto, in gradi
     * @param longitudine2 la longitudine del secondo punto, in gradi
     * @return la distanza tra i due punti sulla superficie terrestre, in chilometri
     */
    public static double haversine(double latitudine1, double longitudine1, double latitudine2, double longitudine2) {
        double distanzaLatitudine = toRadians(latitudine2 - latitudine1);
        double distanzaLongitudine = toRadians(longitudine2 - longitudine1);
        double a = sin(distanzaLatitudine / 2) * sin(distanzaLatitudine / 2) + cos(toRadians(latitudine1)) * cos(toRadians(latitudine2)) * sin(distanzaLongitudine / 2) * sin(distanzaLongitudine / 2);

        double c = 2 * atan2(Math.sqrt(a), sqrt(1 - a));

        return RAGGIO_PIANETA_TERRA_KM * c;
    }
}