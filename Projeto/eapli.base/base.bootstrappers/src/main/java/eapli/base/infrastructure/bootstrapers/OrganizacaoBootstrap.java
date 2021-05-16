package eapli.base.infrastructure.bootstrapers;

import eapli.base.teamType.Application.CreateTeamTypeController;
import eapli.base.teamType.DTO.TeamTypeDTO;
import eapli.base.collaborator.application.SpecifyCollaboratorController;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.builder.CollaboratorBuilder;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.colour.Application.CreateColourController;
import eapli.base.colour.DTO.ColourDTO;
import eapli.base.criticality.application.SpecifyCriticalityController;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.base.function.domain.Designation;
import eapli.base.function.domain.Function;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.application.CreateTeamController;
import eapli.base.team.application.CreateTeamBootstrap;
import eapli.base.function.domain.IdFunction;
import eapli.base.function.repositories.FunctionRepository;
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

public class OrganizacaoBootstrap {
    private static final String FILENAME = "Organizacao.xml";

    public void initiate() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        SpecifyCollaboratorController colabController = new SpecifyCollaboratorController();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();
            NodeList colabs = doc.getElementsByTagName("class");
            for (int temp = 0; temp < colabs.getLength(); temp++) {
                Node node = colabs.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String splaceOfResidence = element.getElementsByTagName("splaceOfResidence").item(0).getTextContent();
                    String snumeroMecanografico = element.getElementsByTagName("snumeroMecanografico").item(0).getTextContent();
                    String scontacto = element.getElementsByTagName("scontacto").item(0).getTextContent();
                    String snomeCompleto = element.getElementsByTagName("snomeCompleto").item(0).getTextContent();
                    String semailInstitucional = element.getElementsByTagName("semailInstitucional").item(0).getTextContent();
                    String salcunha = element.getElementsByTagName("salcunha").item(0).getTextContent();
                    String sdataDeNascimento = element.getElementsByTagName("sdataDeNascimento").item(0).getTextContent();
                    String Superdesignacao = element.getElementsByTagName("Superdesignacao").item(0).getTextContent();
                    String SuperidFunc = element.getElementsByTagName("SuperidFunc").item(0).getTextContent();

                    Function functionSupe = new Function(IdFunction.valueOf(SuperidFunc), Designation.valueOf(Superdesignacao));
                    FunctionRepository repo = PersistenceContext.repositories().funcao();
                    repo.save(functionSupe);

                    CollaboratorBuilder builder = new CollaboratorBuilder();
                    Collaborator supervisor = builder.withPlaceOfResidence(splaceOfResidence).withContact(scontacto)
                            .withFullName(snomeCompleto).withInstitutionalEmail(semailInstitucional).withMecanoGraphicNumber(snumeroMecanografico)
                            .withNickname(salcunha).withDateOfBirth(sdataDeNascimento).withMecanoGraphicNumber(snumeroMecanografico).withFunction(functionSupe).build();
                    String designacao = element.getElementsByTagName("designation").item(0).getTextContent();
                    String dataDeNascimento = element.getElementsByTagName("datanascimento").item(0).getTextContent();
                    String placeOfResidence = element.getElementsByTagName("placeOfResidence").item(0).getTextContent();
                    String numeroMecanografico = element.getElementsByTagName("numeroMecanografico").item(0).getTextContent();
                    String contacto = element.getElementsByTagName("contact").item(0).getTextContent();
                    String nomeCompleto = element.getElementsByTagName("fullName").item(0).getTextContent();
                    String emailInstitucional = element.getElementsByTagName("emailInstitucional").item(0).getTextContent();
                    String alcunha = element.getElementsByTagName("nickname").item(0).getTextContent();
                    String idFunc = element.getElementsByTagName("idFunc").item(0).getTextContent();

                    CollaboratorDTO colaDTO = new CollaboratorDTO(placeOfResidence, contacto, nomeCompleto, emailInstitucional, numeroMecanografico, alcunha, dataDeNascimento);
                    colabController.method(colaDTO);
                    Function func = new Function(IdFunction.valueOf(idFunc), Designation.valueOf(designacao));
                    repo.save(func);
                    colabController.defineFunction(func.toDTO());
                    CollaboratorRepository repo2 = PersistenceContext.repositories().collaborators();
                    repo2.save(supervisor);
                    colabController.defineSupervisor(supervisor.toDTO());
                    CollaboratorDTO finale = colabController.registerCollaborator();
                    colabController.saveCollaborator(finale);

                    String descricao = element.getElementsByTagName("descricao").item(0).getTextContent();
                    String tipoEquipaID = element.getElementsByTagName("teamTypeID").item(0).getTextContent();
                    String equipaId = element.getElementsByTagName("equipaId").item(0).getTextContent();
                    String acronimo = element.getElementsByTagName("acronym").item(0).getTextContent();
                    String TEdesignacao = element.getElementsByTagName("TEdesignacao").item(0).getTextContent();
                    String nome = element.getElementsByTagName("nome").item(0).getTextContent();
                    String hexadecimal = element.getElementsByTagName("hexadecimal").item(0).getTextContent();

                    CreateTeamTypeController controller = new CreateTeamTypeController();
                    CreateColourController corController = new CreateColourController();
                    ColourDTO cor = new ColourDTO(hexadecimal, nome);
                    corController.registo(cor);
                    TeamTypeDTO dto = new TeamTypeDTO(tipoEquipaID, TEdesignacao, cor);
                    controller.registo(dto);

                    CreateTeamController equipaController = new CreateTeamController();
                    List<CollaboratorDTO> responsaveis = new ArrayList<>();
                    CollaboratorDTO collaboratorDTO = finale;
                    responsaveis.add(collaboratorDTO);
                    List<CollaboratorDTO> members = new ArrayList<>();
                    members.add(collaboratorDTO);
                    TeamDTO teamDto1 = new TeamDTO(descricao,acronimo,equipaId,responsaveis,dto,members);


                    CreateTeamBootstrap equipaControllerBootstrap = new CreateTeamBootstrap();
                    equipaControllerBootstrap.registo(teamDto1);

                    SpecifyCriticalityController criticidadeController = new SpecifyCriticalityController();
                    String labelCriti = element.getElementsByTagName("labelCriti").item(0).getTextContent();
                    String valorCriticidade = element.getElementsByTagName("criticalityValue").item(0).getTextContent();
                    String tempoMaximoA = element.getElementsByTagName("tempoMaximoA").item(0).getTextContent();
                    String tempoMedioA = element.getElementsByTagName("tempoMedioA").item(0).getTextContent();
                    String tempoMaximoR = element.getElementsByTagName("tempoMaximoR").item(0).getTextContent();
                    String tempoMedioR = element.getElementsByTagName("tempoMedioR").item(0).getTextContent();

                    CriticalityDTO criticalityDTO = new CriticalityDTO(labelCriti,valorCriticidade,tempoMaximoA,tempoMedioA,tempoMaximoR,tempoMedioR);
                    CriticalityDTO criticidade =  criticidadeController.method(criticalityDTO);
                    criticidadeController.save(criticidade);
                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }


}
