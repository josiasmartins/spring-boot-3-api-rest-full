package med.voll.api.infra.security;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.domain.usuario.UsuarioRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("CHAMEI");
        System.out.println(request);
        System.out.println(response);
        System.out.println((filterChain));

        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT);

            System.out.println(subject+ " SUBJECT CHAMADA");

            var usuario = this.repository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            System.out.println("LOGADO NA REQUISICAO");
        }

        // FilterChain: representa a cadeia de filtros na aplicação
        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
//        if (authorizationHeader == null) {
//            throw new RuntimeException("Token JWT não enviado no cabeçalho Authorization!");
//        }
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }

        return null;
    }

}