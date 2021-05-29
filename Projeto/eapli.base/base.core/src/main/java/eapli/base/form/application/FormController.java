package eapli.base.form.application;

import eapli.base.form.Builder.FormBuilder;
import eapli.base.form.DTO.FormDTO;
import eapli.base.form.DTO.attribute.AttributeDTO;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.attribute.*;
import eapli.base.form.repository.FormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import javax.persistence.ElementCollection;
import java.util.HashSet;
import java.util.Set;

public class FormController {
    @ElementCollection
    private final AuthorizationService authz =AuthzRegistry.authorizationService();
    private final FormRepository repo = PersistenceContext.repositories().form();
    FormBuilder fmb = new FormBuilder();

    Form form;
    public void registerForm(FormDTO dto){
        Set<Attribute> atr2 = new HashSet<>();
        for (AttributeDTO atr:dto.atrDTO) {
            atr2.add(new Attribute(AtributteName.valueOf(atr.nome), AttributeLabel.valueOf(atr.label), AttributeDescription.valueOf(atr.desc), AttributeRegex.valueOf(atr.regex), AttributeType.valueOf(atr.tipo), AttributeID.valueOf(atr.id)));
        }
        fmb.setNome(dto.nome).setId(dto.id).setScript(dto.script).setAtr(atr2);
    }
    public Form save(){
        form=fmb.build();
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GSH,BaseRoles.POWER_USER);
        return repo.save(form);
    }
   /* public void atributo(String nome, String desc, String label, String tipo, String regex){
        Atributo atr = atributoBuilder.withNome(nome).withDesc(desc).withLabel(label).withTipo(tipo).withRegex(regex).build();
        atributos.add(atr);
    }*/

}
