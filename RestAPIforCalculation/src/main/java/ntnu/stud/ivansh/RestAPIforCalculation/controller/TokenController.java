package ntnu.stud.ivansh.RestAPIforCalculation.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import ntnu.stud.ivansh.RestAPIforCalculation.model.LoginRequest;
import ntnu.stud.ivansh.RestAPIforCalculation.repositoryJpa.UserRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping(value = "/token")
@EnableAutoConfiguration
@CrossOrigin
public class TokenController {

    // keyStr is hardcoded here for testing purpose
    // in a real scenario, it should either be stored in a database or injected from the environment
    public static final String keyStr = "testsecrettestsecrettestsecrettestsecrettestsecret";
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(5);

    private UserRepository userRepository;

    public TokenController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String generateToken(final @RequestBody LoginRequest loginRequest) throws Exception {
        // if username and password are valid, issue an access token
        // note that subsequent requests need this token
        if (userRepository.findByName(loginRequest.getUsername())!=null) {
            if (userRepository.findByName(loginRequest.getUsername())
                    .getPassword().equals(loginRequest.getPassword())) {
                return generateToken(loginRequest.getUsername());
            }else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password");
        }else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong username");

    }

    public String generateToken(final String userId) {
        final Instant now = Instant.now();
        final Algorithm hmac512 = Algorithm.HMAC512(keyStr);;
        final JWTVerifier verifier = JWT.require(hmac512).build();
        return JWT.create()
                .withSubject(userId)
                .withIssuer("idatt2105_token_issuer_app")
                .withIssuedAt(now)
                .withExpiresAt(now.plusMillis(JWT_TOKEN_VALIDITY.toMillis()))
                .sign(hmac512);
    }
}