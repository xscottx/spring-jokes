package guru.springframework.jokes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.jokes.services.JokeService;

@Controller
public class JokeController {

  private JokeService jokeService;

  @Autowired
  public JokeController(JokeService jokeService) {
    this.jokeService = jokeService;
  }

  // added requestmapping for app endpoint, and model for Spring MVC
  @RequestMapping({"/", ""})
  public String showJoke(Model model) {
    // adding Joke string to model
    model.addAttribute("joke", jokeService.getJoke());
    // return view name, chucknorris
    return "chucknorris";
  }
}