package api.sendrequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DescriptionLang {
    @JsonProperty("translation_lang")
    private String translationLang;
    private String translation;
}
