package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private MySuccessHandler mySuccessHandler;

    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        http
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/sites")
                    .failureUrl("/login")
                    .successHandler(mySuccessHandler)
                    .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                .logout();
    }
}
