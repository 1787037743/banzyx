package zyx.ban.xz.com.file.service;

import zyx.ban.xz.com.file.pojo.FileRecord;

import java.io.InputStream;

/**
 * @author ban_xz
 * @date 2020/08/02
 */

public interface FileService {

    String save(InputStream file,String fileName,String contentType,Long size);

    FileRecord findFile(String fileId);

}
