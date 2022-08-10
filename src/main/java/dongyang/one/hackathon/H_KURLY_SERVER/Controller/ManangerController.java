package dongyang.one.hackathon.H_KURLY_SERVER.Controller;

import dongyang.one.hackathon.H_KURLY_SERVER.Dto.ManagerAddDto;
import dongyang.one.hackathon.H_KURLY_SERVER.Entity.Manager;
import dongyang.one.hackathon.H_KURLY_SERVER.Service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class ManangerController {

    private final ManagerService managerService;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Manager employeeAdd(
            @Valid @RequestBody final ManagerAddDto.Request request
    ){
        return managerService.employeeAdd(request);
    }
}
