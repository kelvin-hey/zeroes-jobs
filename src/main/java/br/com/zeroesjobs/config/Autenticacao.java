package br.com.zeroesjobs.config;

import br.com.zeroesjobs.util.DadosUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Autenticacao implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        DadosUsuario dadosUsuario = (DadosUsuario) authentication.getPrincipal();
        String nomeUsuario = dadosUsuario.getUsername();
        System.out.println("O nome de usuário " + nomeUsuario + " está logado");

        boolean temPapelCandidato = authentication.getAuthorities().stream().anyMatch(r->r.getAuthority().equals("Candidato"));
        boolean temPapelRecrutador = authentication.getAuthorities().stream().anyMatch(r->r.getAuthority().equals("Recrutador"));

        if (temPapelRecrutador || temPapelCandidato) {
            response.sendRedirect("/dashboard/");
        }
    }
}
