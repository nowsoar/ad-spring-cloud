package github.zkpgeeker.ad.service;

import github.zkpgeeker.ad.exception.AdException;
import github.zkpgeeker.ad.vo.CreateUserRequest;
import github.zkpgeeker.ad.vo.CreateUserResponse;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/24
 */
public interface UserService {

    /**
     * 创建用户
     * @param request
     * @return
     * @throws AdException
     */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
