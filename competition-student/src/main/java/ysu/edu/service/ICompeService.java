package ysu.edu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ysu.edu.pojo.Competition;
import ysu.edu.pojo.Sign;
import ysu.edu.util.ServerResponse;

@FeignClient("teacher")
public interface ICompeService {
    @RequestMapping(value = "/competition/list")
    ServerResponse list(@RequestBody Competition competition);
    @RequestMapping("sign/self-list")
    ServerResponse list(@RequestBody Sign sign);
}
