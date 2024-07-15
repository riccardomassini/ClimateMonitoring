package commons.oggetti;

/**
 * Classe che contiene tutti gli attributi che formano l'oggetto CentroMonitoraggio
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @version 1.0
 */
public class CentroMonitoraggio{
    private String nomeCentro;
    private String indirizzo;
    private int numeroCivico;
    private String CAP;
    private String comune;
    private String provincia;

    public CentroMonitoraggio(){
    }

    public CentroMonitoraggio(String nomeCentro, String indirizzo, int numeroCivico, String CAP, String comune, String provincia){
        this();
        this.nomeCentro = nomeCentro;
        this.indirizzo = indirizzo;
        this.numeroCivico = numeroCivico;
        this.CAP = CAP;
        this.comune = comune;
        this.provincia = provincia;
    }

    public String getNomeCentro() {
        return nomeCentro;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public String getCAP() {
        return CAP;
    }

    public String getComune() {
        return comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Metodo toString che permette di stampare tutti gli attributi nell'ordine seguente
     * @return stringa concatena che contiene tutti gli attributi della classe centroMonitoraggio
     */
    @Override
    public String toString() {
        return nomeCentro + "," + indirizzo + "," + numeroCivico + "," + CAP + "," + comune + "," + provincia + "\n";
    } 
}
