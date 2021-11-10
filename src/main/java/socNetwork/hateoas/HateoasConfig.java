package socNetwork.hateoas;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@Configuration
@Profile("hateoas")
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class HateoasConfig {




}
