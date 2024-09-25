package application.service.impl;

import application.bean.TrailFilterRequestWS;
import application.bean.TrailResponseWS;
import application.bean.TrailWS;
import application.mappers.TrailMapper;
import application.repository.dao.TrailDAO;
import application.repository.entity.Trail;
import application.repository.specification.TrailSpecificationBuilder;
import application.service.BoulderTrailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoulderTrailsServiceImpl implements BoulderTrailsService {
    private final TrailDAO trailDAO;
    private final TrailMapper trailMapper;

    @Override
    public TrailResponseWS findFilteredTrails(TrailFilterRequestWS trailFilterRequestWS, Integer page, Integer size) {
        List<TrailWS> trails;
        Specification<Trail> spec = TrailSpecificationBuilder.buildSpecification(trailFilterRequestWS);
        if (nonNull(page) && nonNull(size)) {
            log.info("Received trial request with page parameters, page = {}, size = {}", page, size);
            trails = trailDAO.findAll(spec, PageRequest.of(page, size)).stream().map(trailMapper::mapToBean).toList();
        } else {
            trails = trailDAO.findAll(spec).stream().map(trailMapper::mapToBean).toList();
        }
        return TrailResponseWS.builder().trails(trails).count(trails.size()).build();
    }
}
