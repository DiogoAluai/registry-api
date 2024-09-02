package daluai.lib.registry_api;

public class Coms {

    public static final String REGISTRY_FLY_NAME_SYS_ENV = "COOL_REGISTRY_FLY_NAME";
    public static String REGISTRY_FLY_NAME;
    static {
        String registryFlyNameSysEnvValue = System.getenv(REGISTRY_FLY_NAME_SYS_ENV);
        if (registryFlyNameSysEnvValue == null || registryFlyNameSysEnvValue.isBlank()) {
            throw new IllegalStateException("Value required for system env:" + REGISTRY_FLY_NAME_SYS_ENV);
        }
        REGISTRY_FLY_NAME = registryFlyNameSysEnvValue;
    }
    public static final String REGISTRY_CLOUD_URL = "https://" + REGISTRY_FLY_NAME + ".fly.dev";
    public static final String REGISTRY_LOCAL_URL = "http://localhost:8080";


    public static final String SERVICE_NAME = "REGISTRY";

    /**
     * Beware that changing these endpoints may affect non-java scripts that rely on them.
     */
    public static final String ENDPOINT_RETRIEVE = "/retrieve";
    public static final String ENDPOINT_RETRIEVE_ALL = "/retrieveAll";
    public static final String ENDPOINT_REGISTER = "/register";
    public static final String ENDPOINT_DEREGISTER = "/deregister";
    public static final String ENDPOINT_RESET = "/reset";

}
