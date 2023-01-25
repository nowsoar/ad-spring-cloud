package github.zkpgeeker.ad.service.impl;

import github.zkpgeeker.ad.constant.Constants;
import github.zkpgeeker.ad.dao.AdUserRepository;
import github.zkpgeeker.ad.entity.AdUser;
import github.zkpgeeker.ad.exception.AdException;
import github.zkpgeeker.ad.service.UserService;
import github.zkpgeeker.ad.utils.CommonUtils;
import github.zkpgeeker.ad.vo.CreateUserRequest;
import github.zkpgeeker.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/24
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {
        if (!request.isValid()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        AdUser oldUser = userRepository.findByUsername(request.getUsername());
        if (oldUser != null) {
            throw new AdException(Constants.ErrorMsg.SAME_USER_ERROR);
        }
        AdUser newUser = userRepository.save(new AdUser(
                request.getUsername(),
                CommonUtils.md5(request.getUsername())
        ));
        return new CreateUserResponse(newUser.getId(),
                newUser.getUsername(),
                newUser.getToken(),
                newUser.getCreateTime(),
                newUser.getUpdateTime()
        );
    }
}
