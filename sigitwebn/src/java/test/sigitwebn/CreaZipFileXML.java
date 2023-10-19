package test.sigitwebn;

import it.csi.csiui.csiuicore.component.header.parser.File;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTLibTxtByCodImpiantiDto;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.XmlBeanUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.postgresql.Driver;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CreaZipFileXML {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println("Prova");

		System.out.println("########### CREA ZIP FILE XML ###########\n");


		String ambiente = null;

		String databaseURL = null;
		String user = null;
		String pwd = null;
		String tipoDocumento = null;
		String idLibretto = null;

		String elencoCodImp = "285292,1105902,301014,976079,1210984";



		System.out.println("Elenco elencoCodImp: "+elencoCodImp);


		//System.out.println("args.length: "+args.length);




		// valori ammessi dev, tst, coll e prod
		try {

			databaseURL = "jdbc:postgresql://tst-domdb46.csi.it:5432/PGDEV02";
			user = "sigit_new_rw";
			pwd = "mypass";

			//System.out.println("databaseURL: "+databaseURL);
			//System.out.println("user: "+user);
			//System.out.println("pwd: "+pwd);

			if (databaseURL != null && databaseURL.trim() != "")
			{

				String driverName = "org.postgresql.Driver";
				//String databaseURL = "jdbc:postgresql://pgsql1.csi.it:5431/PGPRD01";
				Class driverClass = Class.forName(driverName);
				Driver driver = (Driver) driverClass.newInstance();
				Connection connection = DriverManager.getConnection(databaseURL, user, pwd);



				Statement statement = connection.createStatement();

				StringBuffer sql = new StringBuffer();
				String tipoDoc = null;


				sql.append("SELECT lib.CODICE_IMPIANTO, txt.XML_LIBRETTO");

				sql.append(" FROM SIGIT_T_LIB_TXT txt, SIGIT_T_LIBRETTO lib");

				sql.append(" WHERE ");

				sql.append("txt.ID_LIBRETTO = lib.ID_LIBRETTO");

				sql.append(" AND FK_STATO = 2 ");

				sql.append(" AND CODICE_IMPIANTO IN ("+elencoCodImp+")");



				System.out.println("Stampo la query: "+sql);

				ResultSet rs = statement.executeQuery(sql.toString());

				byte[] file = null;
				String codImpianto = null;
				String sFile = null;

				List<SigitTLibTxtByCodImpiantiDto> dtoList = new ArrayList<SigitTLibTxtByCodImpiantiDto>();

				SigitTLibTxtByCodImpiantiDto dto = null;
				while (rs.next()) {								

					dto = new SigitTLibTxtByCodImpiantiDto();
					//System.out.println("ID_IMPORT: "+rs.getInt("ID_IMPORT"));
					codImpianto = rs.getString("CODICE_IMPIANTO");
					sFile = rs.getString("XML_LIBRETTO");

					dto.setLibCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
					dto.setTxtXmlLibretto(sFile);

					System.out.println("CodiceImpianto trovato: "+codImpianto);
					System.out.println("XML trovato: "+sFile);

					dtoList.add(dto);


				}

				FileOutputStream fos = new FileOutputStream("D:/progetti/eclipse luna/energia/DOC/provaZip.zip");
				ZipOutputStream zos = new ZipOutputStream(fos);

				byte[] tracciato = null;

				for (SigitTLibTxtByCodImpiantiDto libretto : dtoList) {
					if (libretto != null)
					{
						tracciato = XmlBeanUtils.readString(libretto.getTxtXmlLibretto());
						
						try
						{
							addToZipFile(ConvertUtil.convertToString(libretto.getLibCodiceImpianto())+".xml", tracciato, zos);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
				zos.close();
				connection.close();

				fos.flush();
				fos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n########### CREA ZIP FILE XML ###########");
	}

	private static void addToZipFile(String fileName, byte[] tracciato, ZipOutputStream zos) throws Exception {

		System.out.println("Writing '" + fileName + "' to zip file");

		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		zos.write(tracciato);
		zos.closeEntry();


	}

}
