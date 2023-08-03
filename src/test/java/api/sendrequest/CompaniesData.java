package api.sendrequest;

import java.util.ArrayList;

public class CompaniesData {

    private Integer company_id;
    private String company_name;
    private String company_address;
    private String company_status;
    private String description;
    private ArrayList<DescriptionLang> description_lang;

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getCompany_status() {
        return company_status;
    }

    public void setCompany_status(String company_status) {
        this.company_status = company_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<DescriptionLang> getDescription_lang() {
        return description_lang;
    }

    public void setDescription_lang(ArrayList<DescriptionLang> description_lang) {
        this.description_lang = description_lang;
    }
}
