package org.launchcode.controllers;


import org.launchcode.models.Category;
import org.launchcode.models.Cheese;
import org.launchcode.models.Menu;
import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.data.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Hackman
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CheeseDao cheeseDao;

    // Request path: /category
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("menus", menuDao.findAll());
        model.addAttribute("title", "Menus");

        // TODO #1 return "/menu/view/5";
        return "";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Menu");
        model.addAttribute(new Menu());
        model.addAttribute("menu", menuDao.findAll());
        return "menu/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(
            @ModelAttribute  @Valid Menu menu,
            Errors errors,
            Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu");
            model.addAttribute(new Menu());
            model.addAttribute("menu", menuDao.findAll());
            return "menu/add";
        }

        menuDao.save(menu);
        return "redirect:view/" + menu.getId();
    }

    @RequestMapping(value = "view/menu.id", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int id) {

        model.addAttribute("title", "View Menu");
        model.addAttribute(new Menu());
        model.addAttribute("menu", menuDao.findOne(id));

        return "menu/view";
    }


}
