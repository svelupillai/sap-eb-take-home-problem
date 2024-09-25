package application.service;

import application.bean.BooleanEnum;
import application.bean.TrailFilterRequestWS;
import application.bean.TrailResponseWS;
import application.mappers.TrailMapper;
import application.repository.dao.TrailDAO;
import application.repository.entity.Trail;
import application.service.impl.BoulderTrailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BoulderTrailsServiceImplTest {
    @Mock
    private TrailDAO trailDAO;
    @Mock
    private TrailMapper trailMapper;

    private BoulderTrailsServiceImpl boulderTrailsService;

    @BeforeEach
    public void setUp() {
        boulderTrailsService = new BoulderTrailsServiceImpl(trailDAO, trailMapper);
    }

    @Test
    public void givenTrailFilterWithPage_findFilteredTrails_returnsTrailsFromPageRequest() {
        TrailFilterRequestWS filter = TrailFilterRequestWS.builder().hasFee(BooleanEnum.Yes).build();
        when(trailDAO.findAll(any(Specification.class), any(Pageable.class))).thenReturn(new PageImpl<>(getTrailPage()));

       TrailResponseWS trailResponseWS = boulderTrailsService.findFilteredTrails(filter, 0, 10);

        assertThat(trailResponseWS.getCount()).isEqualTo(1);
    }

    @Test
    public void givenTrailFilter_findFilteredTrails_returnsTrails() {
        TrailFilterRequestWS filter = TrailFilterRequestWS.builder().hasFee(BooleanEnum.Yes).build();
        when(trailDAO.findAll(any(Specification.class))).thenReturn(getTrailPage());

        TrailResponseWS trailResponseWS = boulderTrailsService.findFilteredTrails(filter, null, null);

        assertThat(trailResponseWS.getCount()).isEqualTo(1);
    }

    @Test
    public void givenTrailDaoException_findFilteredTrails_throwsException() {
        TrailFilterRequestWS filter = TrailFilterRequestWS.builder().hasFee(BooleanEnum.Yes).build();
        when(trailDAO.findAll(any(Specification.class), any(Pageable.class))).thenThrow(new RuntimeException());

        assertThatThrownBy(() -> boulderTrailsService.findFilteredTrails(filter, 0, 10));
    }

    private List<Trail> getTrailPage() {
        return List.of(Trail.builder().fee("Yes").build());
    }

}
