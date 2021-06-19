package eapli.base.form.application;

import eapli.base.form.DTO.FormDTO;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.repository.FormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import gramatica.formulario.GramaticaFormulario;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.Optional;

public class FormService {

	private FormRepository formRepository = PersistenceContext.repositories().form();

	public Optional< FormDTO > retrieveFormByID ( FormID formID ) {

		Optional< FormDTO > formDTO = formRepository.findByFormID( formID );
		return formDTO;
	}

	public Form getFormFromID (FormID formID){
		Optional<Form> form = formRepository.ofIdentity(formID);
		if (form.isEmpty())
			throw new IllegalArgumentException("O formulário não se encontra em sistema");
		return form.get();
	}

	public void testForm(Form form){
		try{
			GramaticaFormulario.parse(form.script().toString(),form);
		}catch (ParseCancellationException e){
			e.printStackTrace();
		}
	}
}
