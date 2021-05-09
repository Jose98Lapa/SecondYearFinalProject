package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.TipoEquipa.Application.CriarTipoEquipaController;
import eapli.base.TipoEquipa.DTO.TipoEquipaDTO;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.ColaboradorBuilder;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.cor.Application.CriarCorController;
import eapli.base.cor.DTO.CorDTO;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.application.CriarEquipaController;
import eapli.base.funcao.domain.Designacao;
import eapli.base.funcao.domain.Funcao;
import eapli.base.funcao.domain.IdFuncao;
import eapli.base.funcao.repositories.FuncaoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class catalogosEServicosBootstrap {
    private static final String FILENAME = "catalogosEServicos.xml";

    public void initiate() {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        EspecificarColaboradorController colabController = new EspecificarColaboradorController();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();
            NodeList colabs = doc.getElementsByTagName("class");
            int a = colabs.getLength();
            for (int temp = 0; temp < colabs.getLength(); temp++) {
                Node node = colabs.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String fnome = element.getElementsByTagName("fnome").item(0).getTextContent();
                    String fscript = element.getElementsByTagName("fscript").item(0).getTextContent();
                    String Alabel = element.getElementsByTagName("Alabel").item(0).getTextContent();
                    String Adescricao = element.getElementsByTagName("Adescricao").item(0).getTextContent();
                    String Atipo = element.getElementsByTagName("Atipo").item(0).getTextContent();
                    String Aregex = element.getElementsByTagName("Aregex").item(0).getTextContent();
                    String Anome = element.getElementsByTagName("Anome").item(0).getTextContent();
                    String descricaoBreve = element.getElementsByTagName("descricaoBreve").item(0).getTextContent();
                    String descricaoCompleta = element.getElementsByTagName("descricaoCompleta").item(0).getTextContent();
                    String ServicoID = element.getElementsByTagName("ServicoID").item(0).getTextContent();
                    String keyWords = element.getElementsByTagName("keyWords").item(0).getTextContent();
                    String dataDisponibilidade = element.getElementsByTagName("dataDisponibilidade").item(0).getTextContent();
                    String statusServico = element.getElementsByTagName("statusServico").item(0).getTextContent();
                    String iconServico = element.getElementsByTagName("iconServico").item(0).getTextContent();
                    String tituloServico = element.getElementsByTagName("tituloServico").item(0).getTextContent();
                    String CcriteriosdeAcesso = element.getElementsByTagName("CcriteriosdeAcesso").item(0).getTextContent();
                    String iconCatalogo = element.getElementsByTagName("iconCatalogo").item(0).getTextContent();
                    String statusCatalogo = element.getElementsByTagName("statusCatalogo").item(0).getTextContent();
                    String tituloCatalogo = element.getElementsByTagName("tituloCatalogo").item(0).getTextContent();
                    String catalogoID = element.getElementsByTagName("catalogoID").item(0).getTextContent();
                    String CdescricaoCompleta = element.getElementsByTagName("CdescricaoCompleta").item(0).getTextContent();
                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }


}
