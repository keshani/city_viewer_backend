package com.citybuilder.cityviewer.modules.document.repository;

import com.citybuilder.cityviewer.modules.document.models.CityDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Use to handle all the Document CRUD operations
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Repository
public interface DocumentRepository extends JpaRepository<CityDocument, Long> {
    List<CityDocument> findByBelongsToId(Long belongsToOrgId);
}
