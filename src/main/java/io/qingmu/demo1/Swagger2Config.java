package io.qingmu.demo1;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import io.gd.generator.annotation.Field;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.AnnotatedElement;

import static springfox.documentation.schema.Annotations.findPropertyAnnotation;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Component
    @Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
    public static class FieldPropertyBuilder implements ModelPropertyBuilderPlugin {
        @Override
        public void apply(ModelPropertyContext context) {
            Optional<Field> annotation = Optional.absent();

            if (context.getAnnotatedElement().isPresent()) {
                annotation = annotation.or(findApiModePropertyAnnotation(context.getAnnotatedElement().get()));
            }
            if (context.getBeanPropertyDefinition().isPresent()) {
                annotation = annotation.or(findPropertyAnnotation(context.getBeanPropertyDefinition().get(), Field.class));
            }
            if (annotation.isPresent()) {
                context.getBuilder()
                        .description(annotation.transform(a -> {
                            String description = "";
                            if (!Strings.isNullOrEmpty(a.description())) {
                                description = a.description();
                            } else if (!Strings.isNullOrEmpty(a.label())) {
                                description = a.label();
                            }
                            return description;
                        }).orNull())
                        .type(annotation.transform(a -> context.getResolver().resolve(Object.class)).orNull());
            }
        }

        @Override
        public boolean supports(DocumentationType delimiter) {
            return true;
        }


        public Optional<Field> findApiModePropertyAnnotation(AnnotatedElement annotated) {
            return Optional.fromNullable(AnnotationUtils.getAnnotation(annotated, Field.class));
        }
    }
}
