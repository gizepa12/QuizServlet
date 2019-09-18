package com.wap.lab12;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class QuizServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String question = "";
        String answer = req.getParameter("result");
        HttpSession httpSession = req.getSession();
        Quiz quiz = (Quiz) httpSession.getAttribute("quiz");

        if (quiz == null) {
            quiz = new Quiz();
            httpSession.setAttribute("quiz", quiz);
            question = quiz.getNextQuestion().toString();
        } else {
            question = quiz.getNextQuestion().toString();
            quiz.answerCorrectAddScore(answer); //adding score
            System.out.println(answer + " -> " + question);
        }

        if (!quiz.isNextQuestion()) {
            out.print("" +
                    "<h1> The Number Quiz </h1>" +
                    "<p> Your Score is " + quiz.getScore() + "</p>" +
                    "<p> You have completed the Number Quiz, with a score of " +
                    quiz.getScore() + " out of " + quiz.getQuestions().size() + ".");
            httpSession.setAttribute("quiz",null);
            out.close();

        } else
            out.print("" +
                    "<html>\n" +
                    "<body>\n" +
                    "<div style=\"width: 50%\">\n" +
                    "    <fieldset>\n" +
                    "        <legend>Number Quiz!</legend>\n" +
                    "        <form action=\"\" method=\"post\">\n" +
                    "            <p>Your current score is " +
                    "               <input name=\"score\" type=\"text\" readonly style=\"border: none\" value = \"" + quiz.getScore() + "\"/></p>\n" +
                    "            <p>Guess next number in the sequence:</p>\n" +
                    "            <p><input name=\"sequences\" type=\"text\" readonly style=\"border: none; width: 50%\" value = \"" + question + "\"/><br/>\n" +
                    "                Your answer is:\n" +
                    "                <input name=\"result\" type=\"text\" pattern=\"[\\d]+\" style=\"width: 30px\"/><br/>\n" +
                    "                <input type=\"submit\"/>\n" +
                    "            </p>\n" +
                    "        </form>\n" +
                    "    </fieldset>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>" +
                    "");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
