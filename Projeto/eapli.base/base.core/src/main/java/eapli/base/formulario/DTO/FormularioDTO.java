package eapli.base.formulario.DTO;

import eapli.base.formulario.DTO.atributo.AtributoDTO;
import eapli.base.formulario.domain.atributo.Atributo;
import eapli.base.formulario.domain.FormularioID;
import eapli.base.formulario.domain.FormularioNome;
import eapli.base.formulario.domain.FormularioScript;

import java.util.Set;

public class FormularioDTO {
    public String script;
    public String id;
    public String nome;
    public Set<AtributoDTO> atrDTO;

    public FormularioDTO(String script, String id, String nome, Set<AtributoDTO> atr) {
        this.script= script;
        this.id= id;
        this.nome= nome;
        this.atrDTO = atr;
    }

}