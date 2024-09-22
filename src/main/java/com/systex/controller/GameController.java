package com.systex.controller;

import com.systex.model.GuessGame;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class GameController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GuessGame game = (GuessGame) session.getAttribute("game");

        //初始化遊戲
        if (game == null) {
            game = new GuessGame();
            session.setAttribute("game", game);
        }

        //拿輸入的數字
        String guessStr = request.getParameter("group");
        int guess;
        try {
            guess = Integer.parseInt(guessStr);
        } catch (NumberFormatException e) {
            //error環節
            request.setAttribute("message", "請輸入有效的數字！");
            request.getRequestDispatcher("guess.jsp").forward(request, response);
            return;
        }

        // 猜測結果處理
        String result = game.guess(guess);
        request.setAttribute("luckNumber", game.getLuckNumber());
        switch (result) {
            case "win":
            	
                session.invalidate(); // 清空session
             // 把luckNumber傳遞到youWin.jsp
                request.getRequestDispatcher("youWin.jsp").forward(request, response);
                break;
            case "lose":
           
                session.invalidate();
             // 把luckNumber傳遞到youLose.jsp
                request.getRequestDispatcher("youLose.jsp").forward(request, response);
                break;
            case "incorrect":
                request.setAttribute("message", "猜錯了！還剩 " + game.getRemains() + " 次機會。");
                request.getRequestDispatcher("guess.jsp").forward(request, response);
                break;
        }
    }
}