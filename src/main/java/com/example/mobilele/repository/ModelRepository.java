package com.example.mobilele.repository;

import com.example.mobilele.model.dto.ModelDTO;
import com.example.mobilele.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    List<ModelDTO> findAllByBrandId(Long id);
}
