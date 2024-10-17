package br.com.zeroesjobs.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UploadArquivo {

    public static void salvar(String diretorio, String nome, MultipartFile multipartFile) throws IOException {

        Path caminhoUpload = Paths.get(diretorio);
        if (!Files.exists(caminhoUpload)) {
            Files.createDirectories(caminhoUpload);
        }

        try (InputStream inputStream = multipartFile.getInputStream();) {
            Path caminho = caminhoUpload.resolve(nome);
            System.out.println("Caminho do arquivo: " + caminho);
            System.out.println("Nome do arquivo: " + nome);
            Files.copy(inputStream, caminho, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException ioe) {
            throw new IOException("Não foi possível salvar o arquivo: " + nome, ioe);
        }
    }
}
