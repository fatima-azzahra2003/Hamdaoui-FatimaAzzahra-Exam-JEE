package org.sid.jee_exam_backend.web;

import org.sid.jee_exam_backend.dtos.RemboursementDTO;
import org.sid.jee_exam_backend.service.RemboursementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remboursements")
public class RemboursementRestController {
    private final RemboursementService remboursementService;

    public RemboursementRestController(RemboursementService remboursementService) {
        this.remboursementService = remboursementService;
    }

    @GetMapping
    public List<RemboursementDTO> getRemboursements() {
        return remboursementService.listRemboursements();
    }

    @GetMapping("/{id}")
    public RemboursementDTO getRemboursement(@PathVariable Long id) {
        return remboursementService.getRemboursement(id);
    }

    @PostMapping
    public RemboursementDTO saveRemboursement(@RequestBody RemboursementDTO remboursementDTO) {
        return remboursementService.saveRemboursement(remboursementDTO);
    }

    @PutMapping("/{id}")
    public RemboursementDTO updateRemboursement(@PathVariable Long id, @RequestBody RemboursementDTO remboursementDTO) {
        remboursementDTO.setId(id);
        return remboursementService.saveRemboursement(remboursementDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRemboursement(@PathVariable Long id) {
        remboursementService.deleteRemboursement(id);
    }
}
