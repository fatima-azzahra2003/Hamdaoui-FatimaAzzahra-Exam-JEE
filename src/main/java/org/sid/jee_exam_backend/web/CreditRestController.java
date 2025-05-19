package org.sid.jee_exam_backend.web;

import org.sid.jee_exam_backend.dtos.CreditDTO;
import org.sid.jee_exam_backend.service.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits")
public class CreditRestController {
    private final CreditService creditService;

    public CreditRestController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping
    public List<CreditDTO> getCredits() {
        return creditService.listCredits();
    }

    @GetMapping("/{id}")
    public CreditDTO getCredit(@PathVariable Long id) {
        return creditService.getCredit(id);
    }

    @PostMapping
    public CreditDTO saveCredit(@RequestBody CreditDTO creditDTO) {
        return creditService.saveCredit(creditDTO);
    }

    @PutMapping("/{id}")
    public CreditDTO updateCredit(@PathVariable Long id, @RequestBody CreditDTO creditDTO) {
        creditDTO.setId(id);
        return creditService.saveCredit(creditDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
    }
}