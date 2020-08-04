package zyx.ban.xz.com.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import zyx.ban.xz.com.file.pojo.FileRecord;
import zyx.ban.xz.com.file.repo.FileRecordRepository;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author ban_xz
 * @date 2020/08/03
 */
@Controller
public class FileListController {


    @Autowired
    FileRecordRepository fileRecordRepository;



    @GetMapping("/image")
    public String router(Model model){
        List<FileRecord> list = fileRecordRepository.findAll();
        System.out.println(list);
        model.addAttribute("item",list);
        return "image";
    }

}
