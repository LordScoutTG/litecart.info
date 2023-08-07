package api.sendrequest;

import lombok.Data;

import java.util.ArrayList;

@Data
public class DataResponseCompanies {
    private ArrayList<CompaniesData> data;
    private Meta meta;
}
