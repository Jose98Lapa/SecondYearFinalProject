package eapli.base.automatictask.executor.test;

import eapli.base.automatictask.executor.ExecutorAtividadeAutomatica;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ExecutorAtividadeAutomaticaTest {

    @Test
    void parseWithListener() throws IOException {
        String email="tiago@gmail.com";
        List<String> formAnswers = new ArrayList<>();
        List<String> formApproved = new ArrayList<>();
        ExecutorAtividadeAutomatica.parseWithListener(email,"teste_atividade_automatica.txt",formAnswers,formApproved);
    }
}