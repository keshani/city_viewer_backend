package com.citybuilder.cityviewer.common.document.repository;

import com.citybuilder.cityviewer.common.document.models.CityDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<CityDocument,Long> {
}
