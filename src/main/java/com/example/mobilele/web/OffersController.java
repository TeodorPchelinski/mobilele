package com.example.mobilele.web;

import com.example.mobilele.model.dto.CreateOfferDTO;
import com.example.mobilele.model.enums.EngineEnum;
import com.example.mobilele.model.enums.TransmissionEnum;
import com.example.mobilele.service.BrandService;
import com.example.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/offers")// fix
public class OffersController {

    private OfferService offerService;

    private final BrandService brandService;

    public OffersController(OfferService offerService,
                            BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String all() {
        return "offers";
    }




    }

