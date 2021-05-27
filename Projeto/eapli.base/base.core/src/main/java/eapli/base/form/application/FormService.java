package eapli.base.form.application;

import eapli.base.form.DTO.FormDTO;
import eapli.base.form.domain.FormID;
import eapli.base.form.repository.FormRepository;

import java.util.Optional;

public class FormService {

	private FormRepository formRepository;

	public Optional< FormDTO > retrieveFormByID ( FormID formID ) {

		Optional< FormDTO > formDTO = formRepository.findByFormID( formID );
		return formDTO;
	}
}
