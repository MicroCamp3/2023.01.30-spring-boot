package pl.camp.micro.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.camp.micro.spring.boot.model.User;

import java.util.List;
import java.util.Random;

@Controller
public class SimpleController {

    @RequestMapping(path = "/main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test1() {
        System.out.println("Działa !!!");
        return "redirect:/main";
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    public String test2() {
        System.out.println("Działa test 2 !!!");
        return "redirect:/main";
    }

    @RequestMapping(path = "/test3", method = RequestMethod.GET)
    public String test3(@RequestParam("param1") String info,
                        @RequestParam("param2") String name) {
        System.out.println(info);
        System.out.println(name);
        return "main";
    }

    @RequestMapping(path = "/test4/{param1}/{param2}/{cos}", method = RequestMethod.GET)
    public String test4(@PathVariable String param1,
                        @PathVariable String param2,
                        @PathVariable String cos) {
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(cos);
        return "main";
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    @RequestMapping(path = "/form2", method = RequestMethod.GET)
    public String formResponse(@RequestParam("imie") String name,
                               @RequestParam("nazwisko") String surname,
                               @RequestParam("pesel") String id) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(id);
        return "main";
    }

    @RequestMapping(path = "/test5/{name}/{surname}", method = RequestMethod.GET)
    public String test5(@PathVariable String name,
                        @PathVariable String surname,
                        @RequestParam int wiek) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(wiek);
        return "main";
    }

    @RequestMapping(path = "/test6", method = RequestMethod.GET)
    public String test6(Model model) {
        List<String> names = List.of("Janusz", "Zbyszek", "Wiesiek", " Karol");

        Random random = new Random();
        String randomName = names.get(random.nextInt(4));

        model.addAttribute("imie", randomName);
        model.addAttribute("imiona", names);

        return "imiona";
    }

    @RequestMapping(path = "/form3", method = RequestMethod.GET)
    public String form3(Model model) {
        User user = new User("Zbyszek",
                "Malinowski",
                "zbyszek123",
                "zibi123");
        model.addAttribute("userModel", user);
        return "form2";
    }

    @RequestMapping(path = "/form3", method = RequestMethod.POST)
    public String form3(@ModelAttribute User user) {
        System.out.println(user.getName());
        System.out.println(user.getSurname());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        return "main";
    }
}
