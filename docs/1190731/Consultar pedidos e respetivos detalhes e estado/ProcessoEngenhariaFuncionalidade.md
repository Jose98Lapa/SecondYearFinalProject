# USDemo1
=======================================


# 1. Requisitos

Como utilizador, eu pretendo consultar os meus pedidos (em curso ou o histórico) e respetivos detalhes/estado.

# 3. Design

Para a realização desta UC foi utilizado um controller que obtem o email do colaborador com sessao iniciada e através deste é possivel conseguir todos os tickets pedidos por este utilizador. Após ter esta informaçao apenas é necessário preparar a informacao , ou seja ordenar e separar por estado, na classe ManageTicketListsService.

# 4. Implementação

```
public class CheckUserTicketsController {
    private TicketRepository ticketRepository =  PersistenceContext.repositories().tickets();
    ManageTicketListsService manageService = new ManageTicketListsService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    public  LinkedList<String> loadInformation() {
        String email = authz.session().get().authenticatedUser().email().toString();
        ArrayList<Ticket> list = (ArrayList<Ticket>) ticketRepository.getTicketsByClient(email);
        return manageService.prepareInformation(list);
    }
}

-----------------------------------------------------------------------------------------------------------

public LinkedList<String> prepareInformation(List<Ticket> list) {
        AnsiConsole.systemInstall();
        LinkedList<String> toReturn = new LinkedList<>();
        LinkedList<Ticket> sortedInput = sortTicketsByDate(list);
        for (Ticket ticket:sortedInput) {
            Ansi line =null;
            String str = "";
            if(ticket.status().equals(TicketStatus.valueOf( Constants.COMPLETE ))){
                str=ticket.displayInfoForList();
                line = ansi().fg(GREEN).a(str).reset();
            }else{
                str=ticket.displayInfoForList();
                line = ansi().fg(DEFAULT).a(str).reset();
            }
            toReturn.add(line.toString());
        }
        return toReturn;

    }

    private LinkedList<Ticket> sortTicketsByDate(List<Ticket> list) {
        list.sort(Ticket::compareBySolicitedOn);
        Collections.reverse(list);
        return new LinkedList<>(list);
    }
```