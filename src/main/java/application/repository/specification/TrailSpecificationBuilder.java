package application.repository.specification;

import application.bean.BooleanEnum;
import application.bean.TrailFilterRequestWS;
import application.repository.entity.Trail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import static java.util.Objects.isNull;

@Slf4j
public class TrailSpecificationBuilder {

    public static final String FISHING = "fishing";
    public static final String BIKING = "bikeTrail";
    public static final String PARKING = "adaParking";
    public static final String RECYCLING = "recycleBin";
    public static final String FEE = "fee";
    public static final String TRASH_CAN_MIN = "trashCans";
    public static final String TOILET = "adaToilet";

    public static Specification<Trail> buildSpecification(TrailFilterRequestWS trailFilterRequestWS) {
        return Specification
                .where(isFishing(trailFilterRequestWS.getCanFish()))
                .and(isBiking(trailFilterRequestWS.getIsBikeTrail()))
                .and(hasParking(trailFilterRequestWS.getCanPark()))
                .and(hasRecycling(trailFilterRequestWS.getHasRecycling()))
                .and(hasFee(trailFilterRequestWS.getHasFee()))
                .and(trashCans(trailFilterRequestWS.getMinTrashCans()))
                .and(hasToilet(trailFilterRequestWS.getHasToilet()));
    }

    private static Specification<Trail> isBiking(BooleanEnum isBikeTrail) {
        return ((root, query, cb) -> isNull(isBikeTrail)  ? cb.conjunction() : cb.equal(root.get(BIKING), isBikeTrail.toString()));
    }

    private static Specification<Trail> isFishing(BooleanEnum canFish) {
        return ((root, query, cb) -> isNull(canFish)  ? cb.conjunction() : cb.equal(root.get(FISHING), canFish.toString()));
    }

    private static Specification<Trail> hasParking(BooleanEnum canPark) {
        return ((root, query, cb) -> isNull(canPark)  ? cb.conjunction() : cb.equal(root.get(PARKING), canPark.toString()));
    }

    private static Specification<Trail> hasRecycling(BooleanEnum hasRecycling) {
        return ((root, query, cb) -> isNull(hasRecycling)  ? cb.conjunction() : cb.equal(root.get(RECYCLING), hasRecycling.toString()));
    }

    private static Specification<Trail> hasFee(BooleanEnum hasFee) {
        return ((root, query, cb) -> isNull(hasFee)  ? cb.conjunction() : cb.equal(root.get(FEE), hasFee.toString()));
    }

    private static Specification<Trail> trashCans(Integer trashCanCount) {
        return ((root, query, cb) -> isNull(trashCanCount)  ? cb.conjunction() : cb.ge(root.get(TRASH_CAN_MIN), trashCanCount));
    }

    private static Specification<Trail> hasToilet(BooleanEnum hasToilet) {
        return ((root, query, cb) -> isNull(hasToilet)  ? cb.conjunction() : cb.equal(root.get(TOILET), hasToilet.toString()));
    }
}
