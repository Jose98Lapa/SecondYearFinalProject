package eapli.base.criticality.builder;

import eapli.base.criticality.domain.*;
import eapli.framework.domain.model.DomainFactory;

public class CriticalityBuilder implements DomainFactory<Criticality> {
    private CriticalityValue criticalityValue;
    private Label label;
    private ResolutionObjective resolutionObjective;
    private ApprovalObjective approvalObjective;

    public CriticalityBuilder withValorCriticidade(final CriticalityValue criticalityValue) {
        this.criticalityValue = criticalityValue;
        return this;
    }

    public CriticalityBuilder withValorCriticidade(final String valorCriticidade) {
        this.criticalityValue = new CriticalityValue(valorCriticidade);
        return this;
    }

    public CriticalityBuilder withLabel(final Label label) {
        this.label = label;
        return this;
    }

    public CriticalityBuilder withLabel(final String label) {
        this.label = new Label(label);
        return this;
    }

    public CriticalityBuilder withObjetivoDeAprovacao(final ApprovalObjective approvalObjective) {
        this.approvalObjective = approvalObjective;
        return this;
    }

    public CriticalityBuilder withObjetivoDeAprovacao(final String tempMaxA, final String tempMedA) {
        this.approvalObjective = new ApprovalObjective(tempMaxA,tempMedA);
        return this;
    }

    public CriticalityBuilder withObjetivoDeResolucao(final ResolutionObjective resolutionObjective) {
        this.resolutionObjective = resolutionObjective;
        return this;
    }

    public CriticalityBuilder withObjetivoDeResolucao(final String tempMaxR, final String tempMedR) {
        this.resolutionObjective = new ResolutionObjective(tempMaxR,tempMedR);
        return this;
    }

    @Override
    public Criticality build() {
        return new Criticality(label, criticalityValue, approvalObjective, resolutionObjective);
    }
}
