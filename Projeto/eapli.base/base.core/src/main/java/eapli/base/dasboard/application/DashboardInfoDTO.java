package eapli.base.dasboard.application;

import eapli.framework.representations.dto.DTOable;

public class DashboardInfoDTO {
    public String icon;
    public String urgency;
    public String deadline;
    public String title;
    public String briefDesc;
    public String criticidade;
    public String remainingTime;
    public String time;

    public DashboardInfoDTO(String icon, String urgency, String deadline, String title, String briefDesc, String criticidade, String remainingTime, String time)  {
        this.icon = icon;
        this.urgency = urgency;
        this.deadline = deadline;
        this.title = title;
        this.briefDesc = briefDesc;
        this.criticidade = criticidade;
        this.remainingTime = remainingTime;
        this.time = time;
    }

}
