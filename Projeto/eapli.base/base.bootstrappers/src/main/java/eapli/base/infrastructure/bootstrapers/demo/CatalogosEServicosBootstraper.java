package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.catalogue.application.CreateCatalogueController;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.base.function.DTO.FunctionDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.Repository.ServiceRepository;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceID;
import eapli.base.service.domain.Workflow;
import eapli.base.task.DTO.ApprovalTaskDTO;
import eapli.base.task.DTO.AutomaticTaskDTO;
import eapli.base.task.DTO.ExecutionTaskDTO;
import eapli.base.task.application.CreateTaskController;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.form.DTO.FormDTO;
import eapli.base.form.DTO.attribute.AttributeDTO;
import eapli.base.form.application.FormController;
import eapli.base.service.Application.SpecifyServiceController;
import eapli.base.service.DTO.ServiceDTO;
import eapli.framework.io.util.Console;
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
                            ServiceDTO dto = new ServiceDTO(tituloServico, ServicoID, iconServico, lstkeyWords, statusServico, "MANUAL", descricaoBreve, descricaoCompleta, catalogos.get(Integer.parseInt(catalogoS) - 1), null, null);
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

                    //workflow

                    NodeList workflows = element.getElementsByTagName("Workflow");
                    for (sizeInside = 0; sizeInside < workflows.getLength(); sizeInside++) {
                        Node nodeWorkflow = workflows.item(sizeInside);
                        if (nodeWorkflow.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementWorkflow = (Element) nodeWorkflow;
                            String Wtipo = elementWorkflow.getElementsByTagName("Wtipo").item(0).getTextContent();
                            String Waprov = elementWorkflow.getElementsByTagName("Waprov").item(0).getTextContent();
                            String Wservice = elementWorkflow.getElementsByTagName("Wservice").item(0).getTextContent();
                            String Wscript = elementWorkflow.getElementsByTagName("Wscript").item(0).getTextContent();
                            String Wfunc = elementWorkflow.getElementsByTagName("Wfunc").item(0).getTextContent();
                            String Wteam = elementWorkflow.getElementsByTagName("Wteam").item(0).getTextContent();

                            //form aprovacao

                            String WAfId = elementWorkflow.getElementsByTagName("WAfId").item(0).getTextContent();
                            String WAfnome = elementWorkflow.getElementsByTagName("WAfnome").item(0).getTextContent();
                            String WAfscript = elementWorkflow.getElementsByTagName("WAfscript").item(0).getTextContent();
                            String WAAlabel = elementWorkflow.getElementsByTagName("WAAlabel").item(0).getTextContent();
                            String WAAdescricao = elementWorkflow.getElementsByTagName("WAAdescricao").item(0).getTextContent();
                            String WAAtipo = elementWorkflow.getElementsByTagName("WAAtipo").item(0).getTextContent();
                            String WAAregex = elementWorkflow.getElementsByTagName("WAAregex").item(0).getTextContent();
                            String WAAnome = elementWorkflow.getElementsByTagName("WAAnome").item(0).getTextContent();
                            String WAaID = elementWorkflow.getElementsByTagName("WAaID").item(0).getTextContent();

                            //form manual

                            String WMfId = elementWorkflow.getElementsByTagName("WMfId").item(0).getTextContent();
                            String WMfnome = elementWorkflow.getElementsByTagName("WMfnome").item(0).getTextContent();
                            String WMfscript = elementWorkflow.getElementsByTagName("WMfscript").item(0).getTextContent();
                            String WMAlabel = elementWorkflow.getElementsByTagName("WMAlabel").item(0).getTextContent();
                            String WMAdescricao = elementWorkflow.getElementsByTagName("WMAdescricao").item(0).getTextContent();
                            String WMAtipo = elementWorkflow.getElementsByTagName("WMAtipo").item(0).getTextContent();
                            String WMAregex = elementWorkflow.getElementsByTagName("WMAregex").item(0).getTextContent();
                            String WMAnome = elementWorkflow.getElementsByTagName("WMAnome").item(0).getTextContent();
                            String WMaID = elementWorkflow.getElementsByTagName("WMaID").item(0).getTextContent();

                            ServiceRepository serviceRepository = PersistenceContext.repositories().servico();
                            CreateTaskController createTaskController = new CreateTaskController();
                            SpecifyServiceController theController = new SpecifyServiceController();
                            FormController formController = new FormController();


                            Service service = serviceRepository.ofIdentity(ServiceID.valueOf(Wservice)).get();
                            ServiceDTO servDTO = service.toDTO();

                            List<String> taskIDList = new ArrayList<>();
                            FunctionDTO functionDTO = null;

                            if (Waprov.equals("S")) {  //aprovavcao
                                final Set<AttributeDTO> lstAtributos = new HashSet<>();
                                int number = 0;
                                AttributeDTO at = new AttributeDTO(WAAnome, WAAlabel, WAAdescricao, WAAregex, WAAtipo, WAaID, number);
                                lstAtributos.add(at);
                                FormDTO fdto = new FormDTO(WAfscript, WAfId, WAfnome, lstAtributos);
                                formController.registerForm(fdto);
                                formController.save();
                                List<FunctionDTO> functionDTOList = createTaskController.getFunctionsDTO();
                                functionDTO = functionDTOList.get(Integer.parseInt(Wfunc)-1);
                                ApprovalTaskDTO approvalTaskDTO = new ApprovalTaskDTO(WAfId, functionDTO);
                                taskIDList.add(createTaskController.registerApprovalTask(approvalTaskDTO));
                            }
                            if (Wtipo.equals("M")) {  //manual/automatica

                                //form

                                final Set<AttributeDTO> lstAtributos = new HashSet<>();
                                int number = 0;
                                AttributeDTO at = new AttributeDTO(WMAnome, WMAlabel, WMAdescricao, WMAregex, WMAtipo, WMaID, number);
                                lstAtributos.add(at);
                                FormDTO fdto = new FormDTO(WMfscript, WMfId, WMfnome, lstAtributos);
                                formController.registerForm(fdto);
                                formController.save();

                                List<TeamDTO> teamDTOList = new ArrayList<>();
                                for (TeamDTO teamDTO : createTaskController.getTeamDTO()) {
                                    teamDTOList.add(teamDTO);
                                }
                                TeamDTO teamDTO = null;
                                teamDTO = teamDTOList.get(Integer.parseInt(Wfunc)-1);
                                ExecutionTaskDTO executionTaskDTO = new ExecutionTaskDTO(WMfId, (List<TeamDTO>) teamDTO);
                                taskIDList.add(createTaskController.registerManualTask(executionTaskDTO));
                            } else {
                                AutomaticTaskDTO automaticTaskDTO = new AutomaticTaskDTO("",Wscript);
                                createTaskController.registerAutomaticTask(automaticTaskDTO);
                            }
                            theController.addWorkflowToService(taskIDList, servDTO);

                            System.out.printf("WorkFLow adicionado - %s%n", servDTO.title);
                        }

                    }
                }
            }
        } catch (ParserConfigurationException | IOException |
                SAXException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
