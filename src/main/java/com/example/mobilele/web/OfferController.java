package com.example.mobilele.web;


import com.example.mobilele.model.dto.CreateOfferDTO;
import com.example.mobilele.model.enums.EngineEnum;
import com.example.mobilele.model.enums.TransmissionEnum;
import com.example.mobilele.repository.BrandRepository;
import com.example.mobilele.repository.OfferRepository;
import com.example.mobilele.service.BrandService;
import com.example.mobilele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final BrandService brandService;
    private final BrandRepository brandRepository;
    private final OfferService offerService;
    private final OfferRepository offerRepository;


    public OfferController(BrandRepository brandRepository, BrandService brandService,
                           OfferRepository offerRepository, OfferService offerService) {
        this.brandRepository = brandRepository;
        this.brandService = brandService;
        this.offerRepository = offerRepository;
        this.offerService = offerService;
    }

    //ToDo: html ->  [ href="/offers/add" ] needs to be changed where it is for adding offer (offerController)

    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("createOfferDTO")) {

            model.addAttribute("createOfferDTO", new CreateOfferDTO());
        }

        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";

    }

    @ModelAttribute("engines")
    public EngineEnum[] engines() {
        return EngineEnum.values();
    }

    @ModelAttribute("transmissions")
    public TransmissionEnum[] transmissions() {
        return TransmissionEnum.values();
    }


    @PostMapping("/add")
    public String add( @Valid CreateOfferDTO createOfferDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createOfferDTO", createOfferDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            System.out.println(createOfferDTO.getYear());
            System.out.println(createOfferDTO.getMileage());

            return "redirect:/offer/add";

        }

        UUID newOfferUUID = offerService.createOffer(createOfferDTO);

        return "redirect:/offer/" + newOfferUUID;
    }

    @GetMapping("/{uuid}/details")
    public String details(@PathVariable("uuid")UUID uuid) {
        return "details";
    }

}
