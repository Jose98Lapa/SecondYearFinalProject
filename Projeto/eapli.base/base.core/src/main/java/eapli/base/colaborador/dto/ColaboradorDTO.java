package eapli.base.colaborador.dto;

import eapli.base.colaborador.domain.*;
import eapli.base.funcao.domain.Funcao;
import eapli.framework.representations.dto.DTO;

@SuppressWarnings("squid:ClassVariableVisibilityCheck")
@DTO
public class ColaboradorDTO {
    public String estrada;
    public String numPorta;
    public String andar;
    public String localizacao;
    public String codPostal;
    public String contacto;
    public String nomeCompleto;
    public String email;
    public String mNumber;
    public String alcunha;
    public String dataDeNascimento;
    public String designacao;
    public String IDfuncao;
    public String mSupervisor;

    public ColaboradorDTO(String estrada, String numPorta, String andar, String localizacao, String codPostal, String contacto, String nomeCompleto, String email, String mNumber, String alcunha, String dataDeNascimento) {
        this.estrada = estrada;
        this.numPorta = numPorta;
        this.andar = andar;
        this.localizacao = localizacao;
        this.codPostal = codPostal;
        this.contacto = contacto;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.mNumber = mNumber;
        this.alcunha = alcunha;
        this.dataDeNascimento = dataDeNascimento;
    }

    public ColaboradorDTO(Morada morada, Contacto contacto, NomeCompleto nomeCompleto, EmailInstitucional email, NumeroMecanografico mNumber, Alcunha alcunha, DataDeNascimento dataDeNascimento, Funcao funcao, Colaborador Supervisor){
        MoradaDTO moradaDTO = morada.toDTO();
        this.estrada=moradaDTO.estrada;
        this.numPorta=moradaDTO.numPorta;
        this.andar=moradaDTO.andar;
        this.localizacao=moradaDTO.localizacao;
        this.codPostal=moradaDTO.codPostal;
        this.contacto=contacto.toString();
        this.nomeCompleto=nomeCompleto.toString();
        this.email=email.toString();
        this.mNumber=mNumber.toString();
        this.alcunha=alcunha.toString();
        this.dataDeNascimento=dataDeNascimento.toString();
        this.designacao=funcao.toDTO().designacao;
        this.IDfuncao=funcao.toDTO().IdFuncao;
        this.mSupervisor=Supervisor.identity().toString();
    }

    public ColaboradorDTO(Morada morada, Contacto contacto, NomeCompleto nomeCompleto, EmailInstitucional email, NumeroMecanografico mNumber, Alcunha alcunha, DataDeNascimento dataDeNascimento, Funcao funcao){
        MoradaDTO moradaDTO = morada.toDTO();
        this.estrada=moradaDTO.estrada;
        this.numPorta=moradaDTO.numPorta;
        this.andar=moradaDTO.andar;
        this.localizacao=moradaDTO.localizacao;
        this.codPostal=moradaDTO.codPostal;
        this.contacto=contacto.toString();
        this.nomeCompleto=nomeCompleto.toString();
        this.email=email.toString();
        this.mNumber=mNumber.toString();
        this.alcunha=alcunha.toString();
        this.dataDeNascimento=dataDeNascimento.toString();
        this.designacao=funcao.toDTO().designacao;
        this.IDfuncao=funcao.toDTO().IdFuncao;
    }


}
