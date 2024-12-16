package Config;
public class RedisConfig {
    public static final String DEFAULT_HOST = "localhost";
    public static final Integer DEFAULT_PORT = 6379;
    public static final String DEFAULT_PASSWORD = "";
   
    public String host;
    public Integer port;
    public String password;

    public static   String getKeyHoaDonGiaoDich(String transactionid) {
    	return "HoaDonGiaoDich:"+transactionid;
    }
    
    public String getHost() {
        if (host == null) {
            return DEFAULT_HOST;
        } else {
            return host;
        }
    }

   
    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        if (port == null) {
            return DEFAULT_PORT;
        } else {
            return port;
        }
    }


    public void setPort(Integer port) {
        this.port = port;
    }


    public String getPassword() {
        if (password == null) {
            return DEFAULT_PASSWORD;
        } else {
            return password;
        }
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
