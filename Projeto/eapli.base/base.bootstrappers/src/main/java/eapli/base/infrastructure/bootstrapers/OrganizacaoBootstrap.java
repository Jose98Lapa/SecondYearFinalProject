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
        SpecifyCriticalityController criticidadeController = new SpecifyCriticalityController();
        CreateTeamBootstrap equipaControllerBootstrap = new CreateTeamBootstrap();


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
                    CollaboratorDTO collab = null;
                    NodeList collaborators = element.getElementsByTagName("collaborator");
                    for (sizeInside = 0; sizeInside < collaborators.getLength(); sizeInside++) {
                        Node nodeCollab = collaborators.item(sizeInside);
                        if (nodeCollab.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementCollab = (Element) nodeCollab;
                            String splaceOfResidence = elementCollab.getElementsByTagName("splaceOfResidence").item(0).getTextContent();
                            String snumeroMecanografico = elementCollab.getElementsByTagName("snumeroMecanografico").item(0).getTextContent();
                            String scontacto = elementCollab.getElementsByTagName("scontacto").item(0).getTextContent();
                            String snomeCompleto = elementCollab.getElementsByTagName("snomeCompleto").item(0).getTextContent();
                            String semailInstitucional = elementCollab.getElementsByTagName("semailInstitucional").item(0).getTextContent();
                            String salcunha = elementCollab.getElementsByTagName("salcunha").item(0).getTextContent();
                            String sdataDeNascimento = elementCollab.getElementsByTagName("sdataDeNascimento").item(0).getTextContent();
                            String Superdesignacao = elementCollab.getElementsByTagName("Superdesignacao").item(0).getTextContent();
                            String SuperidFunc = elementCollab.getElementsByTagName("SuperidFunc").item(0).getTextContent();

                            Function functionSupe = new Function(IdFunction.valueOf(SuperidFunc), Designation.valueOf(Superdesignacao));
                            FunctionRepository repo = PersistenceContext.repositories().funcao();
                            repo.save(functionSupe);

                            CollaboratorBuilder builder = new CollaboratorBuilder();
                            Collaborator supervisor = builder.withPlaceOfResidence(splaceOfResidence).withContact(scontacto)
                                    .withFullName(snomeCompleto).withInstitutionalEmail(semailInstitucional).withMecanoGraphicNumber(snumeroMecanografico)
                                    .withNickname(salcunha).withDateOfBirth(sdataDeNascimento).withMecanoGraphicNumber(snumeroMecanografico).withFunction(functionSupe).build();
                            String designacao = elementCollab.getElementsByTagName("designation").item(0).getTextContent();
                            String dataDeNascimento = elementCollab.getElementsByTagName("datanascimento").item(0).getTextContent();
                            String placeOfResidence = elementCollab.getElementsByTagName("placeOfResidence").item(0).getTextContent();
                            String numeroMecanografico = elementCollab.getElementsByTagName("numeroMecanografico").item(0).getTextContent();
                            String contacto = elementCollab.getElementsByTagName("contact").item(0).getTextContent();
                            String nomeCompleto = elementCollab.getElementsByTagName("fullName").item(0).getTextContent();
                            String emailInstitucional = elementCollab.getElementsByTagName("emailInstitucional").item(0).getTextContent();
                            String alcunha = elementCollab.getElementsByTagName("nickname").item(0).getTextContent();
                            String idFunc = elementCollab.getElementsByTagName("idFunc").item(0).getTextContent();

                            CollaboratorDTO colaDTO = new CollaboratorDTO(placeOfResidence, contacto, nomeCompleto, emailInstitucional, numeroMecanografico, alcunha, dataDeNascimento);
                            colabController.method(colaDTO);
                            Function func = new Function(IdFunction.valueOf(idFunc), Designation.valueOf(designacao));
                            repo.save(func);
                            colabController.defineFunction(func.toDTO());
                            CollaboratorRepository repo2 = PersistenceContext.repositories().collaborators();
                            repo2.save(supervisor);
                            colabController.defineSupervisor(supervisor.toDTO());
                            collab = colabController.registerCollaborator();
                            colabController.saveCollaborator(collab);
                        }
                    }

                    NodeList teams = element.getElementsByTagName("team");
                    for (sizeInside = 0; sizeInside < teams.getLength(); sizeInside++) {
                        Node nodeTeam = teams.item(sizeInside);
                        if (nodeTeam.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementTeam = (Element) nodeTeam;
                            String descricao = elementTeam.getElementsByTagName("descricao").item(0).getTextContent();
                            String tipoEquipaID = elementTeam.getElementsByTagName("teamTypeID").item(0).getTextContent();
                            String equipaId = elementTeam.getElementsByTagName("equipaId").item(0).getTextContent();
                            String acronimo = elementTeam.getElementsByTagName("acronym").item(0).getTextContent();
                            String TEdesignacao = elementTeam.getElementsByTagName("TEdesignacao").item(0).getTextContent();
                            String nome = elementTeam.getElementsByTagName("nome").item(0).getTextContent();
                            String hexadecimal = elementTeam.getElementsByTagName("hexadecimal").item(0).getTextContent();

                            CreateTeamTypeController controller = new CreateTeamTypeController();
                            CreateColourController corController = new CreateColourController();
                            ColourDTO cor = new ColourDTO(hexadecimal, nome);
                            corController.registo(cor);
                            TeamTypeDTO dto = new TeamTypeDTO(tipoEquipaID, TEdesignacao, cor);
                            controller.registo(dto);

                            CreateTeamController equipaController = new CreateTeamController();
                            List<CollaboratorDTO> responsaveis = new ArrayList<>();
                            CollaboratorDTO collaboratorDTO = collab;
                            responsaveis.add(collaboratorDTO);
                            List<CollaboratorDTO> members = new ArrayList<>();
                            members.add(collaboratorDTO);
                            TeamDTO teamDto1 = new TeamDTO(descricao, acronimo, equipaId, responsaveis, dto, members);


                            equipaControllerBootstrap.registo(teamDto1);
                        }
                    }

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
                        }
                    }
                }
            }
                } catch(ParserConfigurationException | IOException | org.xml.sax.SAXException e){
                    e.printStackTrace();
                }
            }


        }
