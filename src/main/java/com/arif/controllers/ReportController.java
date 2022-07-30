package com.arif.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arif.service.ReportService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("/reports")
public class ReportController {
    
    @Autowired
    private ReportService reportService;

    @Autowired
    private HttpServletResponse response;

    @GetMapping("/products")
    public void getProductReport() throws Exception{
        response.setContentType("application/download");
        response.setHeader("Content-Disposition", "attachment; filename=\"product_list.pdf\"");
        JasperPrint jasperPrint = reportService.generateJasperPrint();
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}
