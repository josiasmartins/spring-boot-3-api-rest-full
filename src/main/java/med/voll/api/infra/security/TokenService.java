package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import med.voll.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {

        System.out.println(secret);

        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Voll.med") // quem está gerando esse token
                    .withSubject(usuario.getLogin()) // quem o dono do token
                    // withClaim recebe dois parâmetros, sendo o primeiro uma String que identifica o nome do claim
                    // (propriedade armazenada no token), e o segundo a informação que se deseja armazenar.
                    // .withClaim("id", usuario.getId()
                    .withExpiresAt(dataExpericao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            // Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }

    }

    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            System.out.println(algorithm+ " TOKEN JWT");
            return JWT.require(algorithm)
                    // specify an specific claim validations
                    .withIssuer("API Voll.med")
                    // reusable verifier instance
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
           throw new RuntimeException("Token JWT inválido ou expirado");
        }
    }

    private Instant dataExpericao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
