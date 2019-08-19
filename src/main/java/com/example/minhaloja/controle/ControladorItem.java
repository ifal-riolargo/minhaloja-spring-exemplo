package com.example.minhaloja.controle;

import com.example.minhaloja.modelo.Item;
import com.example.minhaloja.repositorios.RepositorioItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ControladorItem{
    
    @Autowired
    RepositorioItem repositorioItem;

    @RequestMapping("/formulario_item")
    public ModelAndView formularioItem(){
        ModelAndView retorno = new ModelAndView("cadastroItens.html");
        return retorno;
    }

    @RequestMapping("/novo_item")
    public ModelAndView novoItem(Item item){
        repositorioItem.save(item);
        ModelAndView retorno = new ModelAndView("index.html");
        return retorno;
    }
}