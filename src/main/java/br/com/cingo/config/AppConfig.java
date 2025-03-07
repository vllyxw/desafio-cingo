package cingo.config;

import cingo.rest.CORSFilter;
import cingo.rest.LogResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class AppConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(CORSFilter.class);
        resources.add(LogResource.class);
        return resources;
    }
}
