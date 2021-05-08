package eapli.base.app.user.console.presentation;

import eapli.base.TipoEquipa.Application.CriarTipoEquipaController;
import eapli.base.TipoEquipa.DTO.TipoEquipaDTO;
import eapli.base.cor.DTO.CorDTO;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CriarTipoEquipaUI extends AbstractUI {
    private final Logger LOGGER =  LoggerFactory.getLogger(CriarEquipaUI.class);
    private CriarTipoEquipaController criarTipoEquipaController = new CriarTipoEquipaController();

    @Override
    protected boolean doShow() {
        List<CorDTO> corDTOList = new ArrayList<>(30);
        String ID = Console.readLine("Insira o ID do tipo de Equipa");
        String descricao = Console.readLine("Insira a descrição");
        for (CorDTO corDTO : criarTipoEquipaController.getCores()){
            corDTOList.add(corDTO);
        }
        int position;
        boolean continueLoop = true;
        CorDTO corDTO=null;
        while (continueLoop){
            for (int i=0;i< corDTOList.size();i++){
                System.out.printf("%d -> %s \n",i+1,corDTOList.get(i).nome);
            }
            position = Console.readInteger("Insira a cor pretendida");
            if (position<0||position>corDTOList.size()){
                System.out.println("A posição está errada por isso será necessário reintroduzir o valor da posição dentro dos limites");

            }else{
                continueLoop = false;
                corDTO = corDTOList.get(position-1);
            }
        }
        TipoEquipaDTO tipoEquipaDTO = new TipoEquipaDTO(ID,descricao,corDTO);
        try{
            criarTipoEquipaController.registo(tipoEquipaDTO);
        }catch (final IntegrityViolationException | ConcurrencyException e){
            LOGGER.error("Error performing the operation", e);
            System.out.println("Erro inesperado na aplicação. " +
                    "Por favor tentar novamente.");
        }

        return false;


    }


    @Override
    public String headline() {
        return "Criar Tipo Equipa";
    }
}
