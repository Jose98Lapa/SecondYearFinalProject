package eapli.base.function.DTO;

import eapli.base.function.domain.Designation;
import eapli.base.function.domain.IdFunction;
import eapli.framework.representations.dto.DTO;

@DTO
public class FunctionDTO {
    public String designation;
    public String idFunction;

    public FunctionDTO(String idFunction, String designation) {
        this.designation = designation;
        this.idFunction = idFunction;
    }

    public FunctionDTO(IdFunction idFunction, Designation designation){
        this.idFunction= idFunction.toString();
        this.designation= designation.toString();
    }

    @Override
    public String toString() {
        return "designation: "+designation;
    }
}
