package utils;

import application.bean.TrailFilterRequestWS;
import application.exceptions.EmptyRequestException;

import static java.util.Objects.isNull;

public class ValidationHelper {

    public static void validateRequest(TrailFilterRequestWS trailFilterRequestWS) {
        if (isNull(trailFilterRequestWS) || trailFilterRequestWS.isEmpty()) {
            throw new EmptyRequestException("The incoming request was empty. Please supply filter params from the following list: isBikeTrail, canFish, canPark, hasRecycling, hasFee, minTrashCans, hasToilet.");
        }
    }
}
