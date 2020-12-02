package com.xxx.service;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.*;

public class PdfboxUtil {

    public static void main(String[] args) throws Exception {
        String pdfPath = "D:/README.pdf";
        InputStream inputStream = new FileInputStream(new File("D:/README.pdf"));
        PdfboxUtil pdfutil = new PdfboxUtil();
        pdfutil.getTextFromPdf(inputStream);
    }

    /**
     * @param args
     */
    public static void main1(String[] args) {
        String pdfPath = "D:/README.pdf";
        String txtfilePath = "D:/README.txt";
        PdfboxUtil pdfutil = new PdfboxUtil();
        try {
            String content = pdfutil.getTextFromPdf(pdfPath);
            pdfutil.toTextFile(content, txtfilePath);
            System.out.println("Finished !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param input
     * @return
     * @throws Exception
     */
    public String getTextFromPdf(InputStream input) throws Exception {
        // 是否排序
        boolean sort = false;
        // 开始提取页数
        int startPage = 1;
        // 结束提取页数
        int endPage = Integer.MAX_VALUE;
        String content = null;
        PDDocument document = null;
        try {
            // 加载 pdf 文档
            PDFParser parser = new PDFParser(input);
            parser.parse();
            document = parser.getPDDocument();
            // 获取内容信息
            PDFTextStripper pts = new PDFTextStripper();
            pts.setSortByPosition(sort);
            endPage = document.getNumberOfPages();
            System.out.println("Total Page: " + endPage);
            pts.setStartPage(startPage);
            pts.setEndPage(endPage);
            try {
                content = pts.getText(document);
                System.out.println(content);
            } catch (Exception e) {
                throw e;
            }
            System.out.println("Get PDF Content ...");
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != input)
                input.close();
            if (null != document)
                document.close();
        }
        return content;
    }

    /**
     * 读取PDF文件的文字内容
     *
     * @param pdfPath
     * @throws Exception
     */

    public String getTextFromPdf(String pdfPath) throws Exception {
        // 是否排序
        boolean sort = false;
        // 开始提取页数
        int startPage = 1;
        // 结束提取页数
        int endPage = Integer.MAX_VALUE;
        String content = null;
        InputStream input = null;
        File pdfFile = new File(pdfPath);
        PDDocument document = null;
        try {
            input = new FileInputStream(pdfFile);
            // 加载 pdf 文档
            PDFParser parser = new PDFParser(input);
            parser.parse();
            document = parser.getPDDocument();
            // 获取内容信息
            PDFTextStripper pts = new PDFTextStripper();
            pts.setSortByPosition(sort);
            endPage = document.getNumberOfPages();
            System.out.println("Total Page: " + endPage);
            pts.setStartPage(startPage);
            pts.setEndPage(endPage);
            try {
                content = pts.getText(document);
                //System.out.println(content);
            } catch (Exception e) {
                throw e;
            }
            System.out.println("Get PDF Content ...");
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != input)
                input.close();
            if (null != document)
                document.close();
        }
        return content;
    }


    /**
     * 把PDF文件内容写入到txt文件中
     *
     * @param pdfContent
     * @param filePath
     */

    public void toTextFile(String pdfContent, String filePath) {
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            System.out.println("Write PDF Content to txt file ...");
            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write(pdfContent);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
