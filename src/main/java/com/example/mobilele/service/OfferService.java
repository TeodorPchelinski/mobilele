package com.example.mobilele.service;

import com.example.mobilele.model.dto.CreateOfferDTO;

import java.util.UUID;

public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);

}
