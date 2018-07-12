package codesquad.web;

import codesquad.domain.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("questionList", StreamSupport.stream(questionRepository.findAll().spliterator(), false)
                .filter(question -> !question.isDeleted())
                .collect(Collectors.toList()));
        return "index";
    }
}
