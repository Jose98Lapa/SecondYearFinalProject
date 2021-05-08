package eapli.base.infrastructure.bootstrapers;

import eapli.base.TipoEquipa.Application.CriarTipoEquipaController;
import eapli.base.TipoEquipa.DTO.TipoEquipaDTO;
import eapli.base.TipoEquipa.DTO.TipoEquipaDTOParser;
import eapli.base.TipoEquipa.Domain.TipoEquipa;
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

public class OrganizacaoBootstrap {
    private static final String FILENAME = "Organizacao.xml";

    public void initiate() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        EspecificarColaboradorController colabController = new EspecificarColaboradorController();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();
            NodeList colabs = doc.getElementsByTagName("class");
            for (int temp = 0; temp < colabs.getLength(); temp++) {
                Node node = colabs.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String srua = element.getElementsByTagName("srua").item(0).getTextContent();
                    String snumPorta = element.getElementsByTagName("snumPorta").item(0).getTextContent();
                    String sandar = element.getElementsByTagName("sandar").item(0).getTextContent();
                    String slocalizacao = element.getElementsByTagName("slocalizacao").item(0).getTextContent();
                    String snumeroMecanografico = element.getElementsByTagName("snumeroMecanografico").item(0).getTextContent();
                    String scontacto = element.getElementsByTagName("scontacto").item(0).getTextContent();
                    String snomeCompleto = element.getElementsByTagName("snomeCompleto").item(0).getTextContent();
                    String semailInstitucional = element.getElementsByTagName("semailInstitucional").item(0).getTextContent();
                    String salcunha = element.getElementsByTagName("salcunha").item(0).getTextContent();
                    String scodPostal = element.getElementsByTagName("scodPostal").item(0).getTextContent();
                    String sdataDeNascimento = element.getElementsByTagName("sdataDeNascimento").item(0).getTextContent();

                    ColaboradorBuilder builder = new ColaboradorBuilder();
                    Colaborador supervisor = builder.withAddress(srua, snumPorta, sandar, slocalizacao, scodPostal).withContact(scontacto)
                            .withFullName(snomeCompleto).withInstitutionalEmail(semailInstitucional).withMecanoGraphicNumber(snumPorta)
                            .withNickname(salcunha).withDateOfBirth(sdataDeNascimento).withMecanoGraphicNumber(snumeroMecanografico).build();
                    String designacao = element.getElementsByTagName("designacao").item(0).getTextContent();
                    String dataDeNascimento = element.getElementsByTagName("datanascimento").item(0).getTextContent();
                    String rua = element.getElementsByTagName("rua").item(0).getTextContent();
                    String numPorta = element.getElementsByTagName("numPorta").item(0).getTextContent();
                    String andar = element.getElementsByTagName("andar").item(0).getTextContent();
                    String localizacao = element.getElementsByTagName("localizacao").item(0).getTextContent();
                    String numeroMecanografico = element.getElementsByTagName("numeroMecanografico").item(0).getTextContent();
                    String contacto = element.getElementsByTagName("contacto").item(0).getTextContent();
                    String nomeCompleto = element.getElementsByTagName("nomeCompleto").item(0).getTextContent();
                    String emailInstitucional = element.getElementsByTagName("emailInstitucional").item(0).getTextContent();
                    String alcunha = element.getElementsByTagName("alcunha").item(0).getTextContent();
                    String codPostal = element.getElementsByTagName("codPostal").item(0).getTextContent();
                    String idFunc = element.getElementsByTagName("idFunc").item(0).getTextContent();

                    ColaboradorDTO colaDTO = new ColaboradorDTO(rua, numPorta, andar, localizacao, codPostal, contacto, nomeCompleto, emailInstitucional, numeroMecanografico, alcunha, dataDeNascimento);
                    colabController.method(colaDTO);
                    Funcao func = new Funcao(IdFuncao.valueOf(idFunc), Designacao.valueOf(designacao));
                    FuncaoRepository repo = PersistenceContext.repositories().funcao();
                    repo.save(func);
                    colabController.defineFunction(func);
                    CollaboratorRepository repo2 = PersistenceContext.repositories().collaborators();
                    repo2.save(supervisor);
                    colabController.defineSupervisor(supervisor);
                    Colaborador finale = colabController.registerCollaborator();
                    colabController.saveCollaborator(finale);

                    String descricao = element.getElementsByTagName("descricao").item(0).getTextContent();
                    String tipoEquipaID = element.getElementsByTagName("tipoEquipaID").item(0).getTextContent();
                    String equipaId = element.getElementsByTagName("equipaId").item(0).getTextContent();
                    String acronimo = element.getElementsByTagName("acronimo").item(0).getTextContent();
                    String TEdesignacao = element.getElementsByTagName("TEdesignacao").item(0).getTextContent();
                    String nome = element.getElementsByTagName("nome").item(0).getTextContent();
                    String hexadecimal = element.getElementsByTagName("hexadecimal").item(0).getTextContent();

                    CriarTipoEquipaController controller = new CriarTipoEquipaController();
                    CriarCorController corController = new CriarCorController();
                    CorDTO cor = new CorDTO(hexadecimal, nome);
                    corController.registo(cor);
                    TipoEquipaDTO dto = new TipoEquipaDTO(tipoEquipaID, TEdesignacao, cor);
                    controller.registo(dto);

                    CriarEquipaController equipaController = new CriarEquipaController();
                    List<ColaboradorDTO> responsaveis = new ArrayList<>();
                    ColaboradorDTO colaboradorDTO= finale.toDTO();
                    responsaveis.add(colaboradorDTO);
                    EquipaDTO equipaDto = new EquipaDTO(descricao,acronimo,equipaId,dto,colaboradorDTO);
                    equipaController.registo(equipaDto);
                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }


}
