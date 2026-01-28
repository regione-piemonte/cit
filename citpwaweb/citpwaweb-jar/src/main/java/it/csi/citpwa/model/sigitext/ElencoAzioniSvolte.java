package it.csi.citpwa.model.sigitext;

import java.io.Serializable;

public class ElencoAzioniSvolte implements Serializable {

    private Long dataDiAggiunta;
    private String nome;
    private String descrizione;

    private static final long serialVersionUID = 1L;

    public Long getDataDiAggiunta() {
        return dataDiAggiunta;
    }

    public void setDataDiAggiunta(Long dataDiAggiunta) {
        this.dataDiAggiunta = dataDiAggiunta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "ElencoAzioniSvolte{" +
                "dataDiAggiunta=" + dataDiAggiunta +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
