package com.book.web.controller;

import com.book.web.common.JsonResponseEntity;
import com.book.web.helper.ConfigUtil;
import com.book.web.pojo.file.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by majunsheng on 2017/4/10.
 *
 */
@Controller
@RequestMapping(value = "/downLoad")
public class DownLoadController {

    @Autowired
    private HttpServletRequest request;

    /**
     * 上传文件一览
     * @param model
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "list")
    public String loadList(Model model){
        List<FileVo> fileList = new ArrayList<FileVo>();
        String path = ConfigUtil.getConfig("uploadFileDir");
        File f = new File(path);
        if (!f.exists()){
            System.out.println(path + " not exists");
        }
        File[] files = f.listFiles();
        FileVo fileVo =new FileVo();
        for (int i = 0; i < files.length; i++) {
           String fileName = files[i].getName();
            String[] ss = fileName.split("'");
            fileVo.setId(ss[0]);
            fileVo.setName(ss[1]);
            fileList.add(fileVo);
        }
        model.addAttribute("file",fileList);
        return "download/list";
    }

    /**
     * 上传文件
     * @param name
     * @param files
     * @return
     */
    @RequestMapping(value = "upLoad")
    public String upLoad(@RequestParam("name")String name, @RequestParam("files")MultipartFile[] files){
        for(MultipartFile file:files) {
            if (!file.isEmpty()) {
                try {
                    // 文件保存路径
                  /*  String filePath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/downFile/"
                            + file.getOriginalFilename();*/
                    UUID uuid = UUID.randomUUID();
                    String filePath = ConfigUtil.getConfig("uploadFileDir")+"/"+uuid+"'"+file.getOriginalFilename();
                    // 转存文件
                    file.transferTo(new File(filePath));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/downLoad/list";
    }

    /**
     * 检查文件是否存在
     * @param id
     * @return
     */
    @RequestMapping("/checkFile")
    @ResponseBody
    public JsonResponseEntity checkFile(@RequestParam(required = true) String id){
        JsonResponseEntity<Object> result = new JsonResponseEntity<Object>();

        List<String> strList = new ArrayList<String>();
        String path = ConfigUtil.getConfig("uploadFileDir");
        File f = new File(path);
        if (!f.exists()){
            System.out.println(path + " not exists");
        }
        File[] files = f.listFiles();
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getName();
            String[] ss = fileName.split("'");
            strList.add(ss[0]);
        }
        if(strList.contains(id)){
            result.setCode(0);
        }else {
            result.setCode(1);
            result.setMsg("文件不存在!");
        }
        return result;
    }

    /**
     * 文件下载
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam(required = true) String id) throws IOException {

        String path = ConfigUtil.getConfig("uploadFileDir");
        File f = new File(path);
        if (!f.exists()){
            System.out.println(path + " not exists");
        }
        File[] files = f.listFiles();
        File[] fileStr = null;
        String fileName = null;
        String str=null;
        for (int i = 0; i < files.length; i++) {
             str = files[i].getName();
           if(str.indexOf(id) !=-1){
               fileStr = files;
               fileName = str.split("'")[1];
           }
        }
        String filePath = path+ "/"+ str;
        File file = new File(filePath);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("utf-8"), "iso8859-1"));
        return new ResponseEntity(readAsByteArray(file),headers, HttpStatus.CREATED);
    }

    public  byte[] readAsByteArray(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        byte[] ret = readAsByteArray((InputStream)in);
        in.close();
        return ret;
    }

    public  byte[] readAsByteArray(InputStream inStream) throws IOException {
        int size = 1024;
        byte[] ba = new byte[size];
        int readSoFar = 0;

        while(true) {
            int newBa = inStream.read(ba, readSoFar, size - readSoFar);
            if(newBa == -1) {
                byte[] newBa2 = new byte[readSoFar];
                System.arraycopy(ba, 0, newBa2, 0, readSoFar);
                return newBa2;
            }

            readSoFar += newBa;
            if(readSoFar == size) {
                int newSize = size * 2;
                byte[] newBa1 = new byte[newSize];
                System.arraycopy(ba, 0, newBa1, 0, size);
                ba = newBa1;
                size = newSize;
            }
        }
    }


    /**
     * download01
     * @param path
     * @param response
     * @return
     */
    @RequestMapping("/download01")
    public HttpServletResponse download(String path, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            String p = "D:/usr/local/Upload/a9452ae6-be80-4c41-abbb-04ea39a29279'find.txt";
            File file = new File(p);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(p));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @RequestMapping("/download02")
    public void downLoad(String filePath, HttpServletResponse response, boolean isOnLine) throws Exception {
        filePath = "D:/usr/local/Upload/a9452ae6-be80-4c41-abbb-04ea39a29279'find.txt";
        File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;

        response.reset(); // 非常重要
        if (isOnLine) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            // 文件名应该编码成UTF-8
        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }
}
