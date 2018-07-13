package codesquad.web;

import codesquad.domain.*;
import codesquad.domain.result.Result;
import codesquad.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class ApiAnswerController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping("/questions/{questionId}/answers")
    public Result create(@PathVariable Long questionId, @RequestBody Answer target, HttpSession session) {
        SessionUtils.getInstance().checkLogin2(session);
        User user = SessionUtils.getInstance().getUserFromSession(session);
        Question question = questionRepository.findById(questionId).orElseThrow(NullPointerException::new);
        Answer answer = new Answer(user, target.getContents());
        System.out.println("\n\n\n\n\n\n\n" + target.toString());
        answer.update(user, question);
        question.addAnswers(answer);
        answerRepository.save(answer);
        return (new Result()).ok(answer);
    }

}
