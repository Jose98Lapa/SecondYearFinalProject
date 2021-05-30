package eapli.base.utils;

import eapli.base.catalogue.domain.*;
import eapli.base.collaborator.domain.Collaborator;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SplitInfoTest {

    @Test
    public void ensureObjectStaysTheSame() throws IOException {
        String expected = "ESTEmedotoéusadoParaquandoUmObjetoÉDemasiadoGrandeParaSerEnviadouiehfuiehfuiheiufheifiuwehfiuhiufehwliurfhuiwgfuiwehfuioewhiofehwioufhifehwfhewiofheiowhfioewfhioewfioewhfiowehiofeiofewhiofehwiofewoifhewiofheiwofioewfhiowehfioefhioehfioehfioehiofheiofehwiofhewiofheiofheiofhioehfio";
        byte[][] temp = SplitInfo.splitObjectIntoByteArray(expected);
        byte[] actualArray = SplitInfo.serializeObject(SplitInfo.joinSplitInfo(temp));
        String actual = new String(actualArray, StandardCharsets.UTF_8);
        actual = actual.substring(7);
        assertEquals(expected,actual);
    }

}