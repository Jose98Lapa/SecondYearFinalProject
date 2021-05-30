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
import org.xml.sax.SAXException;
import eapli.framework.actions.Action;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class CatalogosEServicosBootstraper implements Action {
    private static final String FILENAME = "catalogosEServicos.xml";

    @Override
    public boolean execute() {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        CreateCatalogueController catalogoController = new CreateCatalogueController();
        SpecifyServiceController servicoController = new SpecifyServiceController();
        ArrayList<CatalogueDTO> catalogos = null;

        try {
            List<CollaboratorDTO> lstColaboradores = new ArrayList<>();
            catalogoController.getCollabs().forEach(lstColaboradores::add);

            List<TeamDTO> lstEquipas = new ArrayList<>();
            catalogoController.getTeams().forEach(lstEquipas::add);

            List<CriticalityDTO> lstCriticidade = new ArrayList<>();
            catalogoController.getCriticidades().forEach(lstCriticidade::add);

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();
            NodeList elementos = doc.getElementsByTagName("class1");
            int size;
            for (size = 0; size < elementos.getLength(); size++) {
                Node node = elementos.item(size);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    int sizeInside;
                    Element element = (Element) node;
                    NodeList catalogues = element.getElementsByTagName("catalogue");
                    for (sizeInside = 0; sizeInside < catalogues.getLength(); sizeInside++) {
                        Node nodeCatalogue = catalogues.item(sizeInside);
                        if (nodeCatalogue.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementCatalogue = (Element) nodeCatalogue;
                            String criteriosdeAcesso = elementCatalogue.getElementsByTagName("criteriosdeAcesso").item(0).getTextContent();
                            String responsaveis = elementCatalogue.getElementsByTagName("responsaveis").item(0).getTextContent();
                            String iconCatalogo = elementCatalogue.getElementsByTagName("iconCatalogo").item(0).getTextContent();
                            String tituloCatalogoC = elementCatalogue.getElementsByTagName("tituloCatalogoC").item(0).getTextContent();
                            String descricaoBreveC = elementCatalogue.getElementsByTagName("tituloCatalogoC").item(0).getTextContent();
                            String descricaoCompletaC = elementCatalogue.getElementsByTagName("tituloCatalogoC").item(0).getTextContent();
                            String criticidade = elementCatalogue.getElementsByTagName("criticality").item(0).getTextContent();

                            catalogoController.insertBasicData(tituloCatalogoC, iconCatalogo,
                                    descricaoBreveC, descricaoCompletaC);

                            final Set<TeamDTO> accessCriteria = new HashSet<>();
                            accessCriteria.add(lstEquipas.get(Integer.parseInt(criteriosdeAcesso) - 1));

                            catalogoController.defineAccessCriteria(accessCriteria);

                            final Set<CollaboratorDTO> lstResponsaveis = new HashSet<>();
                            lstResponsaveis.add(lstColaboradores.get(Integer.parseInt(responsaveis) - 1));

                            catalogoController.defineResponsibleCollaborator(lstResponsaveis);

                            CriticalityDTO criticalityDTO = lstCriticidade.get(Integer.parseInt(criticidade) - 1);
                            catalogoController.defineCriticidade(criticalityDTO);

                            CatalogueDTO catalogo = catalogoController.registerCatalog();
                            catalogoController.saveCatalog(catalogo);
                            catalogos = servicoController.catalogList();

                            System.out.printf("%nCatalogo adicionado - %s%n", catalogo.catalogTitle);
                        }
                    }

                    NodeList services = element.getElementsByTagName("Servico");
                    for (sizeInside = 0; sizeInside < services.getLength(); sizeInside++) {
                        Node nodeService = services.item(sizeInside);
                        if (nodeService.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementService = (Element) nodeService;
                            String fId = elementService.getElementsByTagName("fId").item(0).getTextContent();
                            String fnome = elementService.getElementsByTagName("fnome").item(0).getTextContent();
                            String fscript = elementService.getElementsByTagName("fscript").item(0).getTextContent();
                            String Alabel = elementService.getElementsByTagName("Alabel").item(0).getTextContent();
                            String Adescricao = elementService.getElementsByTagName("Adescricao").item(0).getTextContent();
                            String Atipo = elementService.getElementsByTagName("Atipo").item(0).getTextContent();
                            String Aregex = elementService.getElementsByTagName("Aregex").item(0).getTextContent();
                            String Anome = elementService.getElementsByTagName("Anome").item(0).getTextContent();
                            String aID = elementService.getElementsByTagName("aID").item(0).getTextContent();
                            String descricaoBreve = elementService.getElementsByTagName("descricaoBreve").item(0).getTextContent();
                            String descricaoCompleta = elementService.getElementsByTagName("descricaoCompleta").item(0).getTextContent();
                            String ServicoID = elementService.getElementsByTagName("ServicoID").item(0).getTextContent();
                            String keyWords = elementService.getElementsByTagName("keyWords").item(0).getTextContent();
                            String statusServico = elementService.getElementsByTagName("statusServico").item(0).getTextContent();
                            String iconServico = elementService.getElementsByTagName("iconServico").item(0).getTextContent();
                            String tituloServico = elementService.getElementsByTagName("tituloServico").item(0).getTextContent();
                            String catalogoS = elementService.getElementsByTagName("catalogoS").item(0).getTextContent();
                            FormController formController = new FormController();


                            final Set<String> lstkeyWords = new HashSet<>();
                            lstkeyWords.add(keyWords);
                            ServiceDTO dto = new ServiceDTO(tituloServico, ServicoID, iconServico, lstkeyWords, statusServico, "MANUAL", descricaoBreve, descricaoCompleta, catalogos.get(Integer.parseInt(catalogoS) - 1), null, null );
                            servicoController.create(dto);
                            final Set<AttributeDTO> lstAtributos = new HashSet<>();
                            int number = 0;
                            AttributeDTO at = new AttributeDTO(Anome, Alabel, Adescricao, Aregex, Atipo, aID, number);
                            lstAtributos.add(at);
                            FormDTO fdto = new FormDTO(fscript, fId, fnome, lstAtributos);
                            formController.registerForm(fdto);
                            formController.save();
                            servicoController.manual(fId);
                            servicoController.updateStatus();
                            servicoController.confirms();

                            System.out.printf("Servico adicionado - %s%n", dto.title);
                        }

                    }
                    NodeList esperar = element.getElementsByTagName("wait");
                    for (sizeInside = 0; sizeInside < esperar.getLength(); sizeInside++) {
                        Node nodeWait = esperar.item(sizeInside);
                        if (nodeWait.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementWait = (Element) nodeWait;
                            catalogos = servicoController.catalogList();
                        }
                    }

                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
