package gramatica.formulario;

import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.domain.FormName;
import eapli.base.form.domain.FormScript;
import eapli.base.form.domain.attribute.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GramaticaFormularioTest {

    @Test
    void parseWithListener() {
        Set<Attribute> attributeSet = new HashSet<>();
        attributeSet.add(new Attribute(AtributteName.valueOf("nome"), AttributeLabel.valueOf("aa"), AttributeDescription.valueOf("des"), AttributeRegex.valueOf("[a-z]"),AttributeType.valueOf("String"),AttributeID.valueOf("123"),1));
        attributeSet.add(new Attribute(AtributteName.valueOf("noms"), AttributeLabel.valueOf("aaa"), AttributeDescription.valueOf("desc"), AttributeRegex.valueOf("[a-z]+"),AttributeType.valueOf("String"),AttributeID.valueOf("1234"),2));
        Form form = new Form(FormScript.valueOf("test_form_regex.txt"), FormID.valueOf("123"), FormName.valueOf("Nome"),attributeSet);
        assertThrows(ParseCancellationException.class,() ->GramaticaFormulario.parseWithListener("test_form_regex.txt",form));
        Set<Attribute> attributeSet1 = new HashSet<>();
        attributeSet1.add(new Attribute(AtributteName.valueOf("nome"), AttributeLabel.valueOf("10/08/2021"), AttributeDescription.valueOf("des"), AttributeRegex.valueOf("[a-z]"),AttributeType.valueOf("String"),AttributeID.valueOf("12"),1));
        attributeSet1.add(new Attribute(AtributteName.valueOf("noms"), AttributeLabel.valueOf("10/08/2021"), AttributeDescription.valueOf("desc"), AttributeRegex.valueOf("[a-z]+"),AttributeType.valueOf("String"),AttributeID.valueOf("126"),2));
        Form form1 = new Form(FormScript.valueOf("test_form_regex.txt"), FormID.valueOf("1234"), FormName.valueOf("Nome"),attributeSet1);
        GramaticaFormulario.parseWithListener("teste_formulario.txt",form1);
    }


}