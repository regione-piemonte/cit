/**
 * LimammEnte_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.citpwa.business.ws.service.svista.client;

public interface LimammEntePortType extends java.rmi.Remote {
    public java.lang.String cercaEstensioneComune(long in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaTuttiIComuni() throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Comune cercaComunePerCodiceIstat(java.lang.String in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaComuniPerIdProvincia(java.lang.Long in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaComuniPerCap(java.lang.String in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Comune cercaComunePerCodiceBelfiore(java.lang.String in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Comune cercaComunePerIdComune(java.lang.Long in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaComuniPerNome(java.lang.String in0, int in1) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaComuniPerNomeECodIstatProvincia(java.lang.String in0, int in1, java.lang.String in2) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Comune[] cercaComuniPerNomeEIdProvincia(java.lang.String in0, int in1, long in2) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Provincia[] cercaTutteLeProvince() throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Provincia[] cercaProvincePerIdRegione(long in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Provincia cercaProvinciaPerCodiceIstat(java.lang.String in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Provincia cercaProvinciaPerIdProvincia(java.lang.Long in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Provincia[] cercaProvincePerNome(java.lang.String in0, java.lang.Integer in1) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Regione[] cercaTutteLeRegioni() throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Regione cercaRegionePerIdRegione(java.lang.Long in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Regione cercaRegionePerCodIstat(java.lang.String in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Regione[] cercaRegioniPerNome(java.lang.String in0, int in1) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Localita[] cercaLocalitaPerIdComune(java.lang.Long in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Localita cercaLocalitaPerIdLocalita(java.lang.Long in0) throws java.rmi.RemoteException;
    public it.csi.citpwa.business.ws.service.svista.client.Localita[] cercaLocalitaPerNome(java.lang.String in0, int in1) throws java.rmi.RemoteException;
    public java.lang.String cercaGeometriaComune(long in0) throws java.rmi.RemoteException;
    public java.lang.String cercaEstensioneRegione(long in0) throws java.rmi.RemoteException;
    public java.lang.String cercaGeometriaRegione(long in0) throws java.rmi.RemoteException;
    public java.lang.String cercaEstensioneProvincia(long in0) throws java.rmi.RemoteException;
    public java.lang.String cercaGeometriaProvincia(long in0) throws java.rmi.RemoteException;
}
