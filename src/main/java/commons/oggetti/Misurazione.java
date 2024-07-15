package commons.oggetti;

import java.sql.*;

/**
 * Classe che contiene tutti gli attributi che rappresentano i parametri climatici
 * che l'operatore può registrare su una o più aree di interesse
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @author Nome: Massimiliano De Lorenzo    Matricola: 754160   Sede: CO
 * @version 1.0
 */
public class Misurazione {
    private int idPuntoInteresse;
    private String nomeCentro;
    private Timestamp timestampMisurazione;

    private Object valutazioneVento;
    private String commentoVento;
    private Object valutazioneUmidita;
    private String commentoUmidita;
    private Object valutazionePressione;
    private String commentoPressione;
    private Object valutazioneTemperatura;
    private String commentoTemperatura;
    private Object valutazionePrecipitazioni;
    private String commentoPrecipitazioni;
    private Object valutazioneAltitudineGhiacciai;
    private String commentoAltitudineGhiacciai;
    private Object valutazioneMassaGhiacciai;
    private String commentoMassaGhiacciai;

    
    public Misurazione(int idPuntoInteresse, String nomeCentro, Timestamp timestampMisurazione, Object valutazioneVento, String commentoVentoV, Object valutazioneUmidita, String commentoUmidita, Object valutazionePressione, String commentoPressione, Object valutazioneTemperatura, String commentoTemperatura, Object valutazionePrecipitazioni, String commentoPrecipitazioni, Object valutazioneAltitudineGhiacciai, String commentoAltitudineGhiacciai, Object valutazioneMassaGhiacciai, String commentoMassaGhiacciai) {
        this.idPuntoInteresse = idPuntoInteresse;
        this.nomeCentro = nomeCentro;
        this.timestampMisurazione = timestampMisurazione;
        this.valutazioneVento = valutazioneVento;
        this.commentoVento = commentoVentoV;
        this.valutazioneUmidita = valutazioneUmidita;
        this.commentoUmidita = commentoUmidita;
        this.valutazionePressione = valutazionePressione;
        this.commentoPressione = commentoPressione;
        this.valutazioneTemperatura = valutazioneTemperatura;
        this.commentoTemperatura = commentoTemperatura;
        this.valutazionePrecipitazioni = valutazionePrecipitazioni;
        this.commentoPrecipitazioni = commentoPrecipitazioni;
        this.valutazioneAltitudineGhiacciai = valutazioneAltitudineGhiacciai;
        this.commentoAltitudineGhiacciai = commentoAltitudineGhiacciai;
        this.valutazioneMassaGhiacciai = valutazioneMassaGhiacciai;
        this.commentoMassaGhiacciai = commentoMassaGhiacciai;
    }

    public int getIdPuntoInteresse() {
        return idPuntoInteresse;
    }

    public String getNomeCentro() {
        return nomeCentro;
    }

    public Timestamp getTimestampMisurazione() {
        return timestampMisurazione;
    }

    public Object getValutazioneVento() {
        return valutazioneVento;
    }

    public Object getValutazioneUmidita() {
        return valutazioneUmidita;
    }

    public Object getValutazionePressione() {
        return valutazionePressione;
    }

    public Object getValutazioneTemperatura() {
        return valutazioneTemperatura;
    }

    public Object getValutazionePrecipitazioni() {
        return valutazionePrecipitazioni;
    }

    public Object getValutazioneAltitudineGhiacciai() {
        return valutazioneAltitudineGhiacciai;
    }

    public Object getValutazioneMassaGhiacciai() {
        return valutazioneMassaGhiacciai;
    }

    public String getCommentoVento() {
        return commentoVento;
    }

    public String getCommentoUmidita() {
        return commentoUmidita;
    }

    public String getCommentoPressione() {
        return commentoPressione;
    }

    public String getCommentoTemperatura() {
        return commentoTemperatura;
    }

    public String getCommentoPrecipitazioni() {
        return commentoPrecipitazioni;
    }

    public String getCommentoAltitudineGhiacciai() {
        return commentoAltitudineGhiacciai;
    }

    public String getCommentoMassaGhiacciai() {
        return commentoMassaGhiacciai;
    }

    public void setIdPuntoInteresse(int idPuntoInteresse) {
        this.idPuntoInteresse = idPuntoInteresse;
    }

    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }

    public void setTimestampMisurazione(Timestamp timestampMisurazione) {
        this.timestampMisurazione = timestampMisurazione;
    }

    public void setValutazioneVento(Object valutazioneVento) {
        this.valutazioneVento = valutazioneVento;
    }

    public void setCommentoVento(String commentoVento) {
        this.commentoVento = commentoVento;
    }

    public void setValutazioneUmidita(Object valutazioneUmidita) {
        this.valutazioneUmidita = valutazioneUmidita;
    }

    public void setCommentoUmidita(String commentoUmidita) {
        this.commentoUmidita = commentoUmidita;
    }

    public void setValutazionePressione(Object valutazionePressione) {
        this.valutazionePressione = valutazionePressione;
    }

    public void setCommentoPressione(String commentoPressione) {
        this.commentoPressione = commentoPressione;
    }

    public void setValutazioneTemperatura(Object valutazioneTemperatura) {
        this.valutazioneTemperatura = valutazioneTemperatura;
    }

    public void setCommentoTemperatura(String commentoTemperatura) {
        this.commentoTemperatura = commentoTemperatura;
    }

    public void setValutazionePrecipitazioni(Object valutazionePrecipitazioni) {
        this.valutazionePrecipitazioni = valutazionePrecipitazioni;
    }

    public void setCommentoPrecipitazioni(String commentoPrecipitazioni) {
        this.commentoPrecipitazioni = commentoPrecipitazioni;
    }

    public void setValutazioneAltitudineGhiacciai(Object valutazioneAltitudineGhiacciai) {
        this.valutazioneAltitudineGhiacciai = valutazioneAltitudineGhiacciai;
    }

    public void setCommentoAltitudineGhiacciai(String commentoAltitudineGhiacciai) {
        this.commentoAltitudineGhiacciai = commentoAltitudineGhiacciai;
    }

    public void setValutazioneMassaGhiacciai(Object valutazioneMassaGhiacciai) {
        this.valutazioneMassaGhiacciai = valutazioneMassaGhiacciai;
    }

    public void setCommentoMassaGhiacciai(String commentoMassaGhiacciai) {
        this.commentoMassaGhiacciai = commentoMassaGhiacciai;
    }
}
