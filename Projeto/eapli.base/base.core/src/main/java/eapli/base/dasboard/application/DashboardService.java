package eapli.base.dasboard.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DashboardService {
    public LinkedList<DashboardInfoDTO> prepareInformation(List<String> input){
        LinkedList toReturn = new LinkedList<DashboardInfoDTO>();
        for (String line:input) {
            String [] segments= line.split("\\|");
            String[] aux = getRemainingTime(segments[1]);
            toReturn.add(new DashboardInfoDTO(segments[3],segments[1],segments[1],segments[2],segments[4],segments[0],aux[0],aux[1]));
        }
        return toReturn;
    }
    private String[] getRemainingTime(String segment) {
        String[] toReturn = new String[2];
        long hours = ChronoUnit.HOURS.between(getDateFromString(segment), LocalDateTime.now());
        if(hours<1){
            toReturn[1]="1";
        }
        if (hours<2)
            toReturn[1]="3";

        long duration  =LocalDateTime.now().getNano() -getDateFromString(segment).getNano() ;

        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
        long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);

        toReturn[0]=diffInMinutes + " Min";
        return toReturn;
    }


    private LocalDateTime getDateFromString(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }

    public LinkedList<DashboardInfoDTO> sortDashboardInfoByCriticality(LinkedList<DashboardInfoDTO> input){
        input.sort((o1, o2) -> Integer.compare(Integer.parseInt(o1.criticidade), Integer.parseInt(o1.criticidade)));
        return input;
    }
    public LinkedList<DashboardInfoDTO> sortDashboardInfoByUrgency(LinkedList<DashboardInfoDTO> input){
        input.sort((o1, o2) -> Integer.compare(Integer.parseInt(o1.urgency), Integer.parseInt(o1.urgency)));
        return input;
    }
}
