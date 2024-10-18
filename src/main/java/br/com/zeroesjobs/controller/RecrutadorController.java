package br.com.zeroesjobs.controller;

import br.com.zeroesjobs.entity.Recrutador;
import br.com.zeroesjobs.entity.Usuario;
import br.com.zeroesjobs.repository.RecrutadorRepository;
import br.com.zeroesjobs.repository.UsuarioRepository;
import br.com.zeroesjobs.services.RecrutadorService;
import br.com.zeroesjobs.util.UploadArquivo;
import ch.qos.logback.core.util.StringUtil;
import org.apache.tomcat.util.http.fileupload.impl.FileUploadIOException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/recrutador")
public class RecrutadorController {

    private final UsuarioRepository usuarioRepository;
    private final RecrutadorService recrutadorService;

    public RecrutadorController(UsuarioRepository usuarioRepository, RecrutadorService recrutadorService) {
        this.usuarioRepository = usuarioRepository;
        this.recrutadorService = recrutadorService;
    }

    @GetMapping("/")
    public String Recrutador(Model model) {

        Authentication autenticacao = SecurityContextHolder.getContext().getAuthentication();

        if (!(autenticacao instanceof AnonymousAuthenticationToken)) {
            String nome = autenticacao.getName();
            Usuario usuario = usuarioRepository.findByEmail(nome).orElseThrow(
                    () -> new UsernameNotFoundException("Não foi possível encontrar o usuário")
            );
            Optional<Recrutador> recrutador = recrutadorService.obter(usuario.getUsuarioId());

            if (!recrutador.isEmpty()) {
                model.addAttribute("recrutador", recrutador.get());
            }
        }

        return "recrutador";
    }

    @PostMapping("/adicionar")
    public String adicionar(Recrutador recrutador, @RequestParam("image") MultipartFile multipartFile, Model model) {

        Authentication autenticacao = SecurityContextHolder.getContext().getAuthentication();

        if (!(autenticacao instanceof AnonymousAuthenticationToken)) {
            String nome = autenticacao.getName();
            Usuario usuario = usuarioRepository.findByEmail(nome).orElseThrow(
                () -> new UsernameNotFoundException("Não foi possível " + "encontrar usuário")
            );
            recrutador.setUsuarioId(usuario);
            recrutador.setContaUsuarioId(usuario.getUsuarioId());
        }

        model.addAttribute("recrutador", recrutador);
        String nomeArquivo = "";

        if(!multipartFile.getOriginalFilename().equals("")) {
            nomeArquivo = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            recrutador.setFotoPerfil(nomeArquivo);
        }

        Recrutador usuarioSalvo = recrutadorService.adicionar(recrutador);

        String diretorioUpload = "imagens/recrutador" + usuarioSalvo.getContaUsuarioId();

        try {
            UploadArquivo.salvar(diretorioUpload, nomeArquivo, multipartFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "redirect:/dashboard/";
    }
}
