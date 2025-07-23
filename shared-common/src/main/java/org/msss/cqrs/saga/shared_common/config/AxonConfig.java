package org.msss.cqrs.saga.shared_common.config;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.*;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.xml.XStreamSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AxonConfig {

    @Bean
    @Primary
    public Serializer serializer() {
        XStream xstream = new XStream();
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypesByWildcard(new String[] {
                "org.msss.cqrs.saga.**"
        });

        return XStreamSerializer.builder()
                .xStream(xstream)
                .build();
    }
}
