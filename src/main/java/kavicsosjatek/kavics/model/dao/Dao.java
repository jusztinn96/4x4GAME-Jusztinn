package kavicsosjatek.kavics.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Objects;

import static kavicsosjatek.kavics.view.Jatekablak.*;

public class Dao {

    /**
     * Naplózási metódus.
     */
    private static final Logger logger = LoggerFactory.getLogger(Dao.class);

    /**
     * Az XML fájlkezelésre szolgál.
     * Ha az XML fájl nem létezik, akkor létrehoz egyet és beleírja a legutóbbi eredményt.
     * Ha létezik az XML fájl, akkor hozzáfűzi a legutóbbi eredményt a fájlhoz.
     */
    public static void fajlkezeles() {
        File fjl = new File((Dao.class.getClassLoader().getResource("ered.xml")).getFile());
        if (!fjl.exists()) 
    	{
            DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder icBuilder;
            try {
                icBuilder = icFactory.newDocumentBuilder();
                Document doc = icBuilder.newDocument();
                Element mainRootElement = doc.createElement("Mérkőzések");
                doc.appendChild(mainRootElement);

                mainRootElement.appendChild(jatszmak(doc, nyertes, pontosdatum));

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(Objects.requireNonNull(Dao.class.getClassLoader().getResource("ered.xml")).getFile()));
                transformer.transform(source, result);

                logger.info("XML fájl létrehozva.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(fjl);
                Element root = doc.getDocumentElement();

                root.appendChild(jatszmak(doc, nyertes, pontosdatum));

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(Objects.requireNonNull(Dao.class.getClassLoader().getResource("ered.xml")).getFile()));
                transformer.transform(source, result);

                logger.info("XML fájl sikeresen módosítva.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
