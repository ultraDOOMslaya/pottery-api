package com.maakesbe.authentication.security.auth.jwt;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.maakesbe.query.controllers.EventsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

/**
 * SkipPathRequestMatcher
 * 
 * @author vladimir.stankovic
 *
 * Aug 19, 2016
 */
public class SkipPathRequestMatcher implements RequestMatcher {
    private OrRequestMatcher matchers;
    private RequestMatcher processingMatcher;

    private OrRequestMatcher processingMatchers;

    private static final Logger log = LoggerFactory.getLogger(SkipPathRequestMatcher.class);


    public SkipPathRequestMatcher(List<String> pathsToSkip, List<String> processingPaths) {
        Assert.notNull(pathsToSkip);
        List<RequestMatcher> m = pathsToSkip.stream().map(path -> new AntPathRequestMatcher(path)).collect(Collectors.toList());
        matchers = new OrRequestMatcher(m);

        List<RequestMatcher> r = processingPaths.stream().map(path -> new AntPathRequestMatcher(path)).collect(Collectors.toList());
        processingMatchers = new OrRequestMatcher(r);
//        processingMatcher = new AntPathRequestMatcher(processingPath);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        if (matchers.matches(request)) {
            return false;
        }
        log.info("Does the processing matcher return true or false for the request? {}", processingMatchers.matches(request) ? true : false);
        return processingMatchers.matches(request) ? true : false;
    }
}
