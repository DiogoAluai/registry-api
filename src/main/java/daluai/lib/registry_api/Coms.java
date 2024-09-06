package daluai.lib.registry_api;

import daluai.lib.network_utils.property.PropertyManager;

import static daluai.lib.network_utils.property.PropertyKeys.FLY_APP_NAME;

public class Coms {

    public static final String REGISTRY_CONFIG_PROPERTIES = "registry_config.properties";
    public static final PropertyManager REGISTRY_PROPERTY_MANAGER = PropertyManager.of(REGISTRY_CONFIG_PROPERTIES);

    public static final String REGISTRY_FLY_NAME = REGISTRY_PROPERTY_MANAGER.getProperty(FLY_APP_NAME);
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
