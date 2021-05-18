package eapli.base.infrastructure.bootstrapers;

import eapli.base.criticality.application.SpecifyCriticalityController;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.framework.actions.Action;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class NiveisCriticidadeBootstraper implements Action {
    private static final String FILENAME = "NiveisCriticidade.xml";

    @Override
    public boolean execute() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        SpecifyCriticalityController criticidadeController = new SpecifyCriticalityController();


        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();
            NodeList elementos = doc.getElementsByTagName("class");
            int size;
            for (size = 0; size < elementos.getLength(); size++) {
                Node node = elementos.item(size);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    int sizeInside;
                    Element element = (Element) node;
                    NodeList criticalities = element.getElementsByTagName("criticality");
                    for (sizeInside = 0; sizeInside < criticalities.getLength(); sizeInside++) {
                        Node nodeCriticality = criticalities.item(sizeInside);
                        if (nodeCriticality.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementCriticality = (Element) nodeCriticality;
                            String labelCriti = elementCriticality.getElementsByTagName("labelCriti").item(0).getTextContent();
                            String valorCriticidade = elementCriticality.getElementsByTagName("criticalityValue").item(0).getTextContent();
                            String tempoMaximoA = elementCriticality.getElementsByTagName("tempoMaximoA").item(0).getTextContent();
                            String tempoMedioA = elementCriticality.getElementsByTagName("tempoMedioA").item(0).getTextContent();
                            String tempoMaximoR = elementCriticality.getElementsByTagName("tempoMaximoR").item(0).getTextContent();
                            String tempoMedioR = elementCriticality.getElementsByTagName("tempoMedioR").item(0).getTextContent();

                            CriticalityDTO criticalityDTO = new CriticalityDTO(labelCriti, valorCriticidade, tempoMaximoA, tempoMedioA, tempoMaximoR, tempoMedioR);
                            CriticalityDTO criticidade = criticidadeController.method(criticalityDTO);
                            criticidadeController.save(criticidade);

                            System.out.printf("Criticidade adicionada - %s%n",criticidade.label);
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
