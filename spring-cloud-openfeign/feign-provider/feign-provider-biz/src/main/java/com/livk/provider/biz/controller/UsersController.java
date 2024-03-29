package com.livk.provider.biz.controller;

import com.livk.provider.api.domain.Users;
import com.livk.provider.biz.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * UsersController
 * </p>
 *
 * @author livk
 * @date 2021/12/6
 */
@Slf4j
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UsersController {

    private final UserMapper userMapper;

    @Cacheable(value = "users", key = "'user:all'")
    @GetMapping
    public List<Users> users() {
        log.info("provider");
        return userMapper.selectList();
    }

    @PostMapping
    public Boolean save(@RequestBody Users users) {
        return userMapper.insert(users) != 0;
    }

    @CacheEvict(value = "users", key = "'user:all'")
    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return userMapper.deleteById(id) != 0;
    }

}
