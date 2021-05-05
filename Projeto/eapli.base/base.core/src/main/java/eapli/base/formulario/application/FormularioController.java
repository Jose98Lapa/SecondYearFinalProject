package eapli.base.formulario.application;

import eapli.base.atributo.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.FormularioID;
import eapli.base.formulario.domain.FormularioNome;
import eapli.base.formulario.domain.FormularioScript;
import eapli.base.formulario.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.HashSet;
import java.util.Set;

public class FormularioController {
    private Set<Atributo> atributos = new HashSet<>();
    private final AuthorizationService authz =AuthzRegistry.authorizationService();
    private final FormularioRepository repo = PersistenceContext.repositories().form();

    Formulario form;
    public void registo(FormularioNome nome, FormularioID id, FormularioScript script){
        form = new Formulario(script,id,nome);
    }
    public Formulario save(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.COLABORATOR);
        return repo.save(form);
    }

}
