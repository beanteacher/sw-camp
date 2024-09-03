package com.ohgiraffers.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @Value("${file.path}")
    String root;

    @RequestMapping("/single-file")
    public String singleFileUpload(String singleFileDescription, MultipartFile singleFile, Model model) throws Exception {
        System.out.println("singleFileDescription : " + singleFileDescription);
        System.out.println("singleFile : " + singleFile);

        /* 서버로 전송 된 MultipartFile 객체를 서버에서 지정하는 경로에 저장한다. */
        String filePath = root + "/uploadFiles";

        File file = new File(filePath);
        if(!file.exists()) { file.mkdir(); }

        String originFileName = singleFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        
        String serverFileName = UUID.randomUUID() + ext;
        singleFile.transferTo(new File(filePath + "/" + serverFileName));

        List<FileDTO> files = new ArrayList<>();

        files.add(new FileDTO(originFileName, serverFileName, filePath, singleFileDescription));

        model.addAttribute("files", files);
        return "result";
    }

    @RequestMapping("/multi-file")
    public String multiFileUpload(String multiFileDescription, List<MultipartFile> multiFiles, Model model) throws Exception {
        System.out.println("multiFileDescription : " + multiFileDescription);
        System.out.println("multiFile : " + multiFiles);

        /* 서버로 전송 된 MultipartFile 객체를 서버에서 지정하는 경로에 저장한다. */
        String filePath = root + "/uploadFiles";

        File file = new File(filePath);
        if(!file.exists()) { file.mkdir(); }

        List<FileDTO> files = new ArrayList<>();

        try {
            for(MultipartFile multiFile : multiFiles) {
                String originFileName = multiFile.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String serverFileName = UUID.randomUUID() + ext;

                multiFile.transferTo(new File(filePath + "/" + serverFileName));

                files.add(new FileDTO(originFileName, serverFileName, filePath, multiFileDescription));
                // throw new Exception();
            }

            // files 정보는 DB에 insert 한다.
        } catch (Exception e) {

            for(FileDTO fileDTO : files) {
                new File(filePath + "/" + fileDTO.getSavedFileName()).delete();
            }
            files.clear();
        }

        model.addAttribute("files", files);

        return "result";
    }
}
