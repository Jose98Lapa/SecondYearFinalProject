package eapli.base.formulario.application;

import eapli.base.formulario.Builder.AtributoBuilder;
import eapli.base.formulario.DTO.FormularioDTO;
import eapli.base.formulario.DTO.FormularioDTOParser;
import eapli.base.formulario.DTO.atributo.AtributoDTO;
import eapli.base.formulario.domain.atributo.*;
import eapli.base.formulario.Builder.FormularioBuilder;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.FormularioID;
import eapli.base.formulario.domain.FormularioNome;
import eapli.base.formulario.domain.FormularioScript;
import eapli.base.formulario.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import javax.persistence.ElementCollection;
import java.util.HashSet;
import java.util.Set;

public class FormularioController {
    @ElementCollection
    private Set<Atributo> atributos = new HashSet<>();
    private final AuthorizationService authz =AuthzRegistry.authorizationService();
    private final FormularioRepository repo = PersistenceContext.repositories().form();
    AtributoBuilder atributoBuilder = new AtributoBuilder();
    FormularioBuilder fmb = new FormularioBuilder();

    Formulario form;
    public void registo(FormularioDTO dto){
        Set<Atributo> atr2 = new HashSet<>();
        for (AtributoDTO atr:dto.atrDTO) {
            atr2.add(new Atributo(AtributoNome.valueOf(atr.nome), AtributoLabel.valueOf(atr.label), AtributoDescricao.valueOf(atr.desc), AtributoRegex.valueOf(atr.regex),AtributoTipo.valueOf(atr.tipo)));
        }
        fmb.setNome(dto.nome).setId(dto.id).setScript(dto.script).setAtr(atr2);
    }
    public Formulario save(){
        form=fmb.build();
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CLIENT_USER);
        return repo.save(form);
    }
   /* public void atributo(String nome, String desc, String label, String tipo, String regex){
        Atributo atr = atributoBuilder.withNome(nome).withDesc(desc).withLabel(label).withTipo(tipo).withRegex(regex).build();
        atributos.add(atr);
    }*/

}
