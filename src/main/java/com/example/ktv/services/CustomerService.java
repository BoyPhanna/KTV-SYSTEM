package com.example.ktv.services;

import com.example.ktv.entities.CustomerEntity;
import com.example.ktv.exceptions.BaseException;
import com.example.ktv.exceptions.CustomerException;
import com.example.ktv.models.Customer.Request.CustomerRequestLogin;
import com.example.ktv.models.Customer.Request.CustomerRequestRegister;
import com.example.ktv.models.Customer.Request.CustomerRequestVerify;
import com.example.ktv.models.Customer.Response.CustomerResponseRegisterSuccess;
import com.example.ktv.repositories.CustomerRepository;
import com.example.ktv.utils.Validators;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {
    private final TokenService tokenService;
    private  final CustomerRepository customerRepository;
    private final EmailService emailService;
    public final PasswordEncoder passwordEncoder;

    public CustomerService(TokenService tokenService, CustomerRepository customerRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.tokenService = tokenService;
        this.customerRepository = customerRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    public CustomerResponseRegisterSuccess register(CustomerRequestRegister customerRequestRegister)throws BaseException {
        Random random=new Random();
        if (Objects.isNull(customerRequestRegister.getPassword()) || Objects.isNull(customerRequestRegister.getConfirmPassword())){
            throw CustomerException.passwordIsNull();
        }
        if(!Validators.isValidGender(customerRequestRegister.getGender())){
            throw CustomerException.genderIncorrect();
        }
        if (customerRequestRegister.getName().isEmpty()){
            throw CustomerException.nameIsEmpty();
        }
        if(!Validators.isValidName(customerRequestRegister.getName())){
            throw  CustomerException.nameIncorrect();
        }
        if(!Validators.isValidPhoneNumber(customerRequestRegister.getPhone())){
            throw  CustomerException.phoneIncorrect();
        }
        if(!Validators.isValidEmail(customerRequestRegister.getEmail())){
            throw  CustomerException.emailIncorrect();
        }
        if(!Objects.equals(customerRequestRegister.getPassword(), customerRequestRegister.getConfirmPassword())){
            throw  CustomerException.passwordNotMatch();
        }
        if(customerRequestRegister.getPassword().length()<8){
            throw  CustomerException.passwordNotSecurity();
        }
        if(Objects.isNull(customerRequestRegister.getName())){
            throw CustomerException.nameIsNull();
        }
        if(Objects.isNull(customerRequestRegister.getDob())){
            throw  CustomerException.dobIsNull();
        }
        if(Objects.isNull(customerRequestRegister.getGender())){
            throw CustomerException.genderIsNull();
        }
        if(customerRepository.existsByEmail(customerRequestRegister.getEmail())){
            throw CustomerException.emailIsExists();
        }

        CustomerEntity customer=new CustomerEntity();
        customerRequestRegister.modelToEntity(customer);

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setCreateAt(LocalDateTime.now());
        Integer verifyCode=random.nextInt(100000);
        customer.setVerifyCode(passwordEncoder.encode(verifyCode.toString()));

        try {
            emailService.sendVerifyCode(customer.getEmail(),customer.getName(),verifyCode.toString());
        } catch (IOException e) {
            throw CustomerException.verifyFailed();
        }


        customer=customerRepository.save(customer);

        CustomerResponseRegisterSuccess customerResponseRegisterSuccess=new CustomerResponseRegisterSuccess();
        customerResponseRegisterSuccess.entityToModel(customer);
        System.out.println("Verify code : "+verifyCode);
        return  customerResponseRegisterSuccess;
    }
    public String login(CustomerRequestLogin customerRequestLogin)throws BaseException{
        if(Objects.isNull(customerRequestLogin.getEmail())){
            throw CustomerException.loginFailed();
        }
        if(Objects.isNull(customerRequestLogin.getPassword())){
            throw CustomerException.loginFailed();
        }
        Optional<CustomerEntity> customer=customerRepository.findByEmail(customerRequestLogin.getEmail());
        if(customer.isEmpty()){
            throw CustomerException.loginFailed();
        }
       CustomerEntity customer1=customer.get();
        if(!Objects.isNull(customer1.getVerifyCode())){
            throw CustomerException.accountNotVerify();
        }
        if(passwordEncoder.matches(customerRequestLogin.getPassword(),customer1.getPassword())){
            return tokenService.tokenize(customer1) ;
        }
     return null;
    }

    public String verifyAccount(CustomerRequestVerify customerRequestVerify)throws BaseException{
        if (!Validators.isValidEmail(customerRequestVerify.getEmail())){
            throw CustomerException.emailIncorrect();
        }
        if(Objects.isNull(customerRequestVerify.getVerifyCode())){
            throw CustomerException.verifyCodeIsNull();
        }
        Optional<CustomerEntity> customer=customerRepository.findByEmail(customerRequestVerify.getEmail());
        if(customer.isEmpty()){
            throw CustomerException.verifyFailed();
        }
        CustomerEntity customer1=customer.get();
        if(Objects.isNull(customer1.getVerifyCode())){
            throw CustomerException.verifyFailed();
        }
        if(passwordEncoder.matches(customerRequestVerify.getVerifyCode(),customer1.getVerifyCode())){
            customer1.setVerifyCode(null);
            customer1.setRole("CUSTOMER");
            customer1.setVerifyCode(null);
            customer1= customerRepository.save(customer1);

            return "token: "+tokenService.tokenize(customer1);
        }else {
            throw CustomerException.verifyFailed();
        }

    }


}
