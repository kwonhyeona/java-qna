package codesquad.domain.result;

import codesquad.domain.Answer;

public class Result {
    private String message;
    private Answer answer;

    public Result ok(Answer answer) {
        this.message = "ok";
        this.answer = answer;
        return this;
}

    public Result fail(String message) {
        this.message = message;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
