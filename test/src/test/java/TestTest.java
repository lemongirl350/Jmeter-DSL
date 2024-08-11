import static Controllers.SimpleController.delay;
import static Controllers.TransactionController.*;
import static us.abstracta.jmeter.javadsl.JmeterDsl.*;
import static us.abstracta.jmeter.javadsl.JmeterDsl.csvDataSet;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class TestTest {

    @Test
    public void testTransactions() throws IOException {
        testPlan(
                httpCookies(),
                httpCache(),
                vars()
                        .set("HOST", "desktop-cv7tcem")
                        .set("PORT", "23232")
                        .set("PROTOCOL", "http")
                        .set("ADMIN_LOGIN", "admin")
                        .set("ADMIN_PASS", "admindev"),
                csvDataSet(testResource("users.csv"))
                        .variableNames("login_csv", "pass_csv", "id_csv"),
                threadGroup(3, 3,
                        tcAdminLogin(),
                        delay(),
                        tcCreateUser(),
                        delay(),
                        tcCreateTicket(),
                        delay(),
                        tcPagination(),
                        delay(),
                        tcFilter(),
                        delay(),
                        tcOpenTask(),
                        delay(),
                        tcChangeStatus(),
                        delay(),
                        tcDeleteTicket(),
                        delay(),
                        tcCloseTicket(),
                        delay(),
                        tcLogout(),
                        delay(),
                        tcComplex()
                ),
                resultsTreeVisualizer(),
                influxDbListener("http://localhost:8086/write?db=jmeter")
                        .measurement("BoyarshinovaSM")
        ).run();
    }
}
