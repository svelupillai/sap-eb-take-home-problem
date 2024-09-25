package application.mappers;

import application.bean.TrailWS;
import application.repository.entity.Trail;

public interface TrailMapper {
    TrailWS mapToBean(Trail application);
}
