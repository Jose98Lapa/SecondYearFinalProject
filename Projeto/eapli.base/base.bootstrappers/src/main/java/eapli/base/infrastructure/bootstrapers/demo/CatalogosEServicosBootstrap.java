package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.catalogo.application.CriarCatalogoController;
import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.formulario.DTO.FormularioDTO;
import eapli.base.formulario.DTO.atributo.AtributoDTO;
import eapli.base.formulario.application.FormularioController;
import eapli.base.formulario.domain.FormularioID;
import eapli.base.servico.Application.EspecificarServicoController;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.framework.io.util.Console;
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

         CriarCatalogoController catalogoController = new CriarCatalogoController();
         EspecificarServicoController servicoController = new EspecificarServicoController();
         FormularioController formController = new FormularioController();
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

                    catalogoController.insertBasicData(tituloCatalogoC, iconCatalogo,
                            descricaoBreveC, descricaoCompletaC);

                    List<EquipaDTO> lstEquipas = new ArrayList<>();
                    catalogoController.getTeams().forEach(lstEquipas::add);
                    final Set<EquipaDTO> accessCriteria = new HashSet<>();
                    accessCriteria.add(lstEquipas.get(Integer.parseInt(criteriosdeAcesso)-1));

                    catalogoController.defineAccessCriteria(accessCriteria);


                    List<ColaboradorDTO> lstColaboradores = new ArrayList<>();
                    catalogoController.getCollabs().forEach(lstColaboradores::add);
                    final Set<ColaboradorDTO> lstResponsaveis = new HashSet<>();
                    lstResponsaveis.add(lstColaboradores.get(Integer.parseInt(responsaveis)-1));

                    catalogoController.defineResponsibleCollaborator(lstResponsaveis);

                    //List<CriticidadeDTO> lstCriticidade = new ArrayList<>();
                    //catalogoController.getCriticidades().forEach(lstCriticidade::add);
                    //this.theController.defineCriticidade(showCriticityAndChoose());

                    CatalogoDTO catalogo = catalogoController.registerCatalog();
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
                    ArrayList<CatalogoDTO> catalogos = servicoController.catalogList();
                    final Set<String> lstkeyWords = new HashSet<>();
                    lstkeyWords.add(keyWords);
                    ServicoDTO dto = new ServicoDTO(tituloServico, ServicoID, iconServico, lstkeyWords, statusServico, "MANUAL", descricaoBreve, descricaoCompleta,catalogos.get(Integer.parseInt(catalogoS)-1) , null);
                    servicoController.registo(dto);
                    final Set<AtributoDTO> lstAtributos = new HashSet<>();
                    AtributoDTO at = new AtributoDTO(Anome, Alabel, Adescricao, Aregex, Atipo,aID);
                    lstAtributos.add(at);
                    FormularioDTO fdto = new FormularioDTO(fscript,fId,fnome,  lstAtributos);
                    formController.registo(fdto);
                    formController.save();
                    servicoController.manual(fId);
                    servicoController.confirms();

                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }


}
