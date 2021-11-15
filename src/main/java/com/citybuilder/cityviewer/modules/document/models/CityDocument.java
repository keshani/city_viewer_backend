package com.citybuilder.cityviewer.modules.document.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Entity to save City document data
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Getter
@Setter
@Entity
@Table(name = "CITY_DOCUMENT")
public class CityDocument implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "DOC_PATH")
    @NotNull
    private String docPath;

    @Column(name = "DOC_NAME")
    private String name;

    @NotNull
    @Column(name = "DOC_BELONGS_TO")
    private Long belongsToId;

    @Column(name = "DOC_TYPE")
    private String docType;

}
