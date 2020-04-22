package lk.ijse.bikereservation.controller;

import lk.ijse.bikereservation.config.JwtTokenUtil;
import lk.ijse.bikereservation.dto.ApiResponse;
import lk.ijse.bikereservation.dto.AuthToken;
import lk.ijse.bikereservation.dto.LoginUser;
import lk.ijse.bikereservation.entity.Guest;
import lk.ijse.bikereservation.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private GuestService userService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {
            return null;
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
//        final Guest user = userService.findOne(loginUser.getUsername());
//        final String token = jwtTokenUtil.generateToken(user);
//        return new ApiResponse<>(200, "success",new AuthToken(token, user.getUserName()));
    }

}
