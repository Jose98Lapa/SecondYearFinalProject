package eapli.base.servico.builder;

import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.domain.*;

import java.util.Set;

public class ServicoBuilder {
    private TituloServico title;
    private ServicoID id;
    private IconServico icon ;
    private Set<KeyWords> keywords ;
    private StatusServico status  ;
    private TipoServico tipo  ;
    private ServicoScript script  ;
    private Formulario form  ;
    private CompleteDescription compDesc  ;
    private BriefDescription briefDesc ;

    public Servico buildManual() {
        Servico srv = new Servico(title, id, icon, keywords, status, TipoServico.valueOf("MANUAL") );
        srv.setForm(form);
        return srv;
    }

    public Servico buildAutomatic() {
        Servico srv = new Servico(title, id, icon, keywords, status, TipoServico.valueOf("AUTOMATICO") );
        srv.setScript(script);
        return srv;
    }

    public ServicoBuilder Title(String title) {
        this.title = TituloServico.valueOf(title);
        return this;
    }

    public ServicoBuilder briefDesc(String desc) {
        this.briefDesc = BriefDescription.valueOf(desc);
        return this;
    }

    public ServicoBuilder compDesc(String desc) {
        this.compDesc = CompleteDescription.valueOf(desc);
        return this;
    }

    public ServicoBuilder Script(String script) {
        this.script = ServicoScript.valueOf(script);
        return this;
    }

    public ServicoBuilder Id(String id) {
        this.id = ServicoID.valueOf(id);
        return this;
    }

    public ServicoBuilder Icon(String icon) {
        this.icon = IconServico.valueof(icon);
        return this;
    }

    public ServicoBuilder Keywords(Set<String> keywords) {
        this.keywords = KeyWords.valueOf(keywords);
        return this;
    }

    public ServicoBuilder Status(String status) {
        this.status = StatusServico.valueOf(status);
        return this;
    }

    public ServicoBuilder Tipo(String tipo) {
        this.tipo = TipoServico.valueOf(tipo);
        return this;
    }
    public ServicoBuilder Form(Formulario form) {
        this.form = form;
        return this;
    }
}
