package com.example.quizwebsite.controller;

import com.example.quizwebsite.domain.*;
import com.example.quizwebsite.domain.Choice;
import com.example.quizwebsite.service.QuestionService;
import com.example.quizwebsite.service.QuizService;
import com.example.quizwebsite.util.TempAnswerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes({"reports", "submission", "quizType"})
public class QuizController {
    private QuizService quizService;
    private QuestionService questionService;

    @Autowired
    public void setQuizService(QuizService quizService, QuestionService questionService) {
        this.quizService = quizService;
        this.questionService = questionService;
    }

    @GetMapping
    public String getAllQuizTypes(Model model) {
        List<QuizType> quizTypes = quizService.getAllQuizTypes();
        model.addAttribute("quizTypes", quizTypes);
        return "index";
    }

    @GetMapping("quiz/{quizTypeId}")
    public String getQuiz(@PathVariable int quizTypeId, Model model) {
        QuizType quizType = quizService.getQuizTypeById(quizTypeId);
        model.addAttribute("quizType", quizType);
        return "quizstart";
    }

    @GetMapping("quiz/{quizTypeId}/started")
    public String startQuiz(
            @PathVariable Integer quizTypeId,
            Model model) {
        List<Question> questions = questionService.getAllQuestionsByQuizType(quizTypeId);
        List<Report> reports = new ArrayList<>();
        for (Question question : questions) {
            Report report = new Report();
            report.setQuestion(question);
            reports.add(report);

            List<Choice> choices = question.getChoice();
            for(Choice choice : choices) {
                if(choice.getIsCorrect()) {
                    report.setAnswer(choice.getDescription());
                }
            }
        }

        TempAnswerContainer tempAnswerContainer = new TempAnswerContainer();
        QuizType quizType = quizService.getQuizTypeById(quizTypeId);
        Submission submission = new Submission();

        submission.setStartTime(DateFormat.getInstance().format(System.currentTimeMillis()));

        model.addAttribute("reports", reports);
        model.addAttribute("quizType", quizType);
        model.addAttribute("submission", submission);
        model.addAttribute("tempAnswer", tempAnswerContainer);
        return "quiz";
    }
}
