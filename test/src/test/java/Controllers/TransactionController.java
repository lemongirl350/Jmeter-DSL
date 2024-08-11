package Controllers;

import org.apache.jmeter.sampler.DebugSampler;
import us.abstracta.jmeter.javadsl.core.controllers.DslTransactionController;

import static Controllers.SimpleController.*;
import static us.abstracta.jmeter.javadsl.JmeterDsl.percentController;
import static us.abstracta.jmeter.javadsl.JmeterDsl.transaction;
import static us.abstracta.jmeter.javadsl.wrapper.WrapperJmeterDsl.testElement;

public class TransactionController {
    public static DslTransactionController tcAdminLogin() {
        return transaction("TC_UC1_Admin authorization",
                adminLogin(),
                testElement("Debug Sampler", new DebugSampler())
                        .prop("displayJMeterVariables", true)
        );
    }

    public static DslTransactionController tcCreateUser() {
        return transaction("TC_UC2_Create user",
                adminLogin(),
                createUser(),
                testElement("Debug Sampler", new DebugSampler())
                        .prop("displayJMeterVariables", true)
        );
    }

    public static DslTransactionController tcCreateTicket() {
        return transaction("TC_UC3_Create ticket",
                adminLogin(),
                createUser(),
                createTicket(),
                testElement("Debug Sampler", new DebugSampler())
                        .prop("displayJMeterVariables", true)
        );
    }

    public static DslTransactionController tcPagination() {
        return transaction("TC_UC4_Pagination",
                adminLogin(),
                createUser(),
                userLogin(),
                pagination(),
                testElement("Debug Sampler", new DebugSampler())
                        .prop("displayJMeterVariables", true)
        );
    }

    public static DslTransactionController tcFilter() {
        return transaction("TC_UC5_Filter",
                adminLogin(),
                createUser(),
                userLogin(),
                filter(),
                testElement("Debug Sampler", new DebugSampler())
                        .prop("displayJMeterVariables", true)
        );
    }

    public static DslTransactionController tcOpenTask() {
        return transaction("TC_UC6_Open task",
                adminLogin(),
                createUser(),
                userLogin(),
                openTask(),
                assignTask(),
                testElement("Debug Sampler", new DebugSampler())
                        .prop("displayJMeterVariables", true)
        );
    }

    public static DslTransactionController tcChangeStatus() {
        return transaction("TC_UC7_Change status",
                adminLogin(),
                createUser(),
                userLogin(),
                openTask(),
                changeStatus(),
                testElement("Debug Sampler", new DebugSampler())
                        .prop("displayJMeterVariables", true)
        );
    }

    public static DslTransactionController tcDeleteTicket() {
        return transaction("TC_UC8_Delete ticket",
                adminLogin(),
                createUser(),
                userLogin(),
                deleteTicket(),
                testElement("Debug Sampler", new DebugSampler())
                        .prop("displayJMeterVariables", true)
        );
    }

    public static DslTransactionController tcCloseTicket() {
        return transaction("TC_UC9_Close ticket",
                adminLogin(),
                createUser(),
                userLogin(),
                closeTicket(),
                testElement("Debug Sampler", new DebugSampler())
                        .prop("displayJMeterVariables", true)
        );
    }

    public static DslTransactionController tcLogout() {
        return transaction("TC_UC10_Logout",
                adminLogin(),
                createUser(),
                userLogin(),
                logout(),
                testElement("Debug Sampler", new DebugSampler())
                        .prop("displayJMeterVariables", true)
        );
    }

    public static DslTransactionController tcComplex() {
        return transaction("TC_UC11_Complex",
                adminLogin(),
                createUser(),
                userLogin(),
                percentController(50.0f,
                        pagination()
                ),
                createTicket(),
                deleteTicket(),
                logout(),
                testElement("Debug Sampler", new DebugSampler())
                        .prop("displayJMeterVariables", true)
        );
    }
}

