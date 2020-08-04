package zyx.ban.xz.com.file.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ban_xz
 * @date 2020/08/02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileRecord {

    public FileRecord( String fileName, String url, Long size, LocalDateTime uploadTime,String contentType) {
        this.url = url;
        this.size = size;
        this.fileName = fileName;
        this.contentType = contentType;
        this.uploadTime = uploadTime;
    }

    public FileRecord(String fileName, String id, String contentType, Resource resource) {
        this.fileName = fileName;
        this.id = id;
        this.contentType = contentType;
        this.resource = resource;
    }

    private String fileName;

    private String url;

    private String type ;

    private Long size;

    private LocalDateTime uploadTime;

    private String id;

    private String contentType;

    private Resource resource;

}
