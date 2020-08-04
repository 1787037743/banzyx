package zyx.ban.xz.com.file.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import zyx.ban.xz.com.file.pojo.FileRecord;

/**
 * @author ban_xz
 * @date 2020/08/03
 */
@Repository
public interface FileRecordRepository extends MongoRepository<FileRecord,String> {

}
