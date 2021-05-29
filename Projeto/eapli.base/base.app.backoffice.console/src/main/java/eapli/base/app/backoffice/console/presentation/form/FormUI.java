package eapli.base.app.backoffice.console.presentation.form;

import eapli.base.form.DTO.FormDTO;
import eapli.base.form.DTO.attribute.AttributeDTO;
import eapli.base.form.application.FormController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class FormUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(FormUI.class);
    public String formId;

    private final FormController theController = new FormController();

    @Override
    protected boolean doShow() {
        final FormDataWidget ifo = new FormDataWidget();
        ifo.show();
        formId = ifo.id();
        final AttributesDataWidget atrib = new AttributesDataWidget();
        Set<AttributeDTO> atr = new HashSet<>();
        String opt;
        try {
            opt = Console.readLine("Informação relativa aos atributos ( Enter para continuar | Exit para sair )");
            while (!opt.equalsIgnoreCase("Exit")) {
                atrib.show();
                AttributeDTO dto = new AttributeDTO(atrib.getNome(), atrib.getLabel(), atrib.getDesc(), atrib.getRegex(), atrib.getTipo(), atrib.getId());
                atr.add(dto);
                opt = Console.readLine("Informação relativa aos atributos ( Enter para continuar | Exit para sair )");
            }
            FormDTO dto = new FormDTO(ifo.script(), ifo.id(), ifo.nome(), atr);
            theController.registerForm(dto);
            theController.save();
        } catch (final IntegrityViolationException | ConcurrencyException | IllegalArgumentException e) {
            System.out.printf("Infelizmente ocorreu um erro na aplicação, por favor tente novamente: %s%n", e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Especificar Formulario";
    }

}