package za.ac.cput.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/*Name: Nolubabalo Ndongeni
Student number: 219319464
SecurityConfig.java
27 September 2022
*/

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/patient/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/patient/readPatient").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/patient/deletePatient").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/patient/getPatients").hasRole("USER")
                .and()
                .httpBasic()
                .csrf().disable()
                .formLogin().disable();*/

        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.csrf().disable()
                    .authorizeRequests().antMatchers(HttpMethod.POST, "/testPatient/save").hasRole("ADMIN")
                    .antMatchers(HttpMethod.GET, "/testPatient/getTestPatient").hasRole("USER")
                    .antMatchers(HttpMethod.DELETE, "/testPatient/deleteTestPatient").hasRole("ADMIN")
                    .antMatchers(HttpMethod.GET, "/testPatient/getTestPatients").hasRole("USER")
                    .anyRequest().authenticated()
                    .and().httpBasic();




        /*http.httpBasic()
                .add()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/testPatient/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/testPatient/getTestPatient").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/testPatient/deleteTestPatient").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/testPatient/getTestPatients").hasRole("USER")
                .add()
                .csrf().disable()
                .formLogin().disable();*/
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication)
            throws Exception
    {
        authentication.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("nimda"))
                .authorities("ROLE_USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /*
    @Bean
    public PasswordEncoder encoder(){
        return newBCryptPasswordEncoder()
    }

    private PasswordEncoder newBCryptPasswordEncoder() {
    }*/


}
