package guilherme.escarduca.MovieApi.Configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("guilherme.escarduca.MovieApi.Aspects")
public class AspectConfig {

}
