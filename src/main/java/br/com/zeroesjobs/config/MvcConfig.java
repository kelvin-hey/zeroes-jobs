package br.com.zeroesjobs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private static final String DIR_IMAGENS = "imagens";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registro) {
        exporDiretorio(DIR_IMAGENS, registro);
    }

    public void exporDiretorio(String diretorioUpload, ResourceHandlerRegistry registro) {
        Path caminho = Paths.get(diretorioUpload);
        registro.addResourceHandler("/" + diretorioUpload + "/**").addResourceLocations(
                "Arquivo:" + caminho.toAbsolutePath() + "/"
        );
    }
}
