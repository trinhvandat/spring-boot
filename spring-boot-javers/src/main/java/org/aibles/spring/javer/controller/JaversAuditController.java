package org.aibles.spring.javer.controller;

import org.aibles.spring.javer.model.UserEntity;
import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/javers")
public class JaversAuditController {

    private final Javers javers;

    @Autowired
    public JaversAuditController(Javers javers) {
        this.javers = javers;
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public String getUserChanges() {
        QueryBuilder jplQuery = QueryBuilder.byClass(UserEntity.class);

        List<Change> changes = javers.findChanges(jplQuery.build());

        return javers.getJsonConverter().toJson(changes);
    }
}
