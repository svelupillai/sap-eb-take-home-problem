package application.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Trails")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Trail {
    @Id
    @Column(name = "fid")
    private Long fid;

    @Column(name = "restrooms")
    private String restrooms;

    @Column(name = "picnic")
    private String picnic;

    @Column(name = "fishing")
    private String fishing;

    @Column(name = "aka")
    private String aka;

    @Column(name = "accesstype")
    private String accessType;

    @Column(name = "classtype")
    private String classType;

    @Column(name = "address")
    private String address;

    @Column(name = "fee")
    private String fee;

    @Column(name = "bikerack")
    private String bikeRack;

    @Column(name = "biketrail")
    private String bikeTrail;

    @Column(name = "dogtube")
    private int dogTube;

    @Column(name = "grills")
    private String grills;

    @Column(name = "trashcans")
    private int trashCans;

    @Column(name = "parkspaces")
    private int parkingSpaces;

    @Column(name = "adasurface")
    private String adaSurface;

    @Column(name = "adatoilet")
    private String adaToilet;

    @Column(name = "adafishing")
    private String adaFishing;

    @Column(name = "adacamping")
    private String adaCamping;

    @Column(name = "adapicnic")
    private String adaPicnic;

    @Column(name = "adatrail")
    private String adaTrail;

    @Column(name = "adaparking")
    private String adaParking;

    @Column(name = "adafacilit")
    private String adaFacilit;

    @Column(name = "adafacname")
    private String adaFacName;

    @Column(name = "horsetrail")
    private String horseTrail;

    @Column(name = "datefrom")
    private String dateFrom;

    @Column(name = "dateto")
    private String dateTo;

    @Column(name = "recyclebin")
    private String recycleBin;

    @Column(name = "dogcompost")
    private String dogCompost;

    @Column(name = "accessname")
    private String accessName;

    @Column(name = "thleash")
    private String thLeash;
}
