package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend;

import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.BackendManager;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringBackendManager implements BackendManager {
    private ConfigurableApplicationContext ctx;

    @Override
    public void start() {
        ctx = SpringApplication.run(MoziSzerverApplication.class);
    }

    @Override
    public void stop() {
        if (ctx != null) {
            ctx.close();
        }
    }

    public <T> T getBean(Class<T> beanClass) {
        return ctx.getBean(beanClass);
    }
}