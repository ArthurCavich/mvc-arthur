package avaliacao.arthur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import avaliacao.arthur.model.Apartamento;
import avaliacao.arthur.model.Proprietario;
import avaliacao.arthur.repository.ApartamentoRepository;
import avaliacao.arthur.repository.ProprietarioRepository;

@Controller
public class ApartamentoController {
    
    @Autowired
    private ApartamentoRepository apartamentoRepository;
    
    @Autowired
    private ProprietarioRepository proprietarioRepository;
    
    // Página inicial - cadastro apartamento
    @GetMapping("/")
    public String formApartamento(Model model) {
        model.addAttribute("apartamento", new Apartamento());
        
        List<Proprietario> proprietarios = proprietarioRepository.findAllByOrderByNomeAsc();
        model.addAttribute("proprietarios", proprietarios);
        
        return "form_apto";
    }
    
    // ADICIONE ESTE MÉTODO - para acessar /cad-apto via GET
    @GetMapping("/cad-apto")
    public String formApartamentoCadastro(Model model) {
        model.addAttribute("apartamento", new Apartamento());
        
        List<Proprietario> proprietarios = proprietarioRepository.findAllByOrderByNomeAsc();
        model.addAttribute("proprietarios", proprietarios);
        
        return "form_apto";
    }
    
    // Salvar apartamento (POST)
    @PostMapping("/cad-apto")
    public String salvarApartamento(Apartamento apartamento) {
        apartamentoRepository.save(apartamento);
        return "redirect:/rel-apto";
    }
    
    // Relatório apartamentos
    @GetMapping("/rel-apto")
    public String relatorioApartamentos(Model model) {
        model.addAttribute("apartamentos", apartamentoRepository.findAllByOrderByNumeroPortaAsc());
        return "rel_apto";
    }
}