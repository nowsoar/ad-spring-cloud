package github.zkpgeeker.ad.dao;

import github.zkpgeeker.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/24
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long> {

    /**
     * 根据用户名查找用户记录
     * @param username
     * @return
     */
    AdUser findByUsername(String username);
}
