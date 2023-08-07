package api.sendrequest;

import lombok.Data;

@Data
public class Meta {
    private Integer limit;
    private Integer offset;
    private Integer total;
}
