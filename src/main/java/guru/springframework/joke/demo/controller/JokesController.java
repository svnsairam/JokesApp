package guru.springframework.joke.demo.controller;

import guru.springframework.joke.demo.service.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {
    private final JokeService jokeService;

    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/",""})
    public String getJoke(Model model){
        //when the request comes the controller calls the jokeService and gets the object and appends it to the model
        // and returns the view name to the view layer
        // we gonna use thymeleaf to provide view

        // we are appending model with property name called joke
        model.addAttribute("joke",this.jokeService.getRandomJoke());

        // we need to return the view name i.e chucknorris is the view name
        // we need to tell the thymeleaf template to provide view for this.
        return "chucknorris";
    }
}
