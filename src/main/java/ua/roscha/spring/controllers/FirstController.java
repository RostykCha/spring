package ua.roscha.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping()
    public String mainPage(){
        return "/general/home";
    }

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request,
                            Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Bye " + name + " " + surname);

        model.addAttribute("message", String.format("Bye %s %s", name, surname));

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model) {

        System.out.println("Bye " + name + " " + surname);
        model.addAttribute("message", String.format("Bye %s %s", name, surname));

        return "first/goodbye";
    }


    @GetMapping("/first/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Integer a,
                             @RequestParam(value = "b", required = false) Integer b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {

        String message = String.format("Apply %s for %d and %d", action, a, b);

        model.addAttribute("message", message);

        Double result = 0.0;

        if (action!=null){
            switch (action) {
                case "multiplication":
                    result = (double) (a * b);
                    break;

                case "addiction":
                    result = (double) (a + b);
                    break;

                case "subtraction":
                    result = (double) (a - b);
                    break;

                case "division":
                    result = (double) (a / b);
                    break;
            }
        }

        model.addAttribute("calculationResult", result);

        return "first/calculator";
    }
}
