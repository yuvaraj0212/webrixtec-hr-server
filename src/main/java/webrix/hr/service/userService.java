package webrix.hr.service;

import java.util.Date;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import webrix.hr.entity.roleModel;
import webrix.hr.entity.userModel;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.pojo.signinRequest;
import webrix.hr.repo.userRepo;
import webrix.hr.util.JwtUtils;
import webrix.hr.util.userDetailsiImpl;
import webrix.hr.repo.roleRepo;

@Service
public class userService extends ExceptionController {
	@Autowired(required = true)
	private AuthenticationManager authenticationManager;
	@Autowired
	JwtUtils JwtUtils;
	@Autowired
	private userRepo userRepo;
	@Autowired
	private roleRepo roleRepo;

	@Value("${file.upload-dir}")
	String dir;

	public ResponseEntity<Object> sigin(signinRequest loginRequest) throws Exception {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = JwtUtils.generateJwtToken(authentication);
		userDetailsiImpl userDetails = (userDetailsiImpl) authentication.getPrincipal();
		userModel user = userRepo.findById(userDetails.getId())
				.orElseThrow(() -> new RuntimeException("user not found"));
		user.setToken(jwt);
		return response(HttpStatus.OK.value(), user);
	}

	public ResponseEntity<Object> signup(userModel user) {
		userModel userObj = new userModel();
		boolean emailExist = userRepo.existsByEmail(user.getEmail());
		if (emailExist) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"Email already exists");
		}
		userObj.setEmail(user.getEmail());
		userObj.setCreateDate(new Date());
		userObj.setName(user.getName());
		userObj.setAltEmail(user.getAltEmail());
		userObj.setAltPhone(user.getAltPhone());
		userObj.setCeo(user.getCeo());
		userObj.setCity(user.getCity());
		userObj.setCountry(user.getCountry());
		userObj.setNdaDate(user.getNdaDate());
		userObj.setRepName(user.getRepName());
		userObj.setPhone(user.getPhone());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode(user.getPassword());
		userObj.setPassword(encode);
		Set<roleModel> role = roleRepo.findByRolename("ROLE_PARTNER");
		System.out.println(role);
		userObj.setRoles(role);
		userRepo.save(userObj);
		return response(HttpStatus.OK.value(), "user created successfully", userObj);
	}

	public ResponseEntity<Object> getAllUserDetails() {
		List<userModel> users = userRepo.findAll();
		return response(HttpStatus.OK.value(), "userlist", users);
	}

	public ResponseEntity<Object> getDelUser(int id) {
		userModel user = userRepo.findById(id).get();
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		userRepo.delete(user);
		return response(HttpStatus.OK.value(), "user deleted succesFully");
	}

}
