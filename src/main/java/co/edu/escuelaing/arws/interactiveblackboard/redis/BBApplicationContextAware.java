package co.edu.escuelaing.arws.interactiveblackboard.redis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import co.edu.escuelaing.arws.interactiveblackboard.annotations.GeneratedExcludeFromCodeCoverage;

@GeneratedExcludeFromCodeCoverage
@Component
@Lazy(false)
public class BBApplicationContextAware implements ApplicationContextAware {
    
    private  ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public  ApplicationContext getApplicationContext() {
        return context;
    }

    public <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}