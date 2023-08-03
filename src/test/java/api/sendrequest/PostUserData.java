package api.sendrequest;

public class PostUserData {

    private String first_name;
    private String last_name;
    private Integer company_id;

    public PostUserData(String first_name, String last_name, Integer company_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.company_id = company_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }
}
