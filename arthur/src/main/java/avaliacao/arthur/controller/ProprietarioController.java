package avaliacao.arthur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import avaliacao.arthur.model.Proprietario;
import avaliacao.arthur.repository.ProprietarioRepository;

@Controller
public class ProprietarioController {
    
    @Autowired
    private ProprietarioRepository proprietarioRepository;
    
    @GetMapping("/cad-prop")
    public String formProprietario(Model model) {
        model.addAttribute("proprietario", new Proprietario());
        return "form_prop";
    }
    
    @PostMapping("/cad-prop")
    public String salvarProprietario(Proprietario proprietario) {
        proprietarioRepository.save(proprietario);
        return "redirect:/rel-prop";
    }
    
    @GetMapping("/rel-prop")
    public String relatorioProprietarios(Model model) {
        model.addAttribute("proprietarios", proprietarioRepository.findAllByOrderByNomeAsc());
        return "rel_prop";
    }
}
