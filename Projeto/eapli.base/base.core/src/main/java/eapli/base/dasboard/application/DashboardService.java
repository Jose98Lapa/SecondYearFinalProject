package eapli.base.dasboard.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DashboardService {
    public LinkedList<DashboardInfoDTO> prepareInformation(List<String> input){
        LinkedList toReturn = new LinkedList<DashboardInfoDTO>();
        for (String line:input) {
            String [] segments= line.split("\\|");
            String[] aux = getRemainingTime(segments[1]);
            toReturn.add(new DashboardInfoDTO(segments[3],segments[0],segments[1],segments[2],segments[4],segments[5],aux[0],aux[1]));
        }
        return toReturn;
    }
    private String[] getRemainingTime(String segment) {
        String[] toReturn = new String[2];
        long hours = ChronoUnit.HOURS.between(LocalDateTime.now(),getDateFromString(segment));
        if(hours<1){
            toReturn[1]="1";
        }
        if (hours<2)
            toReturn[1]="3";

        LocalDateTime d1 = LocalDateTime.now();
        LocalDateTime d2 = getDateFromString(segment);

        long days = d1.until(d2, ChronoUnit.DAYS);
        d1 = d1.plusDays(days);
        long hourss = d1.until(d2, ChronoUnit.HOURS);
        d1 = d1.plusHours(hourss);
        long minutes = d1.until(d2, ChronoUnit.MINUTES);
        d1 = d1.plusMinutes(minutes);

        toReturn[0]=hours + " Hours ";
        return toReturn;
    }

    private LocalDateTime getDateFromString(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }

    public LinkedList<DashboardInfoDTO> sortDashboardInfoByCriticality(LinkedList<DashboardInfoDTO> input){
        input.sort( Comparator.comparingInt( o -> Integer.parseInt( o.criticidade ) ) );
        return input;
    }
    public LinkedList<DashboardInfoDTO> sortDashboardInfoByUrgency(LinkedList<DashboardInfoDTO> input){
        input.sort( Comparator.comparingInt( o -> Integer.parseInt( o.urgency ) ) );
        return input;
    }
}
