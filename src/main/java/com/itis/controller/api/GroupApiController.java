package com.itis.controller.api;

import com.itis.model.UserGroup;
import com.itis.service.UserGroupService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author r.khakov
 */
@RestController
public class GroupApiController {

    private final UserGroupService userGroupService;

    @Autowired
    public GroupApiController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @ApiOperation("Get map of course number and list of user group")
    @GetMapping(ApplicationUrls.ApiUrls.BASE_GROUPS_URL)
    public Map<String, List<UserGroup>> getUserGroupApi() {
        Map<String, List<UserGroup>> groups = new HashMap<>();
        groups.put("1", userGroupService.getUserGroupsByCourse(1));
        groups.put("2", userGroupService.getUserGroupsByCourse(2));
        groups.put("3", userGroupService.getUserGroupsByCourse(3));
        groups.put("4", userGroupService.getUserGroupsByCourse(4));
        return groups;
    }

    @ApiOperation("Get list of user group by course number")
    @GetMapping(ApplicationUrls.ApiUrls.GROUPS_BY_COURSE)
    public List<UserGroup> getUserGroupApiByCourse(@PathVariable Integer courseNumber) {
        return userGroupService.getUserGroupsByCourse(courseNumber);
    }
}