package ysu.edu.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import ysu.edu.service.ICompetitionService;
import ysu.edu.util.ServerResponse;

import javax.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;
import ysu.edu.pojo.Competition;
import ysu.edu.service.ICompetitionService;
import ysu.edu.util.ServerResponse;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zh
 * @since 2020-09-20
 */
@RestController
@RequestMapping("/competition")
public class CompetitionController {
    @Resource
    ICompetitionService competitionService;

    @PostMapping("/save-competition")
    ServerResponse SaveCompetition(Competition competition) throws IOException {
        boolean result = competitionService.add(competition);
        if(result)
            return ServerResponse.success(null, "保存成功");
        else
            return ServerResponse.failed("保存失败");
    }

    @PostMapping("/save-sign")
    ServerResponse SaveSign(String parts, Integer id, String[] activeParams) throws JsonProcessingException {
        List<String> params = new ArrayList<>(activeParams.length);
        Collections.addAll(params, activeParams);
        boolean result = competitionService.SaveSign(parts, id, params);
        if(result)
            return ServerResponse.success(null, "报名表保存成功");
        else
            return ServerResponse.failed("报名表保存失败");
    }

    @GetMapping("/getByName")
    ServerResponse GetCompetition(String name) {
        Competition competition = competitionService.getByName(name);
        if(ObjectUtils.isEmpty(competition))
            return ServerResponse.failed("未找到该竞赛相关信息");
        else
            return ServerResponse.success(competition);
    }

    @PostMapping("/list")
    ServerResponse list( Competition competition) {
        return ServerResponse.success(competitionService.list(competition));
    }
    @GetMapping("/getById")
    ServerResponse getById(Integer id){
        return ServerResponse.success(competitionService.getById(id));
    }
    @PostMapping("/del")
    ServerResponse del(Competition competition) {
        competition.setActive(0);
        return ServerResponse.success(competitionService.updateById(competition));
    }
    @PostMapping("/batchdel")
    ServerResponse batchdel(Integer[] ids) {
        return ServerResponse.success(competitionService.batchdel(ids));
    }
    @PostMapping("/back")
    ServerResponse back(Competition competition) {
        competition.setActive(1);
        return ServerResponse.success(competitionService.updateById(competition));
    }
    @PostMapping("/getOptionList")
    ServerResponse getOptionList(Integer id){
        return ServerResponse.success(competitionService.getOptionList(id));
    }
}
