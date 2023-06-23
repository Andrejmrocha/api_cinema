package jonaxPlex.api.controller;

import jonaxPlex.api.domain.usuario.Usuario;
import jonaxPlex.api.infra.security.DadosLogin;
import jonaxPlex.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public String login(@RequestBody DadosLogin dadosLogin){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(dadosLogin.login(), dadosLogin.senha());
        Authentication authentication =
                this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Usuario) authentication.getPrincipal();

        return tokenService.gerarToken(usuario);
    }

}
