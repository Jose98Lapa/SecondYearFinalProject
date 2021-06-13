package eapli.base.app.user.console.presentation.feedbackUI;

import eapli.base.app.backoffice.console.Utils;
import eapli.base.feedback.DTO.FeedbackDTO;
import eapli.base.feedback.application.ReviewTicketController;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ReviewTicketUI extends AbstractUI {

    private final ReviewTicketController reviewTicketController = new ReviewTicketController();

    @Override
    protected boolean doShow() {
        List<TicketDTO> ticketDTOList = reviewTicketController.getTicketDTOByClient();
        int option = Utils.showAndSelectIndex(ticketDTOList, "Selecione o Ticket que quer deixar o feedback");
        if (option == -1) return false;
        TicketDTO ticketDTO = ticketDTOList.get(option);
        int feedback = eapli.base.app.user.console.presentation.Utils.selectIndex(5,"Insira o valor de 0 a 5",0);
        FeedbackDTO feedbackDTO = new FeedbackDTO(feedback);
        reviewTicketController.createFeedback(feedbackDTO,ticketDTO);

        return false;
    }

    @Override
    public String headline() {
        return "Avalie o Ticket";
    }
}
