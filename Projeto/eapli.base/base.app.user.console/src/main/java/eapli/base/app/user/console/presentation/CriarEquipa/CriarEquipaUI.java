package eapli.base.app.user.console.presentation.CriarEquipa;

import eapli.base.TipoEquipa.DTO.TipoEquipaDTO;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.application.CriarEquipaController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CriarEquipaUI extends AbstractUI {
    private final Logger LOGGER =  LoggerFactory.getLogger(CriarEquipaUI.class);

    private final CriarEquipaController criarEquipaController = new CriarEquipaController();


    @Override
    protected boolean doShow() {
        String equipaID = Console.readLine("Insira o ID da equipa");
        String acronimo = Console.readLine("Insira o Acrónimo da Equipa");
        String descricao = Console.readLine("Insira a descricao");
        List<TipoEquipaDTO> equipaDTOList = new ArrayList<>(20);
        for (TipoEquipaDTO tipoEquipaDTO: criarEquipaController.getTipoEquipaDTO()){
            equipaDTOList.add(tipoEquipaDTO);
        }
        TipoEquipaDTO tipoEquipaDTO = null;
        boolean continueLoop = true;
        while (continueLoop){
            for (int i=0;i<equipaDTOList.size();i++){
                System.out.printf("%d %s \n",i+1,equipaDTOList.get(i));
            }
            int posicao = Console.readInteger("Insira uma posição válida");
            if (posicao<0||posicao>equipaDTOList.size()){
                System.out.println("A posição está errada por isso será necessário reintroduzir o valor da posição dentro dos limites");

            }else{
                continueLoop = false;
                tipoEquipaDTO = equipaDTOList.get(posicao-1);
            }
        }
        ColaboradorDTO colaboradorDTO = null;
        List<ColaboradorDTO> colaboradorDTOList = new ArrayList<>(20);
        for (ColaboradorDTO colaboradorDTOl : criarEquipaController.getColaboradorDTO()){
            colaboradorDTOList.add(colaboradorDTOl);
        }
        continueLoop = true;


        while (continueLoop){
            for (int i=0;i<colaboradorDTOList.size();i++){
                System.out.printf("%d %s \n",i+1,colaboradorDTOList.get(i));
            }
            int posicao = Console.readInteger("Insira uma posição válida");
            if (posicao<0||posicao>colaboradorDTOList.size()){
                System.out.println("A posição está errada por isso será necessário reintroduzir o valor da posição dentro dos limites");

            }else{
                continueLoop = false;
                colaboradorDTO = colaboradorDTOList.get(posicao-1);
            }
        }




        EquipaDTO equipaDTO = new EquipaDTO(descricao,acronimo,equipaID,tipoEquipaDTO,colaboradorDTO);

        try {
            this.criarEquipaController.registo(equipaDTO);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            LOGGER.error("Error performing the operation", e);
            System.out.println("Erro inesperado na aplicação. " +
                    "Por favor tentar novamente.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Criar Equipa";
    }
}
