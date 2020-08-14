package dto;
import java.util.List;

public class ZomatoLocationResponseDTO {

    private List<ZomatoLocationDTO> location_suggestions;

    private String status;
    private String has_more;
    private String has_total;
    private String user_has_addresses;

    public List<ZomatoLocationDTO> getLocation_suggestions() {
        return location_suggestions;
    }

    public void setLocation_suggestions(List<ZomatoLocationDTO> location_suggestions) {
        this.location_suggestions = location_suggestions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHas_more() {
        return has_more;
    }

    public void setHas_more(String has_more) {
        this.has_more = has_more;
    }

    public String getHas_total() {
        return has_total;
    }

    public void setHas_total(String has_total) {
        this.has_total = has_total;
    }

    public String getUser_has_addresses() {
        return user_has_addresses;
    }

    public void setUser_has_addresses(String user_has_addresses) {
        this.user_has_addresses = user_has_addresses;
    }
}
