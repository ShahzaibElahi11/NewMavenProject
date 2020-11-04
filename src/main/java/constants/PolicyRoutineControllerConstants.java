package constants;

import utils.BaseTest;

public class PolicyRoutineControllerConstants extends BaseTest {

    /**
     * Policy Routine Constants
     */
    public static final String POLICY_ROUTINE = "/policy-routine/";
    public static final String PR_ACTION = "actions";
    public static final String PR_TABLE = "table/?page=0&size=10";
    public static final String DEVICES = "devices";
    public static final String USERS = "users";

    //re-think
    public static final String PR_FILTER_NAME = "TEST_FILTER";

    public static final String GET_POLICY_ROUTINE_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/policy-routine/?page=0&size=1&sort=dateCreated,desc";
    public static final String PUT_POLICY_ROUTINE_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/policy-routine/?page=0&size=1&sort=dateCreated,desc";
    public static final String DELETE_POLICY_ROUTINE_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/policy-routine/?page=0&size=1&sort=dateModified,desc";
    public static final String GET_DEVICE_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/devices/getAllDevices?page=0&size=1&sortBy=_id";

    private PolicyRoutineControllerConstants() { }
}
