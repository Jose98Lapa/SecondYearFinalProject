package eapli.base.form.application;

import eapli.base.form.DTO.FormDTO;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.repository.FormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.application.TicketService;
import gramatica.formulario.GramaticaFormulario;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.File;
import java.util.Optional;

public class FormService {

    private FormRepository formRepository = PersistenceContext.repositories().form();

    public Optional<FormDTO> retrieveFormByID(FormID formID) {

        Optional<FormDTO> formDTO = formRepository.findByFormID(formID);
        return formDTO;
    }

    public Form getFormFromID(FormID formID) {
        Optional<Form> form = formRepository.ofIdentity(formID);
        if (form.isEmpty())
            throw new IllegalArgumentException("O formulário não se encontra em sistema");
        return form.get();
    }

    public void testForm(Form form, Form form1) {
        TicketService ticketService = new TicketService();
        File script = ticketService.getFIleFromServer(form1);
        String test = GramaticaFormulario.parse(script.getName(), form);
        script.delete();
        if (!"".equals(test))
            System.exit(1);
    }
}
