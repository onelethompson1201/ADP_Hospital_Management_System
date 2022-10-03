package za.ac.cput.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*Name: Nolubabalo Ndongeni
Student number: 219319464
SecurityConfig.java
27 September 2022
*/

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //super.configure(http);
        http.httpBasic()
                .add()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/patient/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/patient/readPatient").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/patient/deletePatient").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/patient/getPatients").hasRole("USER")
                .add()
                .csrf().disable()
                .formLogin().disable();


        http.httpBasic()
                .add()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/testPatient/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/testPatient/getTestPatient").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/testPatient/deleteTestPatient").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/testPatient/getTestPatients").hasRole("USER")
                .add()
                .csrf().disable()
                .formLogin().disable();
    }



}
