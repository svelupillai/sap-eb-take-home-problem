package application.mappers.impl;

import application.bean.TrailWS;
import application.mappers.TrailMapper;
import application.repository.entity.Trail;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrailMapperImpl implements TrailMapper {
    private MapperFacade facade;

    @PostConstruct
    public void init() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Trail.class, TrailWS.class)
                .byDefault()
                .register();
        facade = mapperFactory.getMapperFacade();
    }
    @Override
    public TrailWS mapToBean(Trail trail) {
        return facade.map(trail, TrailWS.class);
    }
}
