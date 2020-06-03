//package com.accolite.aumanagement.candidate_management.security.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.accolite.aumanagement.candidate_management.security.model.AccoliteUser;
//import com.accolite.aumanagement.candidate_management.security.model.AccoliteUserDetails;
//import com.accolite.aumanagement.candidate_management.security.repository.AccoliteUserRepository;
//
//@Service
//public class AccoliteUserDetailsService implements UserDetailsService
//{
//	
//	@Autowired
//	AccoliteUserRepository accoliteUserRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
//		Optional<AccoliteUser> accoliteUser = Optional.of(accoliteUserRepository.findByEmailId(emailId));
//		
//		accoliteUser.orElseThrow(() -> new UsernameNotFoundException("Not Found"));
//		
//		return accoliteUser.map(AccoliteUserDetails::new).get();
//	}
//	
//
//	
//}
