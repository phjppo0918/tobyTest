package com.tutorial.api;

import com.tutorial.core.flower.model.Flower;
import com.tutorial.core.flower.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ModelAndView introduce(ModelAndView mav) {

        //ModelAndView mav = new ModelAndView();
        mav.setViewName("flower/flower-introduce");
        return mav;
    }

    @GetMapping("/signup")
    public ModelAndView signup() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("flower/insert-flower");
        return mav;
    }

    @PostMapping("")
    public String insert(Flower flower) {
        flowerService.save(flower);
        return "flower/flower-created";
    }

    @GetMapping("/list")
    public String flowerList(Model model) {
        model.addAttribute("flowerList", flowerService.findAll());
        return "flower/flower-list";
    }

    @GetMapping("/{id}")
    public String getFlowerDetail(Model model, @PathVariable Integer id) {
        model.addAttribute("flower",flowerService.findById(id));
        return "flower/flower-detail";
    }

}
