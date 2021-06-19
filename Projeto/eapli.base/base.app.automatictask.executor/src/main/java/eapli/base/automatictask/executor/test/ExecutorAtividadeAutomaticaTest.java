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
        formAnswers.add("1");
        formAnswers.add("2");
        formAnswers.add("3");
        List<String> formApproved = new ArrayList<>();
        formApproved.add("4.60");
        ExecutorAtividadeAutomatica.parseWithListener(email,"teste_atividade_automatica.txt",formAnswers,formApproved);
    }
}