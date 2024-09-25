package application.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import static java.util.Objects.isNull;

@Builder
@Data
@JsonIgnoreProperties
public class TrailFilterRequestWS {
    private BooleanEnum isBikeTrail;
    private BooleanEnum canFish;
    private BooleanEnum canPark;
    private BooleanEnum hasRecycling;
    private BooleanEnum hasFee;
    private Integer minTrashCans;
    private BooleanEnum hasToilet;

    public boolean isEmpty() {
        return isNull(this.isBikeTrail) && isNull(this.canFish) && isNull(this.canPark) && isNull(this.hasRecycling) && isNull(this.hasFee) && isNull(this.minTrashCans) && isNull(this.hasToilet);
    }
}
