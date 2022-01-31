package com.tutorial.api;

import com.tutorial.core.flower.model.Flower;
import com.tutorial.core.flower.service.FlowerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/flower")
public class FlowerController {

    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping("")
    public ModelAndView introduce() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("flower-introduce");
        return mav;
    }

    @PostMapping("")
    public String insert(Flower flower) {

        return "insert-finish";
    }

}
