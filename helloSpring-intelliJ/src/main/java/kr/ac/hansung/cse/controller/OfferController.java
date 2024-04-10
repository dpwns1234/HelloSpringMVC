package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping(value = "/offers")
    public String showOffer(Model model) {
        List<Offer> offers = offerService.getOffers();
        model.addAttribute("id_offers", offers);

        return "offers";
    }
}
