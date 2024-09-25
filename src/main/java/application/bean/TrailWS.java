package application.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrailWS {
    private long fid;
    private String restrooms;
    private String picnic;
    private String fishing;
    private String aka;
    private String accessType;
    private String classType;
    private String address;
    private String fee;
    private String bikeRack;
    private String bikeTrail;
    private int dogTube;
    private String grills;
    private int trashCans;
    private int parkingSpaces;
    private String adaSurface;
    private String adaToilet;
    private String adaFishing;
    private String adaCamping;
    private String adaPicnic;
    private String adaTrail;
    private String adaParking;
    private String adaFacilit;
    private String adaFacName;
    private String horseTrail;
    private String dateFrom;
    private String dateTo;
    private String recycleBin;
    private String dogCompost;
    private String accessName;
    private String thLeash;
}
