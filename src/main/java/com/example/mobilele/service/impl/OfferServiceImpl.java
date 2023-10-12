package com.example.mobilele.service.impl;

import com.example.mobilele.model.dto.CreateOfferDTO;
import com.example.mobilele.repository.OfferRepository;
import com.example.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {

        this.offerRepository = offerRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {
        //TODO: create offer
        throw new UnsupportedOperationException("Coming soon!");
    }
}
