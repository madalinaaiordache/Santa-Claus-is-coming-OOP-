package enums;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum AgeCategory {

    @JsonProperty("Baby")
    BABY("Baby"),

    @JsonProperty("Kid")
    KID("Kid"),

    @JsonProperty("Teen")
    TEEN("Teen"),

    @JsonProperty("Young_Adult")
    YOUNG_ADULT("Young_Adult");

    private final String value;

    AgeCategory(final String value) {
        this.value = value;
    }

}
