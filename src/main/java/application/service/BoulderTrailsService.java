package application.service;

import application.bean.TrailFilterRequestWS;
import application.bean.TrailResponseWS;

public interface BoulderTrailsService {
    TrailResponseWS findFilteredTrails(TrailFilterRequestWS trailFilterRequestWS, Integer page, Integer size);
}
