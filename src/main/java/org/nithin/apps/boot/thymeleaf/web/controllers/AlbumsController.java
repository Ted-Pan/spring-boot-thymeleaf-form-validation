/**
 * 
 */
package org.nithin.apps.boot.thymeleaf.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.nithin.apps.boot.thymeleaf.web.domain.Album;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nithin meshram
 *         20-Feb-2016
 *
 */
@Controller
public class AlbumsController {

    private static final Logger logger = LoggerFactory.getLogger(AlbumsController.class);

    private Map<String, Album> albumsStore = new HashMap<>();

    @RequestMapping(path = { "/", "/home" }, method = RequestMethod.GET)
    public String showHome() {
        logger.debug("in showHome");

        return "home";
    }


    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public ModelAndView showAddAlbum() {
        logger.debug("in showAddAlbum");

        ModelAndView mav = new ModelAndView();
        mav.addObject("album", new Album());
        mav.setViewName("add");

        return mav;
    }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addAlbum(@ModelAttribute @Valid Album album, BindingResult bindingResult) {
        logger.debug("in addAlbum => " + album);

        if (bindingResult.hasErrors()) {
            logger.warn("There are validation errors");
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError oe : allErrors) {
                logger.debug("Error => " + oe.getDefaultMessage());
            }
            return "add";
        }

        albumsStore.put(album.getTitle(), album);

        logger.debug("Forwarding to the albums list...");
        return "redirect:view";
    }


    @RequestMapping(path = "/view", method = RequestMethod.GET)
    public ModelAndView showAlbumsList() {
        logger.debug("in showAlbumsList");

        ModelAndView mav = new ModelAndView();
        mav.addObject("albums", albumsStore.values());
        mav.setViewName("view");

        return mav;
    }

}
