package daluai.lib.registry_api;


import java.io.Serializable;

public record Service(
        String name,
        String privateIp,
        String publicIp,
        String port,
        ServiceType type,
        String protocol
) implements Serializable {

    /**
     * Constructor that assumes http/https protocol based on service type
     */
    public Service(String name, String privateIp, String publicIp, String port, ServiceType type) {
        this(name, privateIp, publicIp, port, type, type == ServiceType.PRIVATE ? "http" : "https");
    }

    public Service(String name, String privateIp, String publicIp, String port, ServiceType type, String protocol) {
        this.name = name;
        this.privateIp = privateIp;
        this.publicIp = publicIp;
        this.port = port;
        this.type = type;
        this.protocol = protocol;
        validateService();
    }

    /**
     * Validate if service instance makes sense.
     */
    private void validateService() throws IllegalArgumentException {
        if (isIpStateInvalid()) {
            throw new IllegalArgumentException("Invalid service: " + this);
        }
    }

    /**
     * PRIVATE services must have private ip.
     * CLOUD and OPEN services must have public ip.
     */
    private boolean isIpStateInvalid() {
        return (type.equals(ServiceType.CLOUD) && publicIp != null && publicIp.isBlank())
                || (type.equals(ServiceType.PRIVATE) && privateIp != null && privateIp.isBlank())
                || (type.equals(ServiceType.OPEN) && publicIp != null && publicIp.isBlank());
    }

    public String getPrivateUrl() {
        return protocol + "://" + privateIp + ":" + port;
    }

    public String getPublicUrl() {
        return protocol + "://" + publicIp + ":" + port;
    }

    /**
     * Get service url, depending on service type
     */
    public String getUrl() {
        return protocol + "://" + getIp() + ":" + port;
    }

    /**
     * Get service ip depending on service type.
     */
    public String getIp() {
        return type.equals(ServiceType.PRIVATE) ? privateIp : publicIp;
    }
}


