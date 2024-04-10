package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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

    @GetMapping(value = "/createOffer")
    public String createOffer(Model model) {
        model.addAttribute("offer", new Offer());
        return "createOffer";
    }

    @PostMapping(value = "/docreate")
    public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");
            List<ObjectError> errors = result.getAllErrors();
            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }
            return "createOffer";
        }

        offerService.insert(offer);
        return "offercreated";
    }
}
