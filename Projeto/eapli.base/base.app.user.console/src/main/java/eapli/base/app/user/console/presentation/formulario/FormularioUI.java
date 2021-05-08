package eapli.base.app.user.console.presentation.formulario;

import eapli.base.formulario.Builder.AtributoBuilder;
import eapli.base.formulario.DTO.FormularioDTO;
import eapli.base.formulario.DTO.atributo.AtributoDTO;
import eapli.base.formulario.application.FormularioController;
import eapli.base.formulario.domain.FormularioID;
import eapli.base.formulario.domain.atributo.Atributo;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.AnnotatedType;
import java.util.HashSet;
import java.util.Set;

public class FormularioUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(FormularioUI.class);
    public String formId;

    private final FormularioController theController = new FormularioController();

    @Override
    protected boolean doShow() {
        final FormularioDataWidget ifo = new FormularioDataWidget();
        ifo.show();
        formId=ifo.id();
        final AtributosDataWidget atrib = new AtributosDataWidget();
        Set<AtributoDTO> atr = new HashSet<>();
        String opt;
        opt = Console.readLine("Informação relativa aos atributos ( Enter para continuar | Exit para sair )");
        while (!opt.equalsIgnoreCase("Exit")) {
            atrib.show();
            AtributoDTO dto = new AtributoDTO(atrib.getNome(),atrib.getLabel(),atrib.getDesc(),atrib.getRegex(),atrib.getTipo(),atrib.getId());
            atr.add(dto);
            opt = Console.readLine("Informação relativa aos atributos ( Enter para continuar | Exit para sair )");
        }
        FormularioDTO dto = new FormularioDTO(ifo.script(), ifo.id(), ifo.nome(), atr);
        theController.registo(dto);
        theController.save();
        return true;
    }

    @Override
    public String headline() {
        return "Especificar Formulario";
    }

}