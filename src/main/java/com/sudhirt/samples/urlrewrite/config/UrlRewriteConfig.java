package com.sudhirt.samples.urlrewrite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class UrlRewriteConfig implements WebMvcConfigurer {

    @Value("${application.api.supportedVersions:#{null}}")
    private List<String> supportedVersions;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        if(supportedVersions == null) {
            System.out.println("Application doesn't support multiple versions of APIs");
            return;
        }
        Set<String> existingEndpoints = getMvcEndpoints(applicationContext);
        Set<Entry> derivedEndpoints = deriveEndpoints(existingEndpoints);
        derivedEndpoints.forEach(entry -> {
            registry.addViewController(entry.target).setViewName(entry.source);
            System.out.println("Mapping derived endpoint " + entry.target + " to " + entry.source);
        });
    }

    public Set<String> getMvcEndpoints(ApplicationContext context) {
        Set<String> existingEndpoints = new HashSet<>();
        context.getBean(RequestMappingHandlerMapping.class).getHandlerMethods().forEach((requestMappingInfo, handlerMethod) -> {
            requestMappingInfo.getPatternsCondition().getPatterns().forEach(existingEndpoints::add);
        });
        System.out.println(existingEndpoints);
        return existingEndpoints;
    }

    private Set<Entry> deriveEndpoints(Set<String> existingEndpoints) {
        Set<Entry> derivedEndpoints = new HashSet<>();
        for (int index = 0; index < supportedVersions.size() - 1; index++) {
            for (String endpoint : existingEndpoints) {
                String newEndpoint = endpoint.replace(supportedVersions.get(index), supportedVersions.get(index+1));
                if (!existingEndpoints.contains(newEndpoint)) {
                    derivedEndpoints.add(new Entry(endpoint, newEndpoint));
                }
            }
        }
        return derivedEndpoints;
    }
}

class Entry {

    String source;
    String target;

    Entry(String source, String target) {
        this.source = source;
        this.target = target;
    }
}
