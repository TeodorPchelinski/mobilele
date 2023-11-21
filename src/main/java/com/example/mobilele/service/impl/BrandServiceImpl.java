package com.example.mobilele.service.impl;

import com.example.mobilele.model.dto.BrandDTO;
import com.example.mobilele.model.dto.ModelDTO;
import com.example.mobilele.model.entity.ModelEntity;
import com.example.mobilele.repository.BrandRepository;
import com.example.mobilele.repository.ModelRepository;
import com.example.mobilele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(ModelRepository modelRepository,
                            BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {

    //TODO: Brand and Model implementation

        return brandRepository.findAll().stream()
                .map(brand -> new BrandDTO(
                        brand.getName(),
                        brand.getModels().stream()
                                .map(model -> new ModelDTO(model.getId(), model.getName()))
                                .sorted(Comparator.comparing(ModelDTO::name))
                                .collect(Collectors.toList())
                            ))
                            .sorted(Comparator.comparing(BrandDTO::name))
                            .collect(Collectors.toList());

    }
}