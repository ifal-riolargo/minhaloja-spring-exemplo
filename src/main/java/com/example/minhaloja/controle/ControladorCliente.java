package com.example.minhaloja.controle;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.example.minhaloja.modelo.Cliente;
import com.example.minhaloja.repositorios.RepositorioCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ControladorCliente{

    @Autowired
    RepositorioCliente repositorioCliente;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView retorno = new ModelAndView("index.html");
        return retorno;
    }

    @RequestMapping("/formulario_cliente")
    public ModelAndView formularioCliente(){
        ModelAndView retorno = new ModelAndView("cadastroCliente.html");
        
        
        return retorno;
    }

    @RequestMapping("/novo_cliente")
    public ModelAndView cadastroCliente(Cliente cliente){
        ModelAndView retorno = new ModelAndView("index.html");

        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Cliente>> violacoes = validador.validate(cliente);

        System.out.println(violacoes.size());
        for (ConstraintViolation var : violacoes) {
            System.out.println(var.getMessage());
        }

        repositorioCliente.save(cliente);
        
        return retorno;
    }

}