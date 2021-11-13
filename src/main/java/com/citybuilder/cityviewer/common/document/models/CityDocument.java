package com.citybuilder.cityviewer.common.document.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "CITY_DOCUMENT")
public class CityDocument implements Serializable {
        @Id
        @GeneratedValue
        private Long id;
        @Column(name="DOC_PATH")
        private String docPath;
        @Column(name="DOC_NAME")
        private String name;
        @Column(name="DOC_BELONGS_TO")
        private Long belongsToId;
        @Column(name="DOC_TYPE")
        private String docType;

}
