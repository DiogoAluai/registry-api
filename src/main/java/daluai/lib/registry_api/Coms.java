package daluai.lib.registry_api;

public class Coms {

    public static final String REGISTRY_FLY_NAME = getEnvOrFail("COOL_REGISTRY_FLY_NAME");
    public static final String REGISTRY_CLOUD_URL = "https://" + REGISTRY_FLY_NAME + ".fly.dev";
    public static final String REGISTRY_LOCAL_URL = "http://localhost:8080";

    public static final String SERVICE_NAME = "REGISTRY";

    public static final String API_KEY = getEnvOrDefault("API_KEY_REGISTRY", "somekey");

    /**
     * Beware that changing these endpoints may affect non-java scripts that rely on them.
     */
    public static final String ENDPOINT_RETRIEVE = "/retrieve";
    public static final String ENDPOINT_RETRIEVE_ALL = "/retrieveAll";
    public static final String ENDPOINT_REGISTER = "/register";
    public static final String ENDPOINT_DEREGISTER = "/deregister";
    public static final String ENDPOINT_RESET = "/reset";

    private static String getEnvOrFail(String env) {
        String envValue = System.getenv(env);
        if (envValue == null || envValue.isBlank()) {
            throw new IllegalStateException("Value required for system env:" + env);
        }
        return envValue;
    }

    private static String getEnvOrDefault(String env, String defaultValue) {
        String envValue = System.getenv(env);
        if (envValue == null || envValue.isBlank()) {
            return defaultValue;
        }
        return envValue;
    }

}
