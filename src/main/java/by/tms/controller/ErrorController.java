package by.tms.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ErrorController {
    @ExceptionHandler(RuntimeException.class)
    public String error (RuntimeException e, Model model){
        model.addAttribute("message",e.getMessage());
        return "error";
    }
}
