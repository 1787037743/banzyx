package zyx.ban.xz.com.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zyx.ban.xz.com.file.pojo.FileRecord;
import zyx.ban.xz.com.file.service.FileService;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author ban_xz
 * @date 2020/08/02
 */

@RestController
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return fileService.save(
                file.getInputStream(),
                file.getOriginalFilename(),
                file.getContentType(),
                file.getSize()
        );
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> download(@PathVariable String fileId) throws UnsupportedEncodingException {
        FileRecord fileRecord = fileService.findFile(fileId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename="+ URLEncoder.encode(fileRecord.getFileName(), "UTF-8"))
                .header(HttpHeaders.CONTENT_TYPE,fileRecord.getContentType())
                .body(fileRecord.getResource());
    }

    @GetMapping("/{fileId}")
    public  ResponseEntity<Resource> show(@PathVariable String fileId) throws UnsupportedEncodingException {
        final FileRecord fileRecord = fileService.findFile(fileId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline;filename="+
                                URLEncoder.encode(fileRecord.getFileName(),"UTF-8"))
                .header(HttpHeaders.CONTENT_TYPE,fileRecord.getContentType())
                .body(fileRecord.getResource()) ;
    }


}
