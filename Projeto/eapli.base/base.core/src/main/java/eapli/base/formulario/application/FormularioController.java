package eapli.base.formulario.application;

import eapli.base.formulario.Builder.builder.AtributoBuilder;
import eapli.base.formulario.domain.atributo.Atributo;
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
    public void registo(FormularioNome nome, FormularioID id, FormularioScript script){
        fmb.setNome(nome.toString()).setId(id.toString()).setScript(script.toString());
    }
    public Formulario save(){
        form=fmb.setAtr(atributos).build();
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.COLABORATOR);
        return repo.save(form);
    }
    public void atributo(String nome, String desc, String label, String tipo, String regex){
        Atributo atr = atributoBuilder.withNome(nome).withDesc(desc).withLabel(label).withTipo(tipo).withRegex(regex).build();
        atributos.add(atr);
    }

}
