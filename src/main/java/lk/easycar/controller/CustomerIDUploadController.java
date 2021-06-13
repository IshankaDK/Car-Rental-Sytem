package lk.easycar.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author ishanka on 6/14/21 at 1:19 AM
 * @since 0.0.1
 */
//@RestController
//@RequestMapping("/api/customer")
public class CustomerIDUploadController {

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public boolean saveFile(@RequestPart("myFile") MultipartFile myFile) {
//
//        System.out.println(myFile.getOriginalFilename());;
//
//        try {
//            // Let's get the project location
//            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//            // Let's create a folder there for uploading purposes, if not exists
//            File uploadsDir = new File(projectPath + "/customer");
//            uploadsDir.mkdir();
//            // It is time to transfer the file into the newly created dir
//            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
//            System.out.println(projectPath);
//            System.out.println(uploadsDir.getAbsolutePath());
//            System.out.println(myFile.getOriginalFilename());
//            return true;
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//            return false;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
