package eapli.base.formulario.DTO;

import eapli.base.atributo.DTO.AtributoDTO;
import eapli.base.atributo.domain.Atributo;
import eapli.base.formulario.domain.FormularioID;
import eapli.base.formulario.domain.FormularioNome;
import eapli.base.formulario.domain.FormularioScript;

import java.util.Set;

public class FormularioDTO {
    public String script;
    public String id;
    public String nome;
    public Set<AtributoDTO> atrDTO;

    public FormularioDTO(FormularioScript script, FormularioID id, FormularioNome nome, Set<Atributo> atr) {
        this.script= script.toString();
        this.id= id.toString();
        this.nome= nome.toString();
        for (Atributo atributo:atr) {
            this.atrDTO.add(atributo.toDTO());
        }
    }

}