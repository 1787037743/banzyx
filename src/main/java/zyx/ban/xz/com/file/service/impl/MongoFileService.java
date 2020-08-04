package zyx.ban.xz.com.file.service.impl;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;
import zyx.ban.xz.com.file.pojo.FileRecord;
import zyx.ban.xz.com.file.repo.FileRecordRepository;
import zyx.ban.xz.com.file.service.FileService;

import javax.annotation.Resource;
import java.io.InputStream;
import java.time.LocalDateTime;

/**
 * @author ban_xz
 * @date 2020/08/02
 */

@Service
public class MongoFileService implements FileService {

    @Resource
    private GridFsOperations gridFsOperations;

    @Resource
    private FileRecordRepository fileRecordRepository;

    @Override
    public String save(InputStream file, String fileName, String contentType,Long size) {
        String fileId = gridFsOperations
                .store(file, fileName, contentType)
                .toString();
        String url ="http://127.0.0.1/"+fileId;
        fileRecordRepository.save(new FileRecord
                (fileName,
                url,
                size,
                LocalDateTime.now(),
                contentType)
        );
        return fileId;
    }

    @Override
    public FileRecord findFile(String fileId) {
        GridFSFile gridFSFile = gridFsOperations.findOne(Query.query(Criteria.where("_id").is(fileId)));
        GridFsResource gridFsResource = gridFsOperations.getResource(gridFSFile);
        return new FileRecord(
                fileId,
                gridFsResource.getFilename(),
                gridFsResource.getContentType(),
                gridFsResource);
    }



}
