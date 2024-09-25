package application.controller;

import application.bean.TrailFilterRequestWS;
import application.bean.TrailResponseWS;
import application.service.BoulderTrailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import utils.ValidationHelper;
import javax.ws.rs.QueryParam;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TrailController {

    private final BoulderTrailsService boulderTrailsService;

    @GetMapping(value = "/trails")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<TrailResponseWS> getCars(@Valid TrailFilterRequestWS trailFilterRequestWS,  @QueryParam("pageSize") Integer pageSize, @QueryParam("size") Integer size) {
        try {
            ValidationHelper.validateRequest(trailFilterRequestWS);
            log.info("Received request to filter trails with request = {}", trailFilterRequestWS);
            return ResponseEntity.ok(boulderTrailsService.findFilteredTrails(trailFilterRequestWS, pageSize, size));
        } catch (Exception e) {
            log.error("Unable to find trails for the requested filter = {} with error message = {}", trailFilterRequestWS, e.getMessage(), e);
            return ResponseEntity.badRequest().body(TrailResponseWS.builder().error(e.getMessage()).build());
        }
    }
}
