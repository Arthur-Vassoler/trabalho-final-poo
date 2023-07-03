package br.edu.atitus.trabalhopoo.comums;

import br.edu.atitus.trabalhopoo.models.UserModel;
import br.edu.atitus.trabalhopoo.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {
  private final JwtUtils jwtUtils;
  private final UserService userService;

  public AuthTokenFilter(JwtUtils jwtUtils, UserService userService) {
    super();
    this.jwtUtils = jwtUtils;
    this.userService = userService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {
    try {
      String jwt = jwtUtils.getJwtFromRequest(request);

      if (jwt != null && jwtUtils.validaJwtToken(jwt)) {
        String emailUsuario = jwtUtils.getEmailFromJwtToken(jwt);
        UserModel usuario = (UserModel) userService.loadUserByUsername(emailUsuario);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
          usuario, null, usuario.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    } catch (Exception ignored) {}

    filterChain.doFilter(request, response);
  }
}