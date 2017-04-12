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
import java.io.*;
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
}
