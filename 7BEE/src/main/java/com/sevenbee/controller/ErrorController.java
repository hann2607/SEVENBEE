package com.sevenbee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Lấy mã trạng thái lỗi từ yêu cầu
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        // Nếu mã trạng thái là 404, chuyển hướng đến trang lỗi 404
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
        }
        
        // Nếu không phải lỗi 404, chuyển hướng đến trang lỗi chung
        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
}
