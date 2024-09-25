package application.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonIgnoreProperties
public class TrailResponseWS {
    private String error;
    private int count;
    private List<TrailWS> trails;
}
