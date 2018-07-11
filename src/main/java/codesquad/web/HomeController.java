package codesquad.web;

import codesquad.domain.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("questions", questionRepository.findAllByDeletedFalse());
        return "index";
    }

    @GetMapping("/error")
    public String showError() {
        return "error";
    }
}
