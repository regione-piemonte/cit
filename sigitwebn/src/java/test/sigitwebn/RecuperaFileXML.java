package test.sigitwebn;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.postgresql.Driver;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class RecuperaFileXML {

	private static String DB_SVIL = "svil";
	private static String DB_TST = "tst";
	private static String DB_COLL = "coll";
	private static String DB_PROD = "prod";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println("Prova");

			System.out.println("########### RECUPER FILE XML ###########\n");
			
			if (args != null && args.length > 0)
			{
				String ambiente = null;
				
				String databaseURL = null;
				String user = null;
				String pwd = null;
				String tipoDocumento = null;
				String idLibretto = null;
				
				tipoDocumento = args[0];
				
				if (args.length == 3)
				{
					idLibretto = args[2];
					ambiente = args[1].toLowerCase();
					System.out.println("DB passato: "+ambiente);
	
				}
				else
				{
					idLibretto = args[1];
					ambiente = DB_PROD;
					System.out.println("DB impostato: "+ambiente);
				}
				
				
				if (tipoDocumento != null && (tipoDocumento.equals("L") ||
						tipoDocumento.equals("A")))
				{
					
					System.out.println("ID documento passato: "+idLibretto);
					
					
					//System.out.println("args.length: "+args.length);
					
					
					
					
					// valori ammessi dev, tst, coll e prod
					try {
						Properties prop = new Properties();
						
//						prop.load(RecuperaFileXML.class.getClassLoader().getResourceAsStream("conf/config_db.properties"));
//						databaseURL = prop.getProperty(ambiente+"_databaseURL");
//						user = prop.getProperty(ambiente+"_user");
//						pwd = prop.getProperty(ambiente+"_pwd");
						
						databaseURL = "jdbc:postgresql://pgsql5.csi.it:5435/PGPRD05";
						user = "sigit_new_rw";
						pwd = "sigitn#14";
						
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
							
							StringBuffer query = new StringBuffer();
							String tipoDoc = null;
							
							
							if (tipoDocumento.equals("L"))
							{
								tipoDoc = "L";
								query.append("SELECT * ");
								query.append("FROM SIGIT_T_LIBRETTO ");
								query.append("WHERE ID_LIBRETTO = "+idLibretto);
							}
							else
							{
								tipoDoc = "A";
								query.append("SELECT * ");
								query.append("FROM SIGIT_T_ALLEGATO ");
								query.append("WHERE ID_ALLEGATO = "+idLibretto);
							}
							
							System.out.println("Stampo la query: "+query);
							
							ResultSet rs = statement.executeQuery(query.toString());
							
							byte[] file = null;
							String nomeFile = null;
							if (rs.next()) {
								
								if (tipoDocumento.equals("L"))
								{
								//System.out.println("\n\nDB: "+rs.getInt("ID_IMPORT"));
		
								//System.out.println("ID_IMPORT: "+rs.getInt("ID_IMPORT"));
								nomeFile = rs.getString("FILE_INDEX");
								
								System.out.println("Nome file trovato: "+nomeFile);
								
								file = rs.getBytes("XML_LIBRETTO");
								//System.out.println("FILE_IMPORT: "+file);
								}
								else
								{
									nomeFile = rs.getString("NOME_ALLEGATO");
									
									System.out.println("Nome file trovato: "+nomeFile);
									
									file = rs.getBytes("XML_ALLEGATO");
								}
								
								
								String stringaNonFormattata = new String(file);
								
								//System.out.println("Stampo la stringa: "+stringaNonFormattata);
								
								
								String stringaFormattata = format(stringaNonFormattata);
								
								//System.out.println("Stampo la stringa formattata:\n"+stringaFormattata);				
								
								
								FileOutputStream fileStream = new FileOutputStream("D:/progetti/eclipse luna/energia/DOC/recuperaFile/scarico/"+tipoDoc+"_"+idLibretto+"_"+nomeFile+".xml"); 
								
								//FileOutputStream fileStream = new FileOutputStream("scarico/"+tipoDoc+"_"+idLibretto+"_"+nomeFile+".xml"); 
								fileStream.write(stringaFormattata.getBytes());   
								fileStream.flush(); 
								fileStream.close(); 
							}
							else
							{
								System.out.println("ATTENZIONE: nessun file trovato per l'id passato");
							}
							
							connection.close();
							
						}
						else
						{
							System.out.println("ATTENZIONE: ambiente non corretto - ambienti ammessi: svil - tst - coll - prod");
							
						}
		
					}
					catch (Exception ex)
					{
						//System.out.println("./conf/config_prod.properties");
						ex.printStackTrace();
					}
					
				}
				else
				{
					System.out.println("ATTENZIONE: tipo documento non corretto - documenti ammessi L = libretto; A = allegato");
				}
				
				
			}
			else
			{
				System.out.println("ATTENZIONE: numero di parametri ammessi: [DB] idImport");
			}
			System.out.println("\n########### RECUPER FILE XML ###########");

		
	}
	
	public static String format(String unformattedXml) {
        try {
            Document document = parseXmlFile(unformattedXml);

            OutputFormat format = new OutputFormat(document);
            //format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(2);
            Writer out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(document);

            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
