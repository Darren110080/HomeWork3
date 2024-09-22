package com.systex.controller;


import com.systex.model.LotteryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LotteryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LotteryService lotteryService = new LotteryService();  // 初始化 LotteryService

    public LotteryController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String group = request.getParameter("group");
        String exclude = request.getParameter("exclude");

        // 將 exclude 以逗號分隔
        String[] excludeArray = exclude.split("\\s+"); // 假設以空格分隔的輸入
        String excludeCommaSeparated = String.join(", ", excludeArray);
        // 使用 LotteryService 生成樂透結果
        String resultMessage = lotteryService.generateLotteryResults(group, exclude);
        
        
        request.setAttribute("group", group);
        request.setAttribute("exclude", excludeCommaSeparated);
        request.setAttribute("result", resultMessage);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}