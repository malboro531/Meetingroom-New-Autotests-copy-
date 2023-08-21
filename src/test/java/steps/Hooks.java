package steps;

import api.managers.TestRailManager;
import api.services.TestRails;
import org.json.simple.JSONObject;
import org.testng.ITestResult;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static constants.TestRail.*;

public class Hooks {

    private final TestRailManager testRailManager = new TestRailManager();
    private JSONObject addRunResponse;
    private JSONObject addResultForCaseResponse;
    private File file = new File("allure-results\\screenshot.png");

    public void addRun(Class<? extends TestRailAble> thisClass) {
        List<String> caseIds = new ArrayList<>();
        for (Method method : thisClass.getMethods()) {
            if (method.isAnnotationPresent(TestRails.class)) {
                String caseId = getCaseId(method);
                if (testRailManager.getCase(caseId) != null) {
                    caseIds.add(caseId);
                }
            }
        }
        if (!caseIds.isEmpty()) {
            addRunResponse = testRailManager.addRun(caseIds, thisClass.getName());
        }
    }

    public void setStatus(Method method, ITestResult result, Class<? extends TestRailAble> thisClass, String runId) {
        int status;
        String comment;
        switch (result.getStatus()) {
            case ITestResult.SUCCESS -> {
                status = SUCCESS_STATE;
                comment = SUCCESS_COMMENT;
            }
            case ITestResult.FAILURE -> {
                status = FAIL_STATE;
                comment = FAILED_COMMENT;
            }
            case ITestResult.SKIP -> {
                status = SKIP_STATE;
                comment = SKIPPED_COMMENT;
            }
            default -> throw new RuntimeException();
        }
        try {
            Method m = thisClass.getMethod(method.getName());
            if (m.isAnnotationPresent(TestRails.class)) {
                String caseId = getCaseId(m);
                addResultForCaseResponse = testRailManager.setStatus(runId, caseId, status, comment);
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        setAttachment();
    }

    public String getCaseId(Method method) {
        return method.getAnnotation(TestRails.class).id().replaceAll("\\D", "");
    }

    public void setStatusWrapper(Method method, ITestResult result, Class<? extends TestRailAble> thisClass) {
        if (addRunResponse != null) {
            String runId = testRailManager.getId(addRunResponse);
            setStatus(method, result, thisClass, runId);
        } else {
            if (testRailManager.getRun(RUN_ID) != null) {
                setStatus(method, result, thisClass, RUN_ID);
            }
        }
    }

    public void setAttachment() {
        String resultId = testRailManager.getId(addResultForCaseResponse);
        testRailManager.setAttachment(file, resultId);
    }
}
