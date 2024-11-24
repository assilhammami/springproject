package tn.esprit.tic.web.springprojrct.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tic.web.springprojrct.entities.Foyer;
import tn.esprit.tic.web.springprojrct.service.IFoyerService;
@RequestMapping("/foyer")
@AllArgsConstructor
@RestController
public class FoyerController {
    IFoyerService foyerService;
    @PostMapping("/addFoyerWithBloc")
    public Foyer addFoyerWithBloc(@RequestBody Foyer f) {
        return foyerService.addFoyerWithBloc(f);
    }
}
