package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.catalogue.application.CreateCatalogueController;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.form.DTO.FormDTO;
import eapli.base.form.DTO.attribute.AttributeDTO;
import eapli.base.form.application.FormController;
import eapli.base.service.Application.SpecifyServiceController;
import eapli.base.service.DTO.ServiceDTO;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CatalogosEServicosBootstrap {
    private static final String FILENAME = "catalogosEServicos.xml";

    public void initiate() {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();
            NodeList colabs = doc.getElementsByTagName("class1");
            int a = colabs.getLength();
            for (int temp = 0; temp < colabs.getLength(); temp++) {
                Node node = colabs.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String criteriosdeAcesso = element.getElementsByTagName("criteriosdeAcesso").item(0).getTextContent();
                    String responsaveis = element.getElementsByTagName("responsaveis").item(0).getTextContent();
                    String iconCatalogo = element.getElementsByTagName("iconCatalogo").item(0).getTextContent();
                    String tituloCatalogoC = element.getElementsByTagName("tituloCatalogoC").item(0).getTextContent();
                    String descricaoBreveC = element.getElementsByTagName("tituloCatalogoC").item(0).getTextContent();
                    String descricaoCompletaC = element.getElementsByTagName("tituloCatalogoC").item(0).getTextContent();
                    String criticidade = element.getElementsByTagName("criticality").item(0).getTextContent();

                    CreateCatalogueController catalogoController = new CreateCatalogueController();
                    catalogoController.insertBasicData(tituloCatalogoC, iconCatalogo,
                            descricaoBreveC, descricaoCompletaC);

                    List<TeamDTO> lstEquipas = new ArrayList<>();
                    catalogoController.getTeams().forEach(lstEquipas::add);
                    final Set<TeamDTO> accessCriteria = new HashSet<>();
                    accessCriteria.add(lstEquipas.get(Integer.parseInt(criteriosdeAcesso)-1));

                    catalogoController.defineAccessCriteria(accessCriteria);



                    List<CollaboratorDTO> lstColaboradores = new ArrayList<>();
                    catalogoController.getCollabs().forEach(lstColaboradores::add);
                    final Set<CollaboratorDTO> lstResponsaveis = new HashSet<>();
                    lstResponsaveis.add(lstColaboradores.get(Integer.parseInt(responsaveis)-1));

                    catalogoController.defineResponsibleCollaborator(lstResponsaveis);

                    List<CriticalityDTO> lstCriticidade = new ArrayList<>();
                    catalogoController.getCriticidades().forEach(lstCriticidade::add);
                    CriticalityDTO criticalityDTO = lstCriticidade.get(Integer.parseInt(criticidade)-1);
                    catalogoController.defineCriticidade(criticalityDTO);

                    CatalogueDTO catalogo = catalogoController.registerCatalog();
                    catalogoController.saveCatalog(catalogo);


                    String fId = element.getElementsByTagName("fId").item(0).getTextContent();
                    String fnome = element.getElementsByTagName("fnome").item(0).getTextContent();
                    String fscript = element.getElementsByTagName("fscript").item(0).getTextContent();
                    String Alabel = element.getElementsByTagName("Alabel").item(0).getTextContent();
                    String Adescricao = element.getElementsByTagName("Adescricao").item(0).getTextContent();
                    String Atipo = element.getElementsByTagName("Atipo").item(0).getTextContent();
                    String Aregex = element.getElementsByTagName("Aregex").item(0).getTextContent();
                    String Anome = element.getElementsByTagName("Anome").item(0).getTextContent();
                    String aID = element.getElementsByTagName("aID").item(0).getTextContent();
                    String descricaoBreve = element.getElementsByTagName("descricaoBreve").item(0).getTextContent();
                    String descricaoCompleta = element.getElementsByTagName("descricaoCompleta").item(0).getTextContent();
                    String ServicoID = element.getElementsByTagName("ServicoID").item(0).getTextContent();
                    String keyWords = element.getElementsByTagName("keyWords").item(0).getTextContent();
                    String statusServico = element.getElementsByTagName("statusServico").item(0).getTextContent();
                    String iconServico = element.getElementsByTagName("iconServico").item(0).getTextContent();
                    String tituloServico = element.getElementsByTagName("tituloServico").item(0).getTextContent();
                    String catalogoS = element.getElementsByTagName("catalogoS").item(0).getTextContent();
                    SpecifyServiceController servicoController = new SpecifyServiceController();
                    FormController formController = new FormController();

                    ArrayList<CatalogueDTO> catalogos = servicoController.catalogList();
                    final Set<String> lstkeyWords = new HashSet<>();
                    lstkeyWords.add(keyWords);
                    ServiceDTO dto = new ServiceDTO(tituloServico, ServicoID, iconServico, lstkeyWords, statusServico, "MANUAL", descricaoBreve, descricaoCompleta,catalogos.get(Integer.parseInt(catalogoS)-1) , null);
                    servicoController.registo(dto);
                    final Set<AttributeDTO> lstAtributos = new HashSet<>();
                    AttributeDTO at = new AttributeDTO(Anome, Alabel, Adescricao, Aregex, Atipo,aID);
                    lstAtributos.add(at);
                    FormDTO fdto = new FormDTO(fscript,fId,fnome,  lstAtributos);
                    //formController.registo(fdto);
                    //formController.save();
                    servicoController.automatic(fId);
                    servicoController.confirms();

                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }


}
